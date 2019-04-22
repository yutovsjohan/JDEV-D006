package HinhTron;

import java.util.Scanner;

public class Circle extends Point implements Shape {
	
	double radius;
	int color;
	
	public Circle(int x, int y, double radius, int color) {
		super(x, y);
		this.radius = radius;
		this.color = color;
	}

	public Circle() {
		super();
		this.radius=0;
		this.color=0;
	}

	public Circle(int x, int y) {
		super(x, y);
		this.radius=0;
		this.color=0;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public static void main(String[] args) {
		Scanner sc;
		int select;
		Circle a = new Circle();
		boolean f = false;
		while(true) {
			System.out.println();
			System.out.println("1. Tao hinh tron");
			System.out.println("2. Di chuyen hinh tron");
			System.out.println("3. Ve hinh tron");
			System.out.println("4. Tinh dien tich hinh tron");
			System.out.println("5. Thoat");
			System.out.print("Moi ban nhap lua chon:");
			sc= new Scanner(System.in);
			select = sc.nextInt();
			
			switch(select) {
			case 1:				
				sc= new Scanner(System.in);
				System.out.print("Nhap x: ");
				a.setX(sc.nextInt());
				
				sc= new Scanner(System.in);
				System.out.print("Nhap y: ");
				a.setY(sc.nextInt());
				
				sc= new Scanner(System.in);
				System.out.print("Nhap ban kinh: ");
				a.setRadius(sc.nextDouble());
				
				sc= new Scanner(System.in);
				System.out.print("Nhap color: ");
				a.setColor(sc.nextInt());
				
				f=true;
				break;
			case 2:
				if(f) {
					int dx,dy;
					sc= new Scanner(System.in);
					System.out.print("Nhap x moi: ");
					dx=sc.nextInt();
					
					sc= new Scanner(System.in);
					System.out.print("Nhap y moi: ");
					dy=sc.nextInt();
					
					a.move(dx, dy);
				}
				else {
					System.out.println("Ban chua tao hinh tron");
				}
				break;
			case 3:
				if(f) {
					a.draw();
				}
				else {
					System.out.println("Ban chua tao hinh tron");
				}
				break;
			case 4:
				if(f) {
					System.out.println("Dien tich hinh tron: "+a.area());
				}
				else {
					System.out.println("Ban chua tao hinh tron");
				}
				break;
			case 5: break;
			default: 
				System.out.println("Lua chon khong hop le!!!"); break;
			}
			
			if(select == 5) {
				System.out.println("Ket thuc chuong trinh");
				break;
			}
		}
	}
	
	//dien tich hinh tron
	@Override
	public double area() {
		return pi * this.radius * this.radius;
		
	}

	@Override
	public void draw() {
		System.out.println("Hinh tron tam I("+super.getX()+","+super.getY()+") ban kinh "+this.radius+", color: "+this.color);
	}

}