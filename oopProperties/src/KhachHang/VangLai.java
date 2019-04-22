package KhachHang;

import java.util.Scanner;

public class VangLai extends Khach{
	int phithamgia;
	
	
	public VangLai() {
		super();
		phithamgia = 0;
	}


	public VangLai(int passport, String hoten, int tiencuoc) {
		super(passport, hoten, tiencuoc);
		phithamgia = 0;
	}


	public VangLai(int passport, String hoten, int tiencuoc, int phithamgia) {
		super(passport, hoten, tiencuoc);
		this.phithamgia = phithamgia;
	}


	public int getPhithamgia() {
		return phithamgia;
	}


	public void setPhithamgia(int phithamgia) {
		if(phithamgia>0) {
			this.phithamgia = phithamgia;
		}
		else {
			this.phithamgia = 0;
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
		System.out.print("Nhap phi tham gia: ");
		setPhithamgia(sc.nextInt());
	}
	
	public void xuat() {
		System.out.println("Passport: "+this.passport);
		System.out.println("Ho ten: "+this.hoten);
		System.out.println("Tien cuoc: "+this.tiencuoc);
		System.out.println("Phi tham gia: "+this.phithamgia);
		System.out.println("Tien thang cuoc: "+tinhtienthang());
	}

	@Override
	public int tinhtienthang() {
		return tiencuoc - phithamgia;
	}
}
