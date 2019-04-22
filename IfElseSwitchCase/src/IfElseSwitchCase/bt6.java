package IfElseSwitchCase;

import java.util.Scanner;

public class bt6 {

	public static void main(String[] args) {
		String m1,m2,m3,m4;
		m1="1) Aptitude\n";
		m2="2) English\n";
		m3="3) Mathematics\n";
		m4="4) General Knowledge\n";
		char a1,a2,a3,a4;
		a1='a'; a2='b'; a3='d'; a4='c';
		int select, point=0, flag=0;
		char answer;
		boolean f;
		Scanner sc;
		
		while(true) {
			System.out.println(m1+m2+m3+m4+"5) Exit");
			sc=new Scanner(System.in);
			System.out.print("Moi ban nhap lua chon: ");
			select=sc.nextInt();
						
			switch(select) {
			case 1: 
				if(!m1.isEmpty()) {
					System.out.println("\n1) So nao se la so tiep theo cua chuoi so sau:");
					System.out.println("0, 1, 2, 4, 6, 9, 12, 16, ?");
					System.out.println("a. 20 ");
					System.out.println("b. 22");
					System.out.println("c. 24");
					System.out.println("d. 26");
					
					while(true) {
						f=true;
						sc=new Scanner(System.in);
						System.out.print("\nMoi ban chon dap an: ");
						answer=sc.nextLine().charAt(0);
						
						for(char j='a';j<='d';j++) {
							if(answer==j || answer==Character.toUpperCase(j)) {
								f=true;
								break;
							}
							else {
								f=false;
							}
						}
						
						if(f) {
							break;
						}
						else {
							System.out.println("Dap an khong hop le!!!");
						}
					}
					
					if(answer==a1 || answer==Character.toUpperCase(a1)) {
						point+=10;
						System.out.println(answer+" la 1 dap an hoan toan chinh xac!!!\n");
					}
					else {
						System.out.println("Rat tiec!!! "+answer+" khong phai la dap an dung\n");
					}
					
					m1=""; flag++;					
				}
				else {
					System.out.println("Cau hoi nay ban da chon roi\n");
				}
				break;
			case 2: 
				if(!m2.isEmpty()) {
					System.out.println("\n2) Fill in the missing number (s) indicated by the question mark (s) in question.");
					System.out.println("14, 16, 28, 32, 42, 48, 56, 64, ? , ?");
					System.out.println("a. 68, 92");
					System.out.println("b. 70, 80");
					System.out.println("c. 73, 85");
					System.out.println("d. 78, 87");
					
					while(true) {
						f=true;
						sc=new Scanner(System.in);
						System.out.print("\nMoi ban chon dap an: ");
						answer=sc.nextLine().charAt(0);
						
						for(char j='a';j<='d';j++) {
							if(answer==j || answer==Character.toUpperCase(j)) {
								f=true;
								break;
							}
							else {
								f=false;
							}
						}
						
						if(f) {
							break;
						}
						else {
							System.out.println("Dap an khong hop le!!!");
						}
					}
					
					if(answer==a2 || answer==Character.toUpperCase(a2)) {
						point+=10;
						System.out.println(answer+" la 1 dap an hoan toan chinh xac!!!\n");
					}
					else {
						System.out.println("Rat tiec!!! "+answer+" khong phai la dap an dung\n");
					}
					m2=""; flag++;
				}
				else {
					System.out.println("Cau hoi nay ban da chon roi\n");
				}
				break;
			case 3:
				if(!m3.isEmpty()) {
					System.out.println("\n1) Dien vao dau cham hoi sau:");
					System.out.println("1, 1, 2, 3, 5, ?");
					System.out.println("a. 6");
					System.out.println("b. 11");
					System.out.println("c. 10");
					System.out.println("d. 8");
					
					while(true) {
						f=true;
						sc=new Scanner(System.in);
						System.out.print("\nMoi ban chon dap an: ");
						answer=sc.nextLine().charAt(0);
						
						for(char j='a';j<='d';j++) {
							if(answer==j || answer==Character.toUpperCase(j)) {
								f=true;
								break;
							}
							else {
								f=false;
							}
						}
						
						if(f) {
							break;
						}
						else {
							System.out.println("Dap an khong hop le!!!");
						}
					}
					
					if(answer==a3 || answer==Character.toUpperCase(a3)) {
						point+=10;
						System.out.println(answer+" la 1 dap an dung!!!\n");
					}
					else {
						System.out.println(answer + " la mot dap an khong chinh xac!!!\n");
					}
					
					m3=""; flag++;
				}
				else {
					System.out.println("Cau hoi nay ban da chon roi\n");
				}
				break;
			case 4:
				if(!m4.isEmpty()) {
					System.out.println("\n4) So nao khac tinh chat voi cac so con lai?");
					System.out.println("9678 4572 5261 5133 3527 6895 7768"); 
					System.out.println("A. 9678"); 
					System.out.println("B. 4572");
					System.out.println("C. 3527"); 
					System.out.println("D. 7768");
					
					while(true) {
						f=true;
						sc=new Scanner(System.in);
						System.out.print("\nMoi ban chon dap an: ");
						answer=sc.nextLine().charAt(0);
						
						for(char j='a';j<='d';j++) {
							if(answer==j || answer==Character.toUpperCase(j)) {
								f=true;
								break;
							}
							else {
								f=false;
							}
						}
						
						if(f) {
							break;
						}
						else {
							System.out.println("Dap an khong hop le!!!");
						}
					}
					
					if(answer==a4 || answer==Character.toUpperCase(a4)) {
						point+=10;
						System.out.println(answer+" la 1 dap an dung!!!\n");
					}
					else {
						System.out.println(answer + " la mot dap an khong chinh xac!!!\n");
					}
					
					m4=""; flag++;
				}
				else {
					System.out.println("Cau hoi nay ban da chon roi\n");
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Lua chon khong hop le\n");
				break;
			}
			
			if(flag==4 || select == 5)
				break;
		}
		
		System.out.println("\nYou have finished the test");
		
		switch(point) {
		case 20:
			System.out.println("Bonus points earned: 2");
			point+=2;
			break;
		case 30:
			System.out.println("Bonus points earned: 5");
			point+=5;
			break;
		case 40:
			System.out.println("Bonus points earned: 10");
			point+=10;
			break;
		default:
			System.out.println("Bonus points earned: 0");
			point+=0;
			break;
		}
				
		System.out.println("Total score out of: "+point);
		
		switch(point) {
		case 0:
			System.out.println("IQ level: You need reappear the test");
			break;
		case 10:
			System.out.println("IQ level: Your IQ level is below average");
			break;
		case 22:
			System.out.println("IQ level: Your IQ level is average");
			break;
		case 35:
			System.out.println("IQ level: You are Intelligent");
			break;
		case 50:
			System.out.println("IQ level: You are a Genius");
			break;
		}
		
		sc.close();
		
	}
}
