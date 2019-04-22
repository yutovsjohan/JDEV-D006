package LoopingConstructors;

import java.util.Scanner;

public class bt5 {

	public static void main(String[] args) {
		// Nhap password
		
		final String pw = "abc123";
		
		String str;
		Scanner sc;
		int num=0;
		
		while(true) {
			sc=new Scanner(System.in);
			System.out.print("Nhap password: ");
			str=sc.nextLine();
			
			if(str.equalsIgnoreCase(pw)) {
				System.out.println("Ban login thanh cong");
				break;
			}
			else {
				System.out.println("Password khong dung");
				num++;
				if(num==3) {
					System.out.println("Sorry, Tai khoan cua ban da bi khoa");
					break;
				}
			}
		}
		
	}

}
