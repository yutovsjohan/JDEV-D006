package Student;

import java.util.Scanner;

public class PremiumStudent extends Student{

	int mathMark;
	
	public PremiumStudent(int mathMark) {
		super();
		this.mathMark = mathMark;
	}

	public PremiumStudent() {
		super();
	}

	public PremiumStudent(int rollNo, String name) {
		super(rollNo, name);
		
	}

	public int getMathMark() {
		return mathMark;
	}

	public void setMathMark(int mathMark) {
		if(mathMark<0)
			this.mathMark=0;
		else
			this.mathMark = mathMark;
	}
	
	public void nhap(){
		super.nhap();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap MathMark: ");
		this.mathMark=sc.nextInt();
	}
	
	public void xuat(){
		super.xuat();
		System.out.println("MathMark: "+this.mathMark);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}