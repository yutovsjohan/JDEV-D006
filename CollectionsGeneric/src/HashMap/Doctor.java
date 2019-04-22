package HashMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Doctor {
	String id;
	String name;
	int availHours;
	public Doctor(String id, String name, int availHours) {
		super();
		this.id = id;
		this.name = name;
		this.availHours = availHours;
	}
	public Doctor() {
		super();
		this.id = "";
		this.name = "";
		this.availHours = 0;
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
	public int getAvailHours() {
		return availHours;
	}
	public void setAvailHours(int availHours) {
		if(availHours>0){
			this.availHours = availHours;
		}
		else{
			this.availHours=0;
		}
	}
	@Override
	public String toString() {
		String st="id: "+this.id+"\tname: "+this.name+"\tavailHours: "+this.availHours;
		return st;
	}
	
	public void input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("input id: ");
		this.id=sc.nextLine();
		
		sc = new Scanner(System.in);
		System.out.print("input name: ");
		this.name=sc.nextLine();
		
		while(true) {
			try {
				sc = new Scanner(System.in);
				System.out.print("input availHours: ");
				this.availHours=sc.nextInt();
				
				if(this.availHours<0) {
					System.out.println("Invalid amount");
				}
				else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid value");
			}
		}	
		
	}
	
}