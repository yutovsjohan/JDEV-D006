package KhachHang;

abstract public class Khach {
	int passport;
	String hoten;
	int tiencuoc;
	
	public Khach(int passport, String hoten, int tiencuoc) {
		super();
		this.passport = passport;
		this.hoten = hoten;
		this.tiencuoc = tiencuoc;
	}
	
	public Khach() {
		super();
		this.passport = 0;
		this.hoten = "";
		this.tiencuoc = 0;
	}

	public int getPassport() {
		return passport;
	}

	public void setPassport(int passport) {
		if(passport>=0) {
			this.passport = passport;
		}
		else {
			this.passport=0;
		}
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getTiencuoc() {
		return tiencuoc;
	}

	public void setTiencuoc(int tiencuoc) {
		if(tiencuoc>0) {
			this.tiencuoc = tiencuoc;
		}
		else {
			this.tiencuoc=0;
		}
	}
	
	abstract public int tinhtienthang();
	abstract public void xuat();
}
