package Array;

import java.util.Scanner;

public class bt1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,min;
		int a[] = new int[100];
		
		System.out.print("Nhap n: ");
		n=sc.nextInt();
		
		for(int i=0;i<n;i++) {
			sc=new Scanner(System.in);
			System.out.print("a["+i+"]= ");
			a[i]=sc.nextInt();
		}
		
		min=a[0];
		System.out.print("Mang vua nhap: ");
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
			if(min>a[i]) {
				min=a[i];
			}
		}
		
		System.out.println("\nGia tri nho nhat cua mang la: "+min);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n+1;j++) {
				if(a[i] < a[j]) {
					int temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		
		System.out.print("Mang sau khi da sap xep: ");
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+" ");
		}
	}

}
