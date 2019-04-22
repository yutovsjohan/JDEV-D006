package LoopingConstructors;

public class bt6 {

	public static void main(String[] args) {
		int a=1,b=1,c=0;
		
		System.out.print("1, 1");
		while(c<=100) {
			c=a+b;
			a=b;
			b=c;
			System.out.print(", "+c);
		}
	}

}
