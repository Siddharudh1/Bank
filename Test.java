package Mypackage;

import java.util.Scanner;


public class Test {

	public static void main(String[] args) throws Exception {
		Scanner sc1  = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Create CustomerAccount Username");
		String username = sc1.nextLine();
		System.out.println("Create CustomerAccount Pin");
		String pin = sc1.nextLine();
		
		System.out.println("USERNAME AND PIN genereated...");

		
		CustomerAccount CA  = new CustomerAccount(username ,pin);
		ATM obj = new ATM();
				
		int ch = 0;
		while(ch != 4) {
			System.out.println("*******BANK OPERATION************");
			System.out.println("Enter 1 to add money to account");
			System.out.println("Enter 2 to withdraw amount");
			System.out.println("Enter 3 to go to ATM operatin");
			System.out.println("Enter 4 to close Accunt");
			ch = sc1.nextInt();
			
			switch(ch) {
			case 1 :System.out.println("Enter the amount to add money");
					Double amount = sc2.nextDouble();	
					CA.addMoney(amount);
					
					break;
					
			case 2 :System.out.println("Enter the Withdraw amount");
					Double WithDrawAmount = sc2.nextDouble();
					CA.withdrawMoney(WithDrawAmount);
					
					break;
					
			case 3 :int ch1 =0;
					Scanner sc3 = new Scanner(System.in);
					Scanner sc4  = new Scanner(System.in);
					while(ch1 !=3) {
						System.out.println("**********ATM OPERATION************");
						System.out.println("Enter 1 to view balance");
						System.out.println("Enter 2 to withdraw money from ATM");
						System.out.println("Enter 3 to go back to BANK OPERATION");
						ch1 = sc1.nextInt();
						switch(ch1) {
						case 1 :System.out.println("Enter the username and pin to view balance");
								String username1 = sc3.nextLine();
								String pin1 = sc3.nextLine();
								if(username1.equals(username) && pin1.equals(pin))
									obj.viewBalance(username1, pin1);
								else throw new IllegalArgumentException("USERNAME OR PIN MISMATCH.....PLease enter valid username or pin");
								break;
								
						case 2 :System.out.println("Enter username,pin,amount to withdraw");
								String username2 = sc3.nextLine();	
								String pin2 = sc3.nextLine();
								Double amount1 = sc4.nextDouble();
								if(username2.equals(username) && pin2.equals(pin))
									obj.withdrawMoney(username2, pin2, amount1);
								else throw new IllegalArgumentException("USERNAME OR PIN MISMATCH.....PLease enter valid username or pin");
								break;
								
						case 3 :System.out.println();
								break;
								
						default :System.out.println("INVALID INPUT");
								break;
						}
					}
				
					break;
					
			case 4 :CA.closeAccount();
		
					break;
					
			default:System.out.println("INVALID INPUT");
			}
		}

		
	}

}

