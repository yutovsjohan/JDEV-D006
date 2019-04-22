package entities;

public class move {
	int id;
	String name;
	int power;
	int energy;
	String type;
	int acc;
	String eff1;
	int point1;
	String obj1;
	int perEff1;
	String eff2;
	int point2;
	String obj2;
	int perEff2;
	String status;
	int perStatus;
	
	

	public move(String name, int power, int energy, String type, int acc, String eff1, int point1, String obj1,
			int perEff1, String eff2, int point2, String obj2, int perEff2, String status, int perStatus) {
		super();
		this.name = name;
		this.power = power;
		this.energy = energy;
		this.type = type;
		this.acc = acc;
		this.eff1 = eff1;
		this.point1 = point1;
		this.obj1 = obj1;
		this.perEff1 = perEff1;
		this.eff2 = eff2;
		this.point2 = point2;
		this.obj2 = obj2;
		this.perEff2 = perEff2;
		this.status = status;
		this.perStatus = perStatus;
	}
	public move(int id, String name, int power, int energy, String type, int acc, String eff1, int point1, String obj1,
			int perEff1, String eff2, int point2, String obj2, int perEff2, String status, int perStatus) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
		this.energy = energy;
		this.type = type;
		this.acc = acc;
		this.eff1 = eff1;
		this.point1 = point1;
		this.obj1 = obj1;
		this.perEff1 = perEff1;
		this.eff2 = eff2;
		this.point2 = point2;
		this.obj2 = obj2;
		this.perEff2 = perEff2;
		this.status = status;
		this.perStatus = perStatus;
	}
	public move() {
		super();
		this.id = 0;
		this.name = "";
		this.power = 0;
		this.energy = 0;
		this.type = "";
		this.acc = 100;
		this.eff1 = "none";
		this.point1 = 0;
		this.obj1 = "none";
		this.perEff1 = 0;
		this.eff2 = "none";
		this.point2 = 0;
		this.obj2 = "none";
		this.perEff2 = 0;
		this.status = "none";
		this.perStatus = 0;
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
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAcc() {
		return acc;
	}
	public void setAcc(int acc) {
		this.acc = acc;
	}
	public String getEff1() {
		return eff1;
	}
	public void setEff1(String eff1) {
		this.eff1 = eff1;
	}
	public int getPoint1() {
		return point1;
	}
	public void setPoint1(int point1) {
		this.point1 = point1;
	}
	public String getEff2() {
		return eff2;
	}
	public void setEff2(String eff2) {
		this.eff2 = eff2;
	}
	public int getPoint2() {
		return point2;
	}
	public void setPoint2(int point2) {
		this.point2 = point2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getObj1() {
		return obj1;
	}
	public void setObj1(String obj1) {
		this.obj1 = obj1;
	}
	public String getObj2() {
		return obj2;
	}
	public void setObj2(String obj2) {
		this.obj2 = obj2;
	}
	public int getPerEff1() {
		return perEff1;
	}
	public void setPerEff1(int perEff1) {
		this.perEff1 = perEff1;
	}
	public int getPerEff2() {
		return perEff2;
	}
	public void setPerEff2(int perEff2) {
		this.perEff2 = perEff2;
	}
	public int getPerStatus() {
		return perStatus;
	}
	public void setPerStatus(int perStatus) {
		this.perStatus = perStatus;
	}
	
	
}
