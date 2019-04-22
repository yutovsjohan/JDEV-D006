package entities;

public class stat {
	int id;
	int atk;
	int hp;
	int de;
	float ct;
	float cd;
	float ev;
	float bl;
	
	
	public stat() {
		super();
		this.id = 0;
		this.atk = 0;
		this.hp = 0;
		this.de = 0;
		this.ct = 0;
		this.cd = 0;
		this.ev = 0;
		this.bl = 0;
	}
	
	public stat(int atk, int hp, int de, float ct, float cd, float ev, float bl) {
		super();
		this.atk = atk;
		this.hp = hp;
		this.de = de;
		this.ct = ct;
		this.cd = cd;
		this.ev = ev;
		this.bl = bl;
	}

	public stat(int id, int atk, int hp, int de, float ct, float cd, float ev, float bl) {
		super();
		this.id = id;
		this.atk = atk;
		this.hp = hp;
		this.de = de;
		this.ct = ct;
		this.cd = cd;
		this.ev = ev;
		this.bl = bl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getDe() {
		return de;
	}
	public void setDe(int de) {
		this.de = de;
	}
	public float getCt() {
		return ct;
	}
	public void setCt(float ct) {
		this.ct = ct;
	}
	public float getCd() {
		return cd;
	}
	public void setCd(float cd) {
		this.cd = cd;
	}
	public float getEv() {
		return ev;
	}
	public void setEv(float ev) {
		this.ev = ev;
	}
	public float getBl() {
		return bl;
	}
	public void setBl(float bl) {
		this.bl = bl;
	}

	
}
