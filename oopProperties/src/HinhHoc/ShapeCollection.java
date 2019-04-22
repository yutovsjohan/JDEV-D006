package HinhHoc;

import java.util.Scanner;

public class ShapeCollection {
	Shape[] listshape;
	int count;
	
	public ShapeCollection(Shape[] listshape, int count) {
		super();
		this.listshape = listshape;
		this.count = count;
	}

	public ShapeCollection() {
		super();
		this.count = 0;
		this.listshape = new Shape[10];
	}
	
	public void addCircle() {
		Circle a = new Circle();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ban kinh: ");
		a.setRadius(sc.nextDouble());
		listshape[count] = a;
		count++;
		System.out.println("Da them hinh tron");
	}
	
	public void addRectangle() {
		Rectangle a = new Rectangle();
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap chieu dai: ");
		a.setLength(sc.nextInt());
		
		sc = new Scanner(System.in);
		System.out.print("Nhap chieu rong: ");
		a.setWidth(sc.nextInt());
		
		listshape[count] = a;
		count++;
		
		System.out.println("Da them hinh chu nhat");
	}
	
	public void show() {
		if(count==0) {
			System.out.println("Chua co hinh !!!");
		}
		else {
			for (int i = 0; i < count; i++) {
				System.out.print("\n" + (i+1) + ". ");
				listshape[i].area();
			}
		}
	}
	
}
