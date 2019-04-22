package Student;

import java.util.Scanner;

public class Student {
	int rollNo;
	String name;
	
	public Student() {
		this.rollNo = 0;
		this.name = "";
	}
	
	public Student(int rollNo, String name){
		this.rollNo = rollNo;
		this.name = name;
	}
	
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		if(rollNo<0)
			rollNo=0;
		else
			this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void nhap(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap rollNo: ");
		this.rollNo=sc.nextInt();
		
		sc = new Scanner(System.in);
		System.out.print("Nhap name: ");
		this.name=sc.nextLine();
	}
	
	public void xuat(){
		System.out.println("RollNo: "+this.rollNo);
		System.out.println("Name: "+this.name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
