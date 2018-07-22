package BankAccountApp;

public interface IBaseRate {
	
	// Write an abstract method that returns the base rate
	default double getBaseRate() {return 2.5;}
	
	
	
}
