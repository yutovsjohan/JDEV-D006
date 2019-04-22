package entities;

public class pkm {
	int id;
	String name;
	int level;
	int exp;
	int idplayer;
	
	public pkm() {
		super();
		this.id = 0;
		this.name = "";
		this.level = 1;
		this.exp = 0;
		this.idplayer = 1;
	}
	
	public pkm(String name, int level, int exp, int idplayer) {
		super();
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.idplayer = idplayer;
	}

	public pkm(int id, String name, int level, int exp, int idplayer) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.idplayer = idplayer;
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
	
	public int getIdplayer() {
		return idplayer;
	}
	public void setIdplayer(int idplayer) {
		this.idplayer = idplayer;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
}
