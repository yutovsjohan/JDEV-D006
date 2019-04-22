package entities;

public class contest {
	int id;
	String name;
	int soluong;
	String winner;
	String prize;
	int money;
	String note;
	public contest(int id, String name, int soluong, String winner, String prize, int money, String note) {
		super();
		this.id = id;
		this.name = name;
		this.soluong = soluong;
		this.winner = winner;
		this.prize = prize;
		this.money = money;
		this.note = note;
	}
	public contest(String name, int soluong, String winner, String prize, int money, String note) {
		super();
		this.name = name;
		this.soluong = soluong;
		this.winner = winner;
		this.prize = prize;
		this.money = money;
		this.note = note;
	}
	public contest() {
		super();
		this.id = 0;
		this.name = "";
		this.soluong = 0;
		this.winner = "";
		this.prize = "";
		this.money = 0;
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
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
