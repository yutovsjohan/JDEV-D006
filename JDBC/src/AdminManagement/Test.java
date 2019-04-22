package AdminManagement;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Connection cn = new MyConnect().getcn();
		if(cn==null) {
			System.out.println("Not connect");
		}
		else {
			Scanner sc;
			int select;
			Admin a = new Admin();
			
			while(true) {
				try {					
					System.out.println("1. Display");
					System.out.println("2. Insert");
					System.out.println("3. Update");
					System.out.println("4. Delete");
					System.out.println("5. Search");
					System.out.println("6. Exit");
					System.out.print("Your selection: ");
					sc = new Scanner(System.in);
					select=sc.nextInt();
					
					switch(select) {
					case 1:
						a.display();
						break;
					case 2:
						a.insert();
						break;
					case 3:
						a.update();
						break;
					case 4:
						a.delete();
						break;
					case 5:
						a.search();
						break;
					case 6:
						System.out.println("Shut down");
						break;
					default:
						System.out.println("Your selection is not available");
						break;
					}
					
					if(select==6) {
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Invalid Selection");
				}
				
			}
			
			
		}
	}
}
