package Student;

import java.util.Scanner;

public class StandardStudent extends Student {

	int EngMark;

	public StandardStudent() {
		this.EngMark = 0;
	}

	public StandardStudent(int engMark) {
		super();
		EngMark = engMark;
	}

	public StandardStudent(int rollNo, String name) {
		super(rollNo, name);
		
	}

	public int getEngMark() {
		return EngMark;
	}

	public void setEngMark(int engMark) {
		if(engMark<0){
			this.EngMark=0;
		}
		else{
			EngMark = engMark;
		}
	}

	public void nhap() {
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap EngMark: ");
		this.EngMark=sc.nextInt();
	}
	
	public void xuat(){
		super.xuat();
		System.out.println("EngMark: "+this.EngMark);
	}

	public static void main(String[] args) {
		
	}

}