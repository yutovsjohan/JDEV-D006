package HashSet;

public class Mobiles {
	String mobile_ID;
	String model;
	String color;
	int price;
	public Mobiles(String mobile_ID, String model, String color, int price) {
		super();
		this.mobile_ID = mobile_ID;
		this.model = model;
		this.color = color;
		this.price = price;
	}
	public Mobiles() {
		super();
		this.mobile_ID = "";
		this.model = "";
		this.color = "";
		this.price = 0;
	}
	public String getMobile_ID() {
		return mobile_ID;
	}
	public void setMobile_ID(String mobile_ID) {
		this.mobile_ID = mobile_ID;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if(price>0){
			this.price = price;
		}
		else{
			this.price=0;
		}
	}
	
	public void output(){
		System.out.println("Id mobile: "+this.mobile_ID);
		System.out.println("Model: "+this.model);
		System.out.println("Color: "+this.color);
		System.out.println("Price: "+this.price);
	}
		
}