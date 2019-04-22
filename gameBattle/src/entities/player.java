package entities;

public class player {
	int id;
	String name;
	int level;
	int exp;
	int main;
	int gym;
	int money;
	
	public player() {
		super();
		this.id = 0;
		this.name = "";
		this.level = 1;
		this.exp = 0;
		this.main = 1;
		this.gym = 1;
		this.money = 0;
	}
	
	public player(String name, int level, int exp, int main, int gym, int money) {
		super();
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.main = main;
		this.gym = gym;
		this.money = money;
	}

	public player(int id, String name, int level, int exp, int main, int gym, int money) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.main = main;
		this.gym = gym;
		this.money = money;
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
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getMain() {
		return main;
	}
	public void setMain(int main) {
		this.main = main;
	}
	public int getGym() {
		return gym;
	}
	public void setGym(int gym) {
		this.gym = gym;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}
