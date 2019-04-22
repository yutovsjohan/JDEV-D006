package Bank;

public class Account {
	String customerName;
	String accountNumber;
	int accountBalance;
	
	public Account() {
		super();
		this.customerName = "";
		this.accountNumber = "";
		this.accountBalance = 0;
	}

	public Account(String customerName, String accountNumber, int accountBalance) {
		super();
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		if(accountBalance>=0) {
			this.accountBalance = accountBalance;
		}
		else {
			this.accountBalance = 0;
		}
	}
	
}
