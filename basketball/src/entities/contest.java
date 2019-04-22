package entities;

public class contest {
	int id;
	String name;
	int soluong;
	String winner;
	String mvp;
	
	public contest(int id, String name, int soluong, String winner, String mvp) {
		super();
		this.id = id;
		this.name = name;
		this.soluong = soluong;
		this.winner = winner;
		this.mvp = mvp;
	}
	public contest(String name, int soluong, String winner, String mvp) {
		super();
		this.name = name;
		this.soluong = soluong;
		this.winner = winner;
		this.mvp = mvp;
	}
	public contest() {
		super();
		this.id = 0;
		this.name = "";
		this.soluong = 0;
		this.winner = "none";	
		this.mvp = "none";
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
	public String getMvp() {
		return mvp;
	}
	public void setMvp(String mvp) {
		this.mvp = mvp;
	}

	
	
}
