package entities;

public class player {
	int id;
	String name;
	String img;
	int level;
	int exp;
	int money;
	int win;
	int lose;
	String guild;
	String title;
	
	
	public player(String name, String img, int level, int exp, int money, int win, int lose, String guild, String title) {
		super();
		this.name = name;
		this.img = img;
		this.level = level;
		this.exp = exp;
		this.money = money;
		this.win = win;
		this.lose = lose;
		this.title = title;
	}
	public player(int id, String name, String img, int level, int exp, int money, int win, int lose, String guild, String title) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.level = level;
		this.exp = exp;
		this.money = money;
		this.win = win;
		this.lose = lose;
		this.title = title;
	}
	public player(String name, String img, int money) {
		super();
		this.name = name;
		this.img = img;
		this.money = money;
	}
	public player(int id, String name, String img, int money) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.money = money;
	}
	public player() {
		super();
		this.id = -1;
		this.name = "";
		this.img = "user.png";
		this.money = 0;
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
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGuild() {
		return guild;
	}
	public void setGuild(String guild) {
		this.guild = guild;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
}
