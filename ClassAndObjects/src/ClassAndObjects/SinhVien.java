package ClassAndObjects;

public class SinhVien {
	private int masv;
	private String hoten;
	private double diemlt;
	private double diemth;
	
	public SinhVien(){
		masv=0;
		hoten="";
		diemlt=0;
		diemth=0;
	}
	
	
	
	public int getMasv() {
		return masv;
	}



	public void setMasv(int masv) {
		this.masv = masv;
	}



	public String getHoten() {
		return hoten;
	}



	public void setHoten(String hoten) {
		this.hoten = hoten;
	}



	public double getDiemlt() {
		return diemlt;
	}



	public void setDiemlt(double diemlt) {
		if(diemlt>=0){
			this.diemlt = diemlt;
		}
		else{
			this.diemlt=0;
		}
	}



	public double getDiemth() {
		return diemth;
	}



	public void setDiemth(double diemth) {
		if(diemth>=0){
			this.diemth = diemth;
		}
		else{
			this.diemth=diemth;
		}
	}
}
