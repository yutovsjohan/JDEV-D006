package BookManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {
	int id;
	String title;
	int price;
	int idcate;
	public Book(int id, String title, int price, int idcate) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.idcate = idcate;
	}
	public Book() {
		super();
		this.id = 0;
		this.title = "";
		this.price = 0;
		this.idcate = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getIdcate() {
		return idcate;
	}
	public void setIdcate(int idcate) {
		this.idcate = idcate;
	}
	
	Connection cn = new MyConnect().getcn();
	
	public void display() {
		String sql="select * from book";
		
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("---------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt("id") + ". " + rs.getString("title") + " - " +rs.getInt("price") +" vnd");
			}
			System.out.println("---------------------------");
		} catch (SQLException e) {
			System.out.println("error display");
		}
	}
	
	public void displayByCategory() {
		String sql="select * from category";
		String sql2="";
		Category c = new Category();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("- Category: "+rs.getString("name"));
				c.setId(rs.getInt("id"));
				sql2 =  "select * from book where idcate = ?";
				try {
					PreparedStatement ps1 = cn.prepareStatement(sql2);
					ps1.setInt(1, c.getId());
					ResultSet rs1 = ps1.executeQuery();
					
					while(rs1.next()) {
						System.out.println(rs1.getInt("id") + " - " + rs1.getString("title") + " - " +rs1.getInt("price") +" vnd");
					}
				} catch (SQLException e) {
					System.out.println("error display");
				}				
			}
			
		} catch (SQLException e) {
			System.out.println("error display");
		}
	}
	
	public void add() {
		Book a = new Book();
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
		System.out.print("Input tilte: ");
		a.setTitle(sc.nextLine());
		
		while(true) {
			try {
				sc=new Scanner(System.in);
				System.out.print("Input price: ");
				a.setPrice(sc.nextInt());
				
				if(a.getPrice()<0) {
					System.out.println("Price must be positive");
				}
				else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}			
		}
		
		while(true) {
			try {
				sc=new Scanner(System.in);
				System.out.println("Select a category below");
				Category c = new Category();
				c.display();
				System.out.print("Your selection: ");
				a.setIdcate(sc.nextInt());
				
				c.setId(a.getIdcate());
				
				if(c.checkID(c)) {
					break;
				}
				else {
					System.out.println("Wrong selection");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}			
		}
		
		String sql="insert into book values (?,?,?,?)";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, a.id);
			ps.setString(2, a.title);
			ps.setInt(3, a.price);
			ps.setInt(4, a.idcate);
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
		Book a = new Book();
		a.display();
		int select;
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
		System.out.print("Input new title: ");
		a.setTitle(sc.nextLine());
		
		while(true){
			try {
				sc = new Scanner(System.in);
				System.out.print("Input new price: ");
				a.setPrice(sc.nextInt());
				
				if(a.getPrice()<0) {
					System.out.println("Price can't be negative");
				}
				else {
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
		}
		
		while(true) {
			try {
				sc=new Scanner(System.in);
				System.out.println("Input new category");
				System.out.println("Select a category below");
				Category c = new Category();
				c.display();
				System.out.print("Your selection: ");
				a.setIdcate(sc.nextInt());
				
				c.setId(a.getIdcate());
				
				if(c.checkID(c)) {
					break;
				}
				else {
					System.out.println("Wrong selection");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}			
		}
				
		String sql = "update book set title = ?, price = ?, idcate = ? where id = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, a.title);
			ps.setInt(2, a.price);
			ps.setInt(3, a.idcate);
			ps.setInt(4, a.id);
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
		Book a = new Book();
		a.display();
		
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
		
		String sql="delete from book where id = ?";
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
			System.out.println("error delete");
		}
	}
		
		
		
	
	public boolean checkID(Book a){
		boolean f=true;
		try {
			
			PreparedStatement ps = cn.prepareStatement("select * from book");
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
