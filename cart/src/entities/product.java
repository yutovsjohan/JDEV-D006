package entities;

public class product {
	String masp;
	String tensp;
	int gia;
	String hinh;
	int madm;
	
	public int getMadm() {
		return madm;
	}
	public void setMadm(int madm) {
		this.madm = madm;
	}
	
	public product(String masp, String tensp, int gia, String hinh, int madm) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.gia = gia;
		this.hinh = hinh;
		this.madm = madm;
	}
	public product() {
		super();
		this.masp = "";
		this.tensp = "";
		this.gia = 0;
		this.hinh = "";
		this.madm=1;
	}
	public product(String masp, String tensp, int gia, String hinh) {
		super();
		this.masp = masp;
		this.tensp = tensp;
		this.gia = gia;
		this.hinh = hinh;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
}
