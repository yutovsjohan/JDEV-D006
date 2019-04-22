package HinhHoc;

public class Circle implements Shape {
	
	double radius;
	
	public Circle() {
		super();
		this.radius=0;
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius>0) {
			this.radius = radius;
		}
		else {
			this.radius=0;
		}
	}

	@Override
	public void area() {
		System.out.println("Hinh tron ban kinh: "+this.radius);
		double kq = this.radius * 2 * pi;
		System.out.println("Chu vi: "+ kq);
		kq = this.radius * this.radius * pi;
		System.out.println("Dien tich: "+kq);
	}
}
