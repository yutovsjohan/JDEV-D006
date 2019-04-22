package KhachHang;

import java.util.Scanner;

public class DanhSachKhachHang {
	
	Khach[] kh;
	int count;
	int max;
			
	public DanhSachKhachHang(Khach[] kh, int count, int max) {
		super();
		this.kh = kh;
		this.count = count;
		this.max = max;
	}
	

	public DanhSachKhachHang() {
		this.count = 0;
		this.max = 10;
		this.kh = new Khach[this.max];
	}

	public Khach[] getKh() {
		return kh;
	}


	public void setKh(Khach[] kh) {
		this.kh = kh;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		if(max>0) {
			this.max = max;
		}
		else {
			this.max = 0;
		}
	}
	
	public void nhap() {
		Scanner sc;
		sc=new Scanner(System.in);
		System.out.print("Nhap so ma danh sach co the chua duoc: ");
		setMax(sc.nextInt());
		kh = new Khach[this.max];
	}
}
