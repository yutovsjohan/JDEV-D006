package entities;

public class item {
	product sanpham;
	int soluong;
	public product getSanpham() {
		return sanpham;
	}
	public void setSanpham(product sanpham) {
		this.sanpham = sanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public item(product sanpham, int soluong) {
		super();
		this.sanpham = sanpham;
		this.soluong = soluong;
	}
	
}
