package GenericHashMap;

import java.util.Scanner;

public class Student {
	String stuID;
	String stuName;
	String phone;
	String address;
	public Student() {
		super();
		this.stuID = "";
		this.stuName = "";
		this.phone = "";
		this.address = "";
	}
	public Student(String stuID, String stuName, String phone, String address) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		this.phone = phone;
		this.address = address;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "id: "+this.stuID+"\t\tname: "+this.stuName+"\t\tphone: "+this.phone+"\t\taddress: "+this.address;
	}
	
	public void input(){
		Scanner sc = new Scanner(System.in);
		while(true){			
			System.out.print("input id: ");
			this.stuID=sc.nextLine();
			
			if(this.stuID.matches("(VN.033/)[0-9]{6}-[0-9]{4}")){
				break;
			}
			else{
				System.out.println("Id default: VN.033/xxxxxx-xxxx");
			}
		}
		
		while(true){
			sc = new Scanner(System.in);
			System.out.print("input name: ");
			this.stuName=sc.nextLine();
			
			if(this.stuName.isEmpty() || this.stuName.matches("\\s+")){
				System.out.println("Name must not be blank");
			}
			else{
				break;
			}
		}
		
		while(true){
			sc = new Scanner(System.in);
			System.out.print("input phone: ");
			this.phone=sc.nextLine();
			
			if(this.phone.matches("\\d{2}-\\d{3}-\\d{6}-\\d{2}")){
				break;
			}
			else{
				System.out.println("Phone default: xx-xxx-xxxxxx-xx");
			}
		}

		sc = new Scanner(System.in);
		System.out.print("input address: ");
		this.address=sc.nextLine();
	}
}