package Packages;

public class bt2 {

	public static void main(String[] args) {
		String number = "45";
		Byte num = Byte.valueOf(number);
		System.out.println(num);
		System.out.println(num+"^2="+(num*num));
		System.out.println("log "+num+" = "+Math.log10(num));
		System.out.println("sin 90 = "+Math.sin(90));
		System.out.println("cos 10 = "+Math.cos(10));
		System.out.println("tan 10 = "+Math.tan(10));
		System.out.println("ceil 7.2 = "+Math.ceil(7.2));
		System.out.println("floor 7.8 = "+Math.floor(7.8));
		System.out.println("round 10.5 = "+Math.round(10.5));
		System.out.println("sqrt 10 = "+Math.sqrt(10));
	}

}
