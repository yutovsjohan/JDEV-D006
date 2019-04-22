package HinhHoc;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc;
		int select;
		ShapeCollection s = new ShapeCollection();
		
		while(true) {
			System.out.println("\n1. Them hinh tron");
			System.out.println("2. Them hinh chu nhat");
			System.out.println("3. Xuat toan bo thong tin cac hinh hoc");
			System.out.println("4. Thoat");
			System.out.print("Moi ban nhap lua chon: ");
			sc = new Scanner(System.in);
			select = sc.nextInt();
			
			switch(select) {
			case 1:
				s.addCircle();
				break;
			case 2:
				s.addRectangle();
				break;
			case 3:
				s.show();
				break;
			case 4: 
				System.out.println("Ket thuc chuong trinh");
				break;
			default:
				System.out.println("Lua chon khong hop le!!!");
				break;
			}
			
			if(select == 4) {
				break;
			}
		}
	}

}
