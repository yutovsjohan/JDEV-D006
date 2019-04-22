package HashMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DoctorTest {

	public static void main(String[] args) {
		DoctorManager a = new DoctorManager();
		Scanner sc;
		int sel;

		while (true) {
			try {
				System.out.println("1. Add new doctor");
				System.out.println("2. Search doctor");
				System.out.println("3. Display doctor");
				System.out.println("4. Exit");
				System.out.print("Your selection: ");
				sc = new Scanner(System.in);
				
				sel = sc.nextInt();
				if(sel==1){
					Doctor d = new Doctor();
					d.input();
					a.add(d.id,d);
				}
				else if(sel==2){
					if(a.treemap.size()==0){
						System.out.println("List is empty");
					}
					else{
						String id;
						System.out.print("Input id doctor need search: ");
						sc=new Scanner(System.in);
						id=sc.nextLine().toUpperCase();
						a.Search(id);
					}
				}
				else if(sel==3){
					if(a.treemap.size()==0){
						System.out.println("List is empty");
					}
					else{
						a.displayAll();
					}
				}
				else if (sel == 4) {
					System.out.println("Shut down.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid value");
			}
		}
		
	}

}