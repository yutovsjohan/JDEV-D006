package entities;

public class hoadon {
	int mahd;
	String ngaydh;
	
	public hoadon(int mahd, String ngaydh) {
		super();
		this.mahd = mahd;
		this.ngaydh = ngaydh;
	}
	public hoadon() {
		super();
		this.mahd = 0;
		this.ngaydh = "";
	}
	public int getMahd() {
		return mahd;
	}
	public void setMahd(int mahd) {
		this.mahd = mahd;
	}
	public String getNgaydh() {
		return ngaydh;
	}
	public void setNgaydh(String ngaydh) {
		this.ngaydh = ngaydh;
	}
	
}
