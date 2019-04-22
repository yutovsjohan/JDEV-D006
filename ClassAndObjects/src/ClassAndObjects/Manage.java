package ClassAndObjects;

import java.util.Scanner;

public class Manage {
//Quan Ly Sinh Vien
	public void nhapthongtin(SinhVien a){
		int m;
		String n;
		double p;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma sinh vien: ");
		m=sc.nextInt();
		a.setMasv(m);
		
		sc = new Scanner(System.in);
		System.out.print("Nhap ten sinh vien: ");
		n=sc.nextLine();
		a.setHoten(n);
		
		sc = new Scanner(System.in);
		System.out.print("Nhap diem ly thuyet: ");
		p=sc.nextDouble();
		a.setDiemlt(p);
		
		sc = new Scanner(System.in);
		System.out.print("Nhap diem thuc hanh: ");
		p=sc.nextDouble();
		a.setDiemth(p);
	}
	
	public double tinhdiemtb(SinhVien a){
		return (a.getDiemlt()+a.getDiemth())/2;
	}
	
	public void xuatthongtin(SinhVien a){
		System.out.println("Ma sinh vien: "+a.getMasv());
		System.out.println("Ho ten sinh vien: "+a.getHoten());
		System.out.println("Diem ly thuyet: "+a.getDiemlt());
		System.out.println("Diem thuc hanh: "+a.getDiemth());
		System.out.println("Diem trung binh: "+tinhdiemtb(a));
		if(tinhdiemtb(a)>=5){
			System.out.println("Ket qua: Dau");
		}
		else{
			System.out.println("Ket qua: Rot");
		}
	}
	public static void main(String[] args) {
		Manage m = new Manage();
		SinhVien x = new SinhVien();
		m.nhapthongtin(x);
		m.xuatthongtin(x);
	}

}
