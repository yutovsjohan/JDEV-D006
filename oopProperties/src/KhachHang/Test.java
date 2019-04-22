package KhachHang;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc;
		int select;
		DanhSachKhachHang ds = new DanhSachKhachHang();
		ThanhVien a;
		VangLai b;
		ds.nhap();
		while(true) {
			System.out.println("\n1. Them khach thanh vien");
			System.out.println("2. Them khach vang lai");
			System.out.println("3. Hien thi toan bo danh sach");
			System.out.println("4. Thoat");
			System.out.print("Moi ban nhap lua chon: ");
			sc= new Scanner(System.in);
			select = sc.nextInt();
			
			switch(select) {
			case 1:
				if(ds.count == ds.max) {
					System.out.println("Danh sach da day!!!");
				}
				else {
					a = new ThanhVien();
					a.nhap();
					ds.kh[ds.count] = a;
					ds.count++;
				}
				break;
			case 2:
				if(ds.count == ds.max) {
					System.out.println("Danh sach da day!!!");
				}
				else {
					b = new VangLai();
					b.nhap();
					ds.kh[ds.count] = b;
					ds.count++;
				}
				break;
			case 3:
				if(ds.count==0) {
					System.out.println("Danh sach rong~");
				}
				else {
					for (int i = 0; i < ds.count; i++) {
						System.out.print("\n" + (i+1) + ". ");
						ds.kh[i].xuat();
					}
				}
				break;
			case 4:
				System.out.println("Ket thuc chuong trinh");
				break;
			default:
				System.out.println("Lua chon khong hop le!!!");
				break;
			}
			
			if(select == 4)
				break;
		}
	}

}
