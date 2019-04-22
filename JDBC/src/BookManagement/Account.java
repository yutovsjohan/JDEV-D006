package BookManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {
	String username;
	String password;
	int role;
	
	public Account(String username, String password, int role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public Account() {
		super();
		this.username = "";
		this.password = "";
		this.role = 0;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	Connection cn = new MyConnect().getcn();
	
	public int login(){
		Account a = new Account();
		Scanner sc = new Scanner(System.in);
		System.out.print("Input username: ");
		a.setUsername(sc.nextLine());
		
		sc = new Scanner(System.in);
		System.out.print("Input password: ");
		a.setPassword(sc.nextLine());
		
		String sql = "select * from account where username = ?";
		PreparedStatement ps;
		try {
			ps = cn.prepareStatement(sql);
			ps.setString(1, a.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(a.getPassword().equalsIgnoreCase(rs.getString("password"))){
					return rs.getInt("role");
				}
				else{
					System.out.println("Password is wrong");
				}
			}
			else{
				System.out.println("Username is not exist");
			}
			
		} catch (SQLException e) {
			System.out.println("Error");
		}
		return -1;
	}
	
}