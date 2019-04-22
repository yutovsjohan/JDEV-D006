package StudentManage;

public class Student {
	int id;
	String name;
	String address;
	String parentName;
	String phone;
	String standard;
	String regDate;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Student() {
		super();
		this.id = 0;
		this.name = "";
		this.address = "";
		this.parentName = "";
		this.phone = "";
		this.standard = "";
		this.regDate = "";
	}
	public Student(int id, String name, String address, String parentName, String phone, String standard,
			String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.parentName = parentName;
		this.phone = phone;
		this.standard = standard;
		this.regDate = regDate;
	}
	
}
