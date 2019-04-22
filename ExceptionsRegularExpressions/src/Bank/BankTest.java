package Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		Scanner sc;
		int select;
		Bank a = new Bank();
		while(true) {
			try {
				System.out.println("1. Create account");
				System.out.println("2. Deposite");
				System.out.println("3. Withdraw");
				System.out.println("4. Exit");
				System.out.print("Your selection: ");
				sc= new Scanner(System.in);
				select = sc.nextInt();
				
				if(select == 1) {
					a.createAccount();
				}
				else if(select ==2) {
					a.deposite();
				}
				else if(select==3) {
					a.withdraw();
				}
				else if(select == 4) {
					System.out.println("Shut down");
					break;
				}
				else 
					System.out.println("Selection is not available !!!");
			} catch (InputMismatchException e) {
				System.out.println("Your selection must be number");
			}
			
		}
	}

}
