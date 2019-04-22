package entities;

public class chitiethd {
	int mahd;
	String masp;
	int soluong;
	
	public int getMahd() {
		return mahd;
	}

	public void setMahd(int mahd) {
		this.mahd = mahd;
	}

	public String getMasp() {
		return masp;
	}

	public void setMasp(String masp) {
		this.masp = masp;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public chitiethd() {
		super();
		this.mahd = 0;
		this.masp = "";
		this.soluong = 0;
	}

	public chitiethd(int mahd, String masp, int soluong) {
		super();
		this.mahd = mahd;
		this.masp = masp;
		this.soluong = soluong;
	}
	
}
