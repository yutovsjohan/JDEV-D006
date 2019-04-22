package LoopingConstructors;

import java.util.Scanner;

public class bt4 {

	public static void main(String[] args) {
		int n;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Nhap n: ");
		n=sc.nextInt();
		
		for(int i=1;i<=10;i++) {
			System.out.println(n+" x "+i+" = "+ n*i);
		}
	}

}
