package Student;

import java.security.Permissions;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc;
		int select;
		StandardStudent[] st = new StandardStudent[10];
		PremiumStudent[] ps = new PremiumStudent[10];
		int countst = 0;
		int countps = 0;
		
		while(true){
			System.out.println();
			System.out.println("1. Them mot sinh vien Standard");
			System.out.println("2. Xuat danh sach sinh vien Standard");
			System.out.println("3. Them mot sinh vien Premium");
			System.out.println("4. Xuat danh sach sinh vien Premium");
			System.out.println("5. Thoat");
			System.out.print("Moi ban nhap lua chon: ");
			sc = new Scanner(System.in);
			select = sc.nextInt();
			
			switch(select){
			case 1:
				if(countst>10){
					System.out.println("Full!!!");
				}
				else{
					st[countst] = new StandardStudent();
					st[countst].nhap();
					countst++;
				}
				break;
			case 2:
				if(countst==0){
					System.out.println("Empty!!!");
				}
				else{
					for (int i = 0; i < countst;i++){
						st[i].xuat();
					}	
				}
				break;
			case 3:
				if(countps>10){
					System.out.println("Full!!!");
				}
				else{
					ps[countps] = new PremiumStudent();
					ps[countps].nhap();
					countps++;
				}
				break;
			case 4:
				if(countps==0){
					System.out.println("Empty!!!");
				}
				else{
					for (int i = 0; i < countps;i++){
						ps[i].xuat();
					}	
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Lua chon khong hop le!!!");
				break;
			}
			
			if(select==5){
				System.out.println("Ket thuc chuong trinh");
				break;
			}
		}
	}

}