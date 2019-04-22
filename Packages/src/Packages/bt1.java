package Packages;

import java.io.IOException;
import java.util.Scanner;

public class bt1 {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		Process p = null;
		Scanner sc;
		int select;
		
		while(true){
			sc = new Scanner(System.in);
			System.out.println("1) Calculator");
			System.out.println("2) Notepad");
			System.out.println("3) Paint");
			System.out.println("4) Exit");
			System.out.print("Nhap lua chon: ");
			select=sc.nextInt();
			
			if (select==1){
				try {
					p = r.exec("calc.exe");
					System.out.println("Mo thanh cong");
				} catch (IOException e) {
					System.out.println("Error Executing calculator");
				}
			}
			else if(select==2){
				try {
					p = r.exec("notepad.exe");
					System.out.println("Mo thanh cong");
				} catch (IOException e) {
					System.out.println("Error Executing calculator");
				}
			}
			else if(select==3){
				try {
					p = r.exec("Paint.exe");
					System.out.println("Mo thanh cong");
				} catch (IOException e) {
					System.out.println("Error Executing calculator");
				}
			}			
			else if(select==4){
				System.out.println("Ket thuc chuong trinh");
				break;
			}
		}
	}

}
