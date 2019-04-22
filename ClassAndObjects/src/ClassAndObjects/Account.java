package ClassAndObjects;

import java.util.Scanner;

public class Account {
	
	int amount, balance, accountNo;
	
	public Account(){
		amount=0; balance=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Nhap mat khau: ");
		accountNo=sc.nextInt();
	}
	
	public void deposit(int amount){
		if(amount > 0){
			balance += amount;
			System.out.println("Da gui tien vao tai khoan thanh cong");
		}
		else{
			System.out.println("So tien gui khong hop le!!!");
		}
	}
	
	public void withdraw(int amount){
		if(amount > balance){
			System.out.println("So du tai khoan khong du!!!");
		}
		else{
			balance-=amount;
			System.out.println("Da rut tien thanh cong");
		}
	}
	
	public void getBalance(){
		System.out.println("So du trong tai khoan: "+balance);
	}
	
	public static void main(String[] args) {
		
	}

}