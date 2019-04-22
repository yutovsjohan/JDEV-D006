package IfElseSwitchCase;

import java.util.Scanner;

public class ChuyenNhiPhan {

	public static void main(String[] args) {
		int n;
		String st="";
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhap n: ");
		n=sc.nextInt();
		
		while(n!=0) {
			st+=n%2;
			n/=2;
		}
		
		for(int i=st.length()-1; i>=0; i--) {
			System.out.print(st.charAt(i));
		}
	}

}
