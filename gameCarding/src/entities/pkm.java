package entities;

public class pkm {
	int id;
	String name;
	String img;
	int level;
	int exp;
	String type;
	String ability;
	int idplayer;
	int friendship;
	
	public pkm(String name, String img, int level, int exp, String type, String ability, int idplayer,int friendship) {
		super();
		this.name = name;
		this.img = img;
		this.level = level;
		this.exp = exp;
		this.type = type;
		this.ability = ability;
		this.idplayer = idplayer;
		this.friendship = friendship;
	}
	public pkm() {
		super();
		this.id = 0;
		this.name = "";
		this.img = "";
		this.level = 1;
		this.exp = 0;
		this.type = "";
		this.ability = "";
		this.idplayer = 0;
		this.friendship = 0;
	}
	public pkm(int id, String name, String img, int level, int exp, String type, String ability, int idplayer,int friendship) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.level = level;
		this.exp = exp;
		this.type = type;
		this.ability = ability;
		this.idplayer = idplayer;
		this.friendship = friendship;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public int getFriendship() {
		return friendship;
	}
	public void setFriendship(int friendship) {
		this.friendship = friendship;
	}	
	
	
}
