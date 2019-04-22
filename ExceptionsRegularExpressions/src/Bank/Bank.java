package Bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bank {
	Account[] accList;
	int accMax;
	int nextAcc;
	
	public Bank() {
		super();
		this.accList = new Account[10];
		this.accMax = 10;
		this.nextAcc = 0;
	}

	public Bank(Account[] accList, int accMax, int nextAcc) {
		super();
		this.accList = accList;
		this.accMax = accMax;
		this.nextAcc = nextAcc;
	}

	public Account[] getAccList() {
		return accList;
	}

	public void setAccList(Account[] accList) {
		this.accList = accList;
	}

	public int getAccMax() {
		return accMax;
	}

	public void setAccMax(int accMax) {
		if(accMax>0) {
			this.accMax = accMax;
		}
		else {
			this.accMax=0;
		}
	}

	public int getNextAcc() {
		return nextAcc;
	}

	public void setNextAcc(int nextAcc) {
		this.nextAcc = nextAcc;
	}
	
	public void createAccount() {		
		try {
			if(nextAcc == accMax) {
				System.out.println("Full !!!");
			}
			else {
				accList[nextAcc] = new Account();
				Scanner sc = new Scanner(System.in);
				System.out.print("Input customer name: ");
				accList[nextAcc].setCustomerName(sc.nextLine());
				
				sc = new Scanner(System.in);
				System.out.print("Input account number: ");
				accList[nextAcc].setAccountNumber(sc.nextLine());
				
				sc = new Scanner(System.in);
				System.out.print("Input account balance: ");
				accList[nextAcc].setAccountBalance(sc.nextInt());
				
				if(accList[nextAcc].getAccountBalance() < 100) {
					accList[nextAcc].setAccountBalance(0);
					throw new InsufficientFundsException();					
				}	
				
				nextAcc++;
			}
		} 
		catch (NullPointerException e) {
			System.out.println("One variable is null !!!");
		} 
		catch (InputMismatchException e) {
			System.out.println("Account balance must be integer");
		} 
		catch (InsufficientFundsException e) {
			System.out.println("Account balance is not less 100 !!!\n");
		}
	}
	
	public void displayAccountDetails(Account a) {	
		System.out.println("\nCustomer name: "+a.getCustomerName());
		System.out.println("Account number: "+a.getAccountNumber());
		System.out.println("Account balance: "+a.getAccountBalance());			
	}
	
	public void deposite() {
		try {
			String accNo;
			int money;
			Scanner sc = new Scanner(System.in);
			System.out.print("\nInput account number: ");
			accNo = sc.nextLine();
			if(checkAccount(accNo)) {
				sc = new Scanner(System.in);
				System.out.print("Input money need deposite: ");
				money = sc.nextInt();
				
				if(money > 0) {					
					accList[getAccount(accNo)].accountBalance += money;
					System.out.println("Success");
					displayAccountDetails(accList[getAccount(accNo)]);
				}
				else {
					throw new InsufficientFundsException("Invalid amount !!!");
				}
			}
			else {
				throw new InsufficientFundsException("Account is not available !!!");
			}
			
		} 
		catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void withdraw() {
		try {
			String accNo;
			int money;
			Scanner sc = new Scanner(System.in);
			System.out.print("\nInput account number: ");
			accNo = sc.nextLine();
			
			if(checkAccount(accNo)) {
				sc = new Scanner(System.in);
				System.out.print("Input money need withdraw: ");
				money = sc.nextInt();
				
				if(money > 0) {					
					if(money > accList[getAccount(accNo)].accountBalance) {
						throw new InsufficientFundsException("Account balance isn't enough !!!");
					}
					else {
						accList[getAccount(accNo)].accountBalance -= money;
						System.out.println("Success");
						displayAccountDetails(accList[getAccount(accNo)]);
					}					
				}
				else {
					throw new InsufficientFundsException("Invalid amount !!!");
				}
			}
			else {
				throw new InsufficientFundsException("Account is not available !!!");
			}
			
		} 
		catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		
	}
	
	public boolean checkAccount(String accountNumber) {
		if(nextAcc==0) {
			return false;
		}
		else {
			for (int i = 0; i < nextAcc; i++) {
				if(accList[i].accountNumber.equalsIgnoreCase(accountNumber))
					return true;
			}
		}
		return false;
	}
	
	public int getAccount(String accountNumber) {
		for (int i = 0; i < nextAcc; i++) {
			if(accList[i].accountNumber.equalsIgnoreCase(accountNumber))
				return i;
		}
		return -1;
	}
	
}
