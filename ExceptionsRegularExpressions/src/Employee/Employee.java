package Employee;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {
	String name;
	String address;
	String phoneNumber;
	
	public Employee() {
		super();
		this.name = "";
		this.address = "";
		this.phoneNumber = "";
	}

	public Employee(String name, String address, String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;		
	}
	
	public boolean checkPhoneNumber() {
		return phoneNumber.matches("^[0-9-.\\s]*$");
	}
	
	public String standardizeAddress() {
		Pattern p = Pattern.compile("Drive",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(address);
		String kq=m.replaceAll("D");
		
		p = Pattern.compile("Street",Pattern.CASE_INSENSITIVE);
		m = p.matcher(kq);
		kq=m.replaceAll("S");
		
		p = Pattern.compile("Road",Pattern.CASE_INSENSITIVE);
		m = p.matcher(kq);
		kq=m.replaceAll("R");
		
		p = Pattern.compile(" ",Pattern.CASE_INSENSITIVE);
		m = p.matcher(kq);
		kq=m.replaceAll("");
		
		return kq;
	}
	
	public String standardizePhone() {
		Pattern p = Pattern.compile("[\\s\\.]",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(phoneNumber);
		String kq=m.replaceAll("-");
		
		return kq;
	}
	
	public void nhap() {
		Scanner sc;
		sc = new Scanner(System.in);
		System.out.print("Input name: ");
		setName(sc.nextLine());
		
		sc = new Scanner(System.in);
		System.out.print("Input address: ");
		setAddress(sc.nextLine());
		
		do {
			sc = new Scanner(System.in);
			System.out.print("Input phone number: ");
			setPhoneNumber(sc.nextLine());
			
			if(!checkPhoneNumber()) {
				System.out.println("Phone number is not available");
			}
		}while(!checkPhoneNumber());
	}
	
	public void xuat() {
		System.out.println("Name: "+name);
		System.out.println("Address: "+standardizeAddress());
		System.out.println("Phone number: "+standardizePhone());
	}
	
}
