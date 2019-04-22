package entities;

public class player {
	int id;
	String name;
	String team;
	
	public player() {
		super();
		this.name = "";
		this.team = "";
	}
	public player(int id, String name, String team) {
		super();
		this.id = id;
		this.name = name;
		this.team = team;
	}
	public player(String name, String team) {
		super();
		this.name = name;
		this.team = team;
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
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	
	
	
}
