package HinhHoc;

public class Rectangle implements Shape{
	int width;
	int length;
	
	public Rectangle(int width, int length) {
		super();
		this.width = width;
		this.length = length;
	}

	public Rectangle() {
		super();
		this.width = 0;
		this.length = 0;
	}
	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width>0) {
			this.width = width;
		}
		else {
			this.width=0;
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if(length>0) {
			this.length = length;
		}
		else {
			this.length=0;
		}
	}

	@Override
	public void area() {
		System.out.println("Hinh chu nhat dai = "+this.length+", rong = "+this.width);
		int kq = (this.length + this.width) * 2; 
		System.out.println("Chu vi: "+ kq);
		kq = this.length * this.width;
		System.out.println("Dien tich: "+kq);
		
	}
}
