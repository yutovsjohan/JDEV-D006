package entities;

public class danhmuc {
	int madm;
	String tendm;
	public danhmuc(int madm, String tendm) {
		super();
		this.madm = madm;
		this.tendm = tendm;
	}
	public danhmuc() {
		super();
		this.madm = 1;
		this.tendm = "";
	}
	public int getMadm() {
		return madm;
	}
	public void setMadm(int madm) {
		this.madm = madm;
	}
	public String getTendm() {
		return tendm;
	}
	public void setTendm(String tendm) {
		this.tendm = tendm;
	}
}