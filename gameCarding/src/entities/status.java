package entities;

public class status {
	String name;
	int time;
	int point;
	
	public status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public status(String name, int time, int point) {
		super();
		this.name = name;
		this.time = time;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
