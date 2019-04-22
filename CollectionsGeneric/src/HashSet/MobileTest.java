package HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class MobileTest {

	HashSet<Mobiles> list;
	
	public MobileTest() {
		super();
		list = new HashSet<>(10);
	}
	
	public void addMobile(){
		Mobiles a = new Mobiles();
		Scanner sc;
		
		while(true){
			sc = new Scanner(System.in);
			System.out.print("Input mobile id: ");
			a.setMobile_ID(sc.nextLine().toUpperCase());
			
			if(a.getMobile_ID().matches("^(SS|SM|NK|MT)*[0-9]{4}$")){
				if(checkID(a.getMobile_ID())) {
					System.out.println("Mobie id already exists !!!");
				}
				else {
					break;
				}
			}
			else {
				System.out.println("Invalid amount !!!");
			}				
		}

		switch(a.getMobile_ID().substring(0, 2)) {
		case "SM":
			a.setModel("Seimen");
			break;
		case "SS":
			a.setModel("Samsung");
			break;
		case "MT":
			a.setModel("Motorola");
			break;
		case "NK":
			a.setModel("Nokia");
			break;
		}
		
		while(true) {
			System.out.print("Input color: ");
			sc = new Scanner(System.in);

			a.setColor(sc.nextLine());
						
			if(a.getColor().matches("(\\s+)$") || a.getColor().isEmpty() ) {
				System.out.println("Invalid value !!!");
			}
			else {
				break;
			}			
		}
		
		while(true) {
			try {
				System.out.print("Input price: ");
				sc = new Scanner(System.in);

				a.setPrice(sc.nextInt());
				if(a.getColor().matches("[0-9]{1,8}$")) {
					System.out.println("Invalid amount ");
				}
				else if(a.getPrice()<=0 || a.getPrice()>=20000000){
					System.out.println("0 < price < 20 000 000");
				}
				else {
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid amount");
			}			
		}
		
		
		list.add(a);
		
	}
	
	public void displayAll(){
		if(list.size()==0){
			System.out.println("List is empty !!!");
		}
		else{
			Iterator<Mobiles> iterator = list.iterator();
	        Mobiles a;
	        int i=1;
	        while (iterator.hasNext()) {
	        	System.out.println(i+". ");
	            a = iterator.next();
	            a.output();
	            i++;
	        }
			
		}
	}
	
	public boolean checkID(String id) {
		Mobiles[] array = new Mobiles[list.size()];
		list.toArray(array);
		for (int i = 0; i < array.length; i++) {
			if(array[i].mobile_ID.equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void deteleMobile() {
		if(list.size()==0){
			System.out.println("List is empty !!!");
		}
		else {
			String st="",select="";
			boolean f = false;
			Scanner sc= new Scanner(System.in);
			
			System.out.print("Input mobile id need delete: ");
			st=sc.nextLine().toUpperCase();
			ArrayList<Mobiles> b = new ArrayList<Mobiles>(1);
			Mobiles[] array = new Mobiles[list.size()];
			list.toArray(array);
			for (int i = 0; i < array.length; i++) {
				if(array[i].mobile_ID.equalsIgnoreCase(st)) {
					f=true;
					b.add(array[i]);
					break;
				}
			}
			if(f) {
				
				while(true) {
					System.out.print("Do you want to delete the mobile id: "+st+" ? Yes or No ? ");
					sc= new Scanner(System.in);
					select=sc.nextLine().toLowerCase();
					
					if(select.equalsIgnoreCase("y") || select.equalsIgnoreCase("yes") ) {
						list.removeAll(b);
						System.out.println("Deleted");
						break;
					}
					else if(select.equalsIgnoreCase("n") || select.equalsIgnoreCase("no")) {
						System.out.println("Back");
						break;
					}
					else {
						System.out.println("Invalid value !!!");
					}
				}			 
			}
			else {
				System.out.println("Mobile id is not available !!!");
			}
		}
	}
	
	public static void main(String[] args) {
		MobileTest a = new MobileTest();
		Scanner sc;
		int sel;
		
		while(true) {
			try {
				System.out.println("\n1. Create Mobile");
				System.out.println("2. Delete Mobile");
				System.out.println("3. Display all");
				System.out.println("4. Exit");
				System.out.print("Your selection: ");
				sc=new Scanner(System.in);
				sel=sc.nextInt();
				
				if(sel==1) {
					a.addMobile();
				}
				else if(sel==2) {
					a.deteleMobile();
				}
				else if(sel==3) {
					a.displayAll();
				}
				else if(sel==4) {
					System.out.println("Shut down");
					break;
				}
				else {
					System.out.println("Your selection is not available");
				}
			} catch (InputMismatchException e) {
				System.out.println("Your selection is not available !!!");
			}
			
		}
	}

}