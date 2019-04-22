package entities;

public class stat {
	int id;
	int atk;
	int hp;
	int de;
	int ct;
	int cd;
	int ev;
	int bl;
	int blpoint;
	int att;
	int energy;
	public stat(int id, int atk, int hp, int de, int ct, int cd, int ev, int bl, int blpoint, int att, int energy) {
		super();
		this.id = id;
		this.atk = atk;
		this.hp = hp;
		this.de = de;
		this.ct = ct;
		this.cd = cd;
		this.ev = ev;
		this.bl = bl;
		this.blpoint = blpoint;
		this.att = att;
		this.energy = energy;
	}
	public stat() {
		super();
		this.id = 1;
		this.atk = 20;
		this.hp = 100;
		this.de = 0;
		this.ct = 0;
		this.cd = 1;
		this.ev = 0;
		this.bl = 0;
		this.blpoint = 1;
		this.att = 1;
		this.energy = 50;
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
	public int getCt() {
		return ct;
	}
	public void setCt(int ct) {
		this.ct = ct;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public int getEv() {
		return ev;
	}
	public void setEv(int ev) {
		this.ev = ev;
	}
	public int getBl() {
		return bl;
	}
	public void setBl(int bl) {
		this.bl = bl;
	}
	public int getBlpoint() {
		return blpoint;
	}
	public void setBlpoint(int blpoint) {
		this.blpoint = blpoint;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	
}
