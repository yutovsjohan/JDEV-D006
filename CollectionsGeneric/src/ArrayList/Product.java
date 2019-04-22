package ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {
	String id;
	String name;
	int unitPrice;
	
	public Product() {
		super();
		this.id = "";
		this.name = "";
		this.unitPrice = 0;
	}

	public Product(String id, String name, int unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		if(unitPrice>0){
			this.unitPrice = unitPrice;
		}
		else{
			this.unitPrice = 0;
		}
	}
	
	public void input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Input id: ");
		this.id=sc.nextLine();
		
		sc = new Scanner(System.in);
		System.out.print("Input name: ");
		this.name=sc.nextLine();
		
		do{
			try {
				sc = new Scanner(System.in);
				System.out.print("Input unit price: ");
				this.unitPrice=sc.nextInt();
				
				if(this.unitPrice<0){
					System.out.println("Invalid amount");
					this.unitPrice=0;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}
		}while(this.unitPrice==0);
	}
	
	public void output(){
		System.out.println("ID: "+this.id + "\nName: "+this.name+"\nUnit price: "+this.unitPrice+"\n");
	}
	
	@Override
	public String toString() {
		String s= "ID: "+this.id + "\nName: "+this.name+"\nUnit price: "+this.unitPrice+"\n";
		return s;
	}
	
}