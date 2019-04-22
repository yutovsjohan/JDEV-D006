package AdminManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class Admin {
	int id;
	String username;
	String password;
	String email;
	int role;		
	
	public Admin(int id, String username, String password, String email, int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	public Admin() {
		super();
		this.id = 0;
		this.username = "";
		this.password = "";
		this.email = "";
		this.role = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

	Connection cn = new MyConnect().getcn();
	
	public void input() {
		Scanner sc;
		boolean f=true;
		
		while(true) {
			try {
				sc=new Scanner(System.in);
				System.out.print("Input id: ");
				this.id = sc.nextInt();
				
				try {
					PreparedStatement ps = cn.prepareStatement("select * from admin");
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						if(rs.getInt(1)==this.id) {
							f=true;
							break;
						}
						else {
							f=false;
						}
					}
					
					if(f) {
						System.out.println("ID existed");
					}
					else {
						break;
					}
				} catch (SQLException e1) {
					System.out.println("error");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
		}		
		
		sc=new Scanner(System.in);
		System.out.print("Input username: ");
		this.username = sc.nextLine();
		
		sc=new Scanner(System.in);
		System.out.print("Input password: ");
		this.password= sc.nextLine();
		
		sc=new Scanner(System.in);
		System.out.print("Input email: ");
		this.email = sc.nextLine();
		
		while(true) {
			try {
				sc=new Scanner(System.in);
				System.out.print("Input role: ");
				this.role = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
		}
		
	}
	
	public void display() {
		String sql="select * from admin";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("username\t\temail\t\trole");
			while(rs.next()) {
				System.out.println(rs.getString("username")+"\t\t"+rs.getString("email")+"\t\t"+rs.getString("role")+"\t\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insert() {
		Admin a = new Admin();
		a.input();
		String sql="insert into admin values (?,?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, a.id);
			ps.setString(2, a.username);
			ps.setString(3, a.password);
			ps.setString(4, a.email);
			ps.setInt(5, a.role);
			try {
				int kq=ps.executeUpdate();
				if(kq==0) {
					System.out.println("Insert fail");
				}
				else {
					System.out.println("Insert success");
				}
			} catch (SQLTimeoutException e) {
				System.out.println("2");
			}
			
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}
	
	public void update() {
		Admin a = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input username: ");
		a.setUsername(sc.nextLine());
		
		sc = new Scanner(System.in);
		System.out.print("Input new password: ");
		a.setPassword(sc.nextLine());
				
		String sql = "update admin set password = ? where username = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, a.password);
			ps.setString(2, a.username);
			int kq = ps.executeUpdate();
			if(kq==0) {
				System.out.println("Update fail");
			}
			else {
				System.out.println("Update success");
			}
		} catch (SQLException e) {
			System.out.println("ERROR");
		}		
	}
	
	public void delete() {
		Admin a = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input username: ");
		a.setUsername(sc.nextLine());
		
		String sql="delete from admin where username = ?";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, a.username);
			int kq= ps.executeUpdate();
			if(kq==0) {
				System.out.println("Delete fail");
			}
			else {
				System.out.println("Delete success");
			}
		} catch (SQLException e) {
			System.out.println("ErrOr");
		}
	}
	
	public void search() {
		Admin a = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input username: ");
		a.setUsername(sc.nextLine());
		
		String sql="select * from admin where username = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, a.username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("username\t\temail\t\trole");
				System.out.println(rs.getString("username")+"\t\t"+rs.getString("email")+"\t\t"+rs.getString("role")+"\t\t");
			}
			else {
				System.out.println("Not Found");
			}
		} catch (SQLException e) {
			System.out.println("eRRoR");
		}
	}
	
}
