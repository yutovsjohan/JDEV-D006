package JavaSwing;

public class Student {
	String hoten;
	String email;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String hoten, String email) {
		super();
		this.hoten = hoten;
		this.email = email;
	}
	@Override
	public String toString() {
		return String.format("%s %s", this.hoten,this.email);
	}
}
