package BankAccountApp;

public class Checking extends Account {
	
	// List properties specific to a checking accounts
	private int debitCardNumber;
	private int debitCardPin;
	
	// Constructor to initalize account properties
	public Checking(String name, String sSN, double initialDeposit) {
		super(name,sSN, initialDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	@Override 
	public void setRate() { 
		rate = getBaseRate() * .15;
	}
	
	// List any methods specific to the checking account
	
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));

	}
	
	public void showInfo() {
		super.showInfo();
		System.out.println(" Your Checking Account Features:");
		System.out.println(" Debit Card Number: " + debitCardNumber);
		System.out.println(" Debit Card Pin:  " + debitCardPin);
		
	}
}
