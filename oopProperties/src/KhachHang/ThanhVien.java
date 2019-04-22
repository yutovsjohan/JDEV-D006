package KhachHang;

import java.util.Scanner;

public class ThanhVien extends Khach{
	
	int tylethuong;
		
	public ThanhVien(int passport, String hoten, int tiencuoc, int tylethuong) {
		super(passport, hoten, tiencuoc);
		this.tylethuong = tylethuong;
	}


	public ThanhVien() {
		super();
		this.tylethuong = 0;
	}


	public ThanhVien(int passport, String hoten, int tiencuoc) {
		super(passport, hoten, tiencuoc);
		this.tylethuong = 0;
	}
	
	public int getTylethuong() {
		return tylethuong;
	}


	public void setTylethuong(int tylethuong) {
		if(tylethuong>0) {
			this.tylethuong = tylethuong;
		}
		else {
			this.tylethuong = 0;
		}
	}
	
	public void nhap() {
		Scanner sc;
		sc=new Scanner(System.in);
		
		
		System.out.print("Nhap ma passport: ");
		setPassport(sc.nextInt());
		
		sc=new Scanner(System.in);
		System.out.print("Nhap ho ten: ");
		setHoten(sc.nextLine());
		
		sc=new Scanner(System.in);
		System.out.print("Nhap tien cuoc: ");
		setTiencuoc(sc.nextInt());		
		
		sc=new Scanner(System.in);
		System.out.print("Nhap ty le thuong: ");
		setTylethuong(sc.nextInt());
	}
	
	public void xuat() {
		System.out.println("Passport: "+this.passport);
		System.out.println("Ho ten: "+this.hoten);
		System.out.println("Tien cuoc: "+this.tiencuoc);
		System.out.println("Ty le thuong: "+this.tylethuong);
		System.out.println("Tien thang cuoc: "+tinhtienthang());
	}

	@Override
	public int tinhtienthang() {
		return tiencuoc * tylethuong;
	}
}
