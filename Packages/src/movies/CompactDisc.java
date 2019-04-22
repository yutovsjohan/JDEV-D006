package movies;

import java.util.Scanner;

public class CompactDisc {
	String title;
	int price;
	int code;
	
	public CompactDisc() {
		this.title = "";
		this.price = 0;
		this.code = 0;
	}

	public CompactDisc(String title, int price, int code) {
		this.title = title;
		this.price = price;
		this.code = code;
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
		if(price>0) {
			this.price = price;
		}
		else {
			this.price=0;
		}
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public void nhap() {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("Title: ");
		this.title=sc.nextLine();
		
		sc = new Scanner(System.in);
		System.out.print("Price: ");
		this.price=sc.nextInt();
		
		sc = new Scanner(System.in);
		System.out.print("Code: ");
		this.code=sc.nextInt();
	}
	
	public void xuat(){
		System.out.println("\nTitle: "+title);
		System.out.println("Price: "+price);
		System.out.println("Code: "+code);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
