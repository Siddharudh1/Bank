package Mypackage;

public class CustomerAccount implements Account{
	private static String pin;
	private static Double balance = 0.0;
	private static String username;
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		if(username.equals(null) || username.trim().equals(" "))
			throw new IllegalArgumentException("Username should not be null or empty");
		else CustomerAccount.username = username;
	}
	public static Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public static String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		if(pin == null || pin.trim().equals(" "))
			throw new IllegalArgumentException("Invalid Pin");
		this.pin = pin;
	}
	public CustomerAccount(String username ,String pin) {
		if(pin.equals(null) || pin.trim().equals(" ") && username.equals(null) || username.trim().equals(" "))
			throw new IllegalArgumentException("Invalid Pin or username");
		else this.pin = pin;
	}
	@Override
	public void addMoney(Double amount) {
		// TODO Auto-generated method stub
		if(amount < 0)
			throw new IllegalArgumentException("amount should not be less than be Zero");
	    balance = amount + balance;
	    System.out.println("Amount credited successfully to account "+amount);
	}

	@Override
	public void withdrawMoney(Double amount) {
		// TODO Auto-generated method stub
		if(amount<0 || amount > balance)
			throw new IllegalArgumentException("Amount should not be less than Zero or Insufficient balance to withdraw money....! Add money to customer Accunt");
		balance = balance -amount;
		System.out.println("amount "+amount+" withdraw successfully" );
	}

	@Override
	public void closeAccount() {
		// TODO Auto-generated method stub
		this.balance=null;
		System.out.println("Account closed\n*********EXIT********");
		System.exit(0);
	}
	
}
