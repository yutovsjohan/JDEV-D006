package TreeMapGeneric;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Book {
	String bookID;
	String theLoai;
	String tieuDe;
	String tacGia;
	int price;

	public Book() {
		super();
		this.bookID = "";
		this.theLoai = "";
		this.tieuDe = "";
		this.tacGia = "";
		this.price = 0;
	}

	public Book(String bookID, String theLoai, String tieuDe, String tacGia, int price) {
		super();
		this.bookID = bookID;
		this.theLoai = theLoai;
		this.tieuDe = tieuDe;
		this.tacGia = tacGia;
		this.price = price;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price > 0) {
			this.price = price;
		} else {
			this.price = 0;
		}
	}
	
	@Override
	public String toString() {
		return "id: "+this.bookID+"\t\the loai: "+this.theLoai+"\t\ttieu de: "+this.tieuDe+"\t\ttac gia: "+this.tacGia+"\t\tprice: "+this.price;
	}
	
	public void input(){
		Scanner sc = new Scanner(System.in);
		while(true){			
			System.out.print("input id book: ");
			this.bookID=sc.nextLine();
			
			if(this.bookID.matches("B[0-9]{4}-A[0-9]{2}")){
				break;
			}
			else{
				System.out.println("Id default: Bxxxx-Axx");
			}
		}
		
		System.out.print("input the loai: ");
		this.theLoai=sc.nextLine();
				
		while(true){
			sc = new Scanner(System.in);
			System.out.print("input tieu de: ");
			this.tieuDe=sc.nextLine();
			
			if(this.tieuDe.isEmpty() || this.tieuDe.matches("\\s+")){
				System.out.println("Tieu de must not be blank");
			}
			else{
				break;
			}
		}
		
		while(true){
			sc = new Scanner(System.in);
			System.out.print("input tac gia: ");
			this.tacGia=sc.nextLine();
			
			if(this.tacGia.isEmpty() || this.tacGia.matches("\\s+")){
				System.out.println("Tac gia must not be blank");
			}
			else{
				break;
			}
		}
		
		while(true) {
			try {
				sc = new Scanner(System.in);
				System.out.print("input price: ");
				this.price=sc.nextInt();
				
				if(this.price>0) {
					break;
				}
				else {
					System.out.println("Invalid amount");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid value");
			}
		}
		
	}

}
