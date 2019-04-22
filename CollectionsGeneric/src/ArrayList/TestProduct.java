package ArrayList;

import java.util.Scanner;

public class TestProduct {

	public static void main(String[] args) {
		Scanner sc;
		int select;
		Management a = new Management();
		while(true){
			System.out.println("1. Add new product");
			System.out.println("2. Find product id");
			System.out.println("3. Products have high unit price");
			System.out.println("4. All products");
			System.out.println("5. Exit");
			System.out.print("Your selection: ");
			sc = new Scanner(System.in);
			select=sc.nextInt();
			
			switch(select){
			case 1:
				a.addProduct();
				break;
			case 2:
				if(a.vrListPr.size()==0){
					System.out.println("List is empty");
				}
				else{
					String id;
					System.out.print("Input id need find: ");
					sc=new Scanner(System.in);
					id=sc.nextLine();
					if(a.searchByID(id)){
						System.out.println("Found");
					}
					else{
						System.out.println("Product is not available");
					}
				}
				break;
			case 3:
				if(a.vrListPr.size()==0){
					System.out.println("List is empty");
				}
				else{
					a.displayHighValue();
				}
				break;
			case 4:
				if(a.vrListPr.size()==0){
					System.out.println("List is empty");
				}
				else{
					a.displayAll();
				}
				break;
			case 5:
				System.out.println("Shut down");
				break;
			default:
				System.out.println("Your selection is not available");
			}
			
			if(select==5){
				break;
			}
		}
	}

}