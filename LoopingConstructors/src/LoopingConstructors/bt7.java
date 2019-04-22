package LoopingConstructors;

import java.util.Scanner;

public class bt7 {

	public static void main(String[] args) {
		Scanner sc;
		//a. hinh chu nhat
//		int d,r;		
		
//		sc=new Scanner(System.in);
//		System.out.print("Nhap chieu dai: ");
//		d=sc.nextInt();
//		
//		sc=new Scanner(System.in);
//		System.out.print("Nhap chieu rong: ");
//		r=sc.nextInt();
//		
//		for(int i=1; i<=d;i++) {
//			for(int j=1;j<=r;j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
		
		//b. hinh tam giac vuong can
//		int h;
//		
//		sc=new Scanner(System.in);
//		System.out.print("Nhap do cao: ");
//		h=sc.nextInt();
//		
//		for(int i=1;i<=h;i++) {
//			for(int j=1;j<=i;j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
		
		//c. hinh tam giac vuong can nguoc
//		int h;
//		
//		sc=new Scanner(System.in);
//		System.out.print("Nhap do cao: ");
//		h=sc.nextInt();
//		
//		for(int i=1;i<=h;i++) {
//			for(int j=1;j<=h-i+1;j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
//		}
		
		//d. hinh chu nhat rong
		int d,r;		
		
		sc=new Scanner(System.in);
		System.out.print("Nhap chieu dai: ");
		d=sc.nextInt();
		
		sc=new Scanner(System.in);
		System.out.print("Nhap chieu rong: ");
		r=sc.nextInt();
		
		for(int i=1; i<=d;i++) {
			
			for(int j=1;j<=r;j++) {
				if(i==1 || i==d) {
					System.out.print("* ");
				}
				else {
					if(j==1||j==r) {
						System.out.print("* ");
					}
					else {
						System.out.print("  ");
					}
				}
			}
			System.out.println();
		}
	}

}
