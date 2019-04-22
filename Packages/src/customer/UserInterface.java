package customer;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Scanner sc;
		int select;
		CDCreator cdc = new CDCreator();
		while(true) {
			System.out.println("1) Them 1 CD nhac moi vao bo suu tap");
			System.out.println("2) Them 1 CD phim moi vao bo suu tap");
			System.out.println("3) Hien thi toan bo CD nhac trong bo suu tap");
			System.out.println("4) Hien thi toan bo CD phim trong bo suu tap");
			System.out.println("5) Thoat chuong trinh");
			System.out.print("Moi nhap lua chon: ");
			sc=new Scanner(System.in);
			select=sc.nextInt();
			
			switch(select) {
			case 1:
				cdc.addMusicCD();
				break;
			case 2:
				cdc.addMovieCD();
				break;
			case 3:
				cdc.displayAllMusic();
				break;
			case 4:
				cdc.displayAllMovie();
				break;
			case 5:
				System.out.println("Ket thuc chuong trinh");
				break;
			default:
				System.out.println("Lua chon khong hop le!!!");
				break;
			}
			
			if(select==5) {
				break;
			}
		}
	}

}
