package BankAccountApp;

public abstract class Account implements IBaseRate {
	
	// list common properties for savings and checking account
	private String name;
	private String sSN;
	private double balance;
	private static int index = 10000;
	
	protected String accountNumber;
	protected double rate;
	
	//private String 
	
	// Constructor to set base properties and initialize the account 
	public Account(String name, String sSN, double initialDeposit) {
		this.name = name;
		this.sSN = sSN;
		balance = initialDeposit;
		
		// Set Account Number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
		
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber  = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public void compound() {
		double accrudeInterest = 1.01 * Math.round(balance * (rate/100));
		balance = balance + accrudeInterest;
		System.out.println("Accrude Interest: $" + accrudeInterest);
		printBalance();
	}
	
	// List common methods from transactions 
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transferring $" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now $:" + balance);
	}
	
	// List Common methods
	
	public void showInfo() {
		System.out.println("NAME: " + name);
		System.out.println("ACCOUNT NUMBER: " + accountNumber);
		System.out.println("BALANCE:  " + balance);
		System.out.println("RATE: " + rate + "%");
	}
}