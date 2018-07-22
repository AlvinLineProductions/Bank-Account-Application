package BankAccountApp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		
		
		List<Account> accounts = new LinkedList<Account>();
		
		
		String file = "/Users/alvinescobar/eclipse-workspace/JavaProjects/NewBankAccounts.csv";
		
		/*
		Checking chkacc1 = new Checking("Alvin Escobar","123456789",1500);
		Savings savacc1 = new Savings("Brian Low","987654321",2500);
		
		savacc1.showInfo();
		System.out.println("************");
		chkacc1.showInfo(); 
		*/
		
		// Read a CSV File then create new accounts based on that data
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initialDeposit = Double.parseDouble(accountHolder[3]);
			//System.out.println(name + " " + sSN + " " + accountType + " $" + initialDeposit);
			if (accountType.equals("Savings")) {
				
				accounts.add(new Savings(name, sSN, initialDeposit));
			}
			else if (accountType.equals("Checking")){
				
				accounts.add(new Checking(name, sSN, initialDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
			
		}
		
		
		for (Account acc: accounts) {
			System.out.println("\n************");
			acc.showInfo();
		}
	}

}
