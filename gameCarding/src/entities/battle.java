package entities;

public class battle {
	int id;
	String name;
	int level;
	String type;
	
	String ability;
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
	String status;
	String note;
	public battle(int id, String name, int level, String type, String ability, int atk, int hp, int de, int ct, int cd,
			int ev, int bl, int blpoint, int att, int energy, String status, String note) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.type = type;
		this.ability = ability;
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
		this.status = status;
		this.note = note;
	}
	public battle(String name, int level, String type, String ability, int atk, int hp, int de, int ct, int cd, int ev,
			int bl, int blpoint, int att, int energy, String status, String note) {
		super();
		this.name = name;
		this.level = level;
		this.type = type;
		this.ability = ability;
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
		this.status = status;
		this.note = note;
	}
	public battle() {
		super();
		this.id = 0;
		this.name = "";
		this.level = 1;
		this.type = "";
		this.ability = "none";
		this.atk = 0;
		this.hp = 0;
		this.de = 0;
		this.ct = 0;
		this.cd = 1;
		this.ev = 0;
		this.bl = 0;
		this.blpoint = 1;
		this.att = 1;
		this.energy = 0;
		this.status = "none";
		this.note = "";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
