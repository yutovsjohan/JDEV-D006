package ClassAndObjects;

import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		int pass, s1, s2;
		Account myAccount = new Account();
		Scanner sc;
		
		while(true){
			System.out.println("1) Dang nhap");
			System.out.println("2) Thoat");
			
			sc=new Scanner(System.in);
			System.out.print("\nMoi nhap lua chon: ");
			s1=sc.nextInt();
			
			if(s1==1){
				System.out.println("Nhap mat khau: ");
				sc=new Scanner(System.in);
				pass=sc.nextInt();
				if(myAccount.accountNo == pass){
					while(true){
						System.out.println("1) Gui tien vao tai khoan");
						System.out.println("2) Rut tien");
						System.out.println("3) So du trong tai khoan");
						System.out.println("4) Dang xuat");
						
						sc=new Scanner(System.in);
						System.out.print("\nMoi nhap lua chon: ");
						s2=sc.nextInt();
						
						switch(s2){
						case 1:
							sc=new Scanner(System.in);
							System.out.println("Nhap so tien can gui: ");
							myAccount.amount=sc.nextInt();
							myAccount.deposit(myAccount.amount);
							break;
						case 2:
							sc=new Scanner(System.in);
							System.out.println("Nhap so tien can rut: ");
							myAccount.amount=sc.nextInt();
							myAccount.withdraw(myAccount.amount);
							break;
						case 3:
							myAccount.getBalance();
							break;
						case 4: 
							break;
						default:
							System.out.println("Lua chon khong hop le");
							break;
						}
						
						if(s2==4){
							System.out.println("Dang xuat thanh cong");
							break;
						}
					}
				}
				else{
					System.out.println("Mat khau khong hop le!!!");
				}
			}
			
			else if(s1==2){
				System.out.println("Ket thuc chuong trinh");
				break;
			}
			else{
				System.out.println("Lua chon khong hop le");
			}
		}
	}

}
