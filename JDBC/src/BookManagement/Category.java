package BookManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Category {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category() {
		super();
		this.id = 0;
		this.name = "";
	}
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	Connection cn = new MyConnect().getcn();
	
	public void display() {
		String sql="select * from category";
		
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("---------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("id")+". "+rs.getString("name"));
			}
			System.out.println("---------------------------");
		} catch (SQLException e) {
			System.out.println("error display");
		}
	}
	
	public void displayBook() {
		Category a = new Category();
		a.display();
		int select;
		Scanner sc;
		while(true){
			try {
				sc = new Scanner(System.in);
				System.out.print("Input number you want: ");
				a.setId(sc.nextInt());
				
				if(checkID(a)){
					break;
				}
				else{
					System.out.println("The number is not available");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
		}
		
		String s1 = "select * from category where id = ?";
		PreparedStatement p1;
		try {
			p1 = cn.prepareStatement(s1);
			p1.setInt(1, a.getId());
			ResultSet r1=p1.executeQuery();
			if(r1.next()){
				a.setName(r1.getString("name"));
			}
			String sql = "select title, (select count(id) from book where idcate=? group by idcate) sl from book where idcate = ?";
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				ps.setInt(1, a.id);
				ps.setInt(2, a.id);
				ResultSet rs = ps.executeQuery();
				System.out.println("Category: "+a.name);
				int sl = 0;
				while(rs.next()) {
					System.out.println("- "+rs.getString("title"));
					sl=rs.getInt("sl");
				}
				System.out.println("Total books: "+sl);
			} catch (SQLException e) {
				System.out.println("error display book 1");
			}
		} catch (SQLException e1) {
			System.out.println("error display book 2");
		}
		
	}
	
	public void add() {
		Category a = new Category();
		
		Scanner sc;
		
		
		while(true){
			try {
				sc=new Scanner(System.in);
				System.out.print("Input id: ");
				a.setId(sc.nextInt());
				
				if(checkID(a))
					System.out.println("ID existed");
				else
					break;
					
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
		}
		
		sc=new Scanner(System.in);
		System.out.print("Input name: ");
		a.setName(sc.nextLine());
		
		String sql="insert into category values (?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, a.id);
			ps.setString(2, a.name);
			try {
				int kq=ps.executeUpdate();
				if(kq==0) {
					System.out.println("Insert fail");
				}
				else {
					System.out.println("Insert success");
				}
			} catch (SQLTimeoutException e) {
				System.out.println("Error add 1");
			}
			
		} catch (SQLException e) {
			System.out.println("Error add 2");
		}
	}
	
	public void update() {
		Category a = new Category();
		a.display();
		
		Scanner sc;
		while(true){
			try {
				sc = new Scanner(System.in);
				System.out.print("Input number you want update: ");
				a.setId(sc.nextInt());
				
				if(checkID(a)){
					break;
				}
				else{
					System.out.println("The number is not available");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
		}
		
		sc = new Scanner(System.in);
		System.out.print("Input new name: ");
		a.setName(sc.nextLine());
				
		String sql = "update category set name = ? where id = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, a.name);
			ps.setInt(2, a.id);
			int kq = ps.executeUpdate();
			if(kq==0) {
				System.out.println("Update fail");
			}
			else {
				System.out.println("Update success");
			}
		} catch (SQLException e) {
			System.out.println("error update");
		}		
	}
	
	public void delete() {
		Category a = new Category();
		a.display();
		int select;
		Scanner sc;
		while(true){
			try {
				sc = new Scanner(System.in);
				System.out.print("Input number you want delete: ");
				a.setId(sc.nextInt());
				
				if(checkID(a)){
					break;
				}
				else{
					System.out.println("The number is not available");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
		}
		
		String s1 = "select category.id, count(book.id) sl from book right join category on book.idcate = category.id where category.id=? group by idcate ";
		PreparedStatement p1;
		try {
			p1 = cn.prepareStatement(s1);
			p1.setInt(1, a.id);
			ResultSet r1 = p1.executeQuery();
			if(r1.next()){
				if(r1.getInt("sl")==0){
					String sql="delete from category where id = ?";
					PreparedStatement ps;
					try {
						ps = cn.prepareStatement(sql);
						ps.setInt(1, a.id);
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
				else{
					System.out.println("Category has many books");
				}
			}
			else{
				System.out.println("error delete 1");
			}
		} catch (SQLException e1) {
			System.out.println("error delete 2");
		}
	}
	
	public boolean checkID(Category a){
		boolean f=true;
		try {
			
			PreparedStatement ps = cn.prepareStatement("select * from category");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt(1)==a.id) {
					f=true;
					break;
				}
				else {
					f=false;
				}
			}
		} catch (SQLException e1) {
			System.out.println("error");
		}
		return f;
	}
	
	
	
}