package LoopingConstructors;
import java.util.Scanner;

public class bt1 {

	public static void main(String[] args) {
		  int n, kq=1;
		  Scanner sc = new Scanner(System.in);
		  
		  System.out.println("Nhap n: ");
		  n=sc.nextInt();
		  
		  for(int i=2; i<=n; i++) {
			  kq*=i;
		  }
		  
		  System.out.println(n+"! = "+kq);
	}

}
