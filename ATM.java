package Mypackage;

public class ATM {
	
	private static String username;
	private String pin;
	public static String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(username.equals(null) || username.trim().equals(" "))
			throw new IllegalArgumentException("Username should not be null or empty");
		else this.username = username;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public void viewBalance(String username,String pin) {
		if(username == null || username.trim().equals(" ") || pin.trim().equals(" ") || pin == null) {
			throw new IllegalArgumentException("usename should not bu null and empty and pin shouls not be null or empty");
		}
		else if(pin.equals(CustomerAccount.getPin()) && username.equals(username)){
				System.out.println("Curent balance is: "+CustomerAccount.getBalance());
		}
		else throw new IllegalArgumentException("User name or PIN Mismatch");
	}
	public void withdrawMoney(String username ,String pin,Double amount) {
		if(username == null || username.trim().equals(" ") || pin.trim().equals(" ") || pin == null || amount > CustomerAccount.getBalance()) {
			throw new IllegalArgumentException("Insufficient balnce to withdraw");
		}
		else {
			if(pin.equals(CustomerAccount.getPin()) && username.equals(username)) 
			{
				double newBal=CustomerAccount.getBalance()-amount;
				CustomerAccount ca=new CustomerAccount(username,pin);
				ca.setBalance(newBal);
				System.out.println("Money withdraw is "+amount);
			}
			else throw new IllegalArgumentException("PIN  Mismatch");
		}
	}
}
