package BankingApplication;

import java.util.Scanner;
import java.util.UUID;

public class BankAccount {
	public int balance;
	public int previousTransaction;
	public String customerName;
	public String customerId;
	

	public BankAccount(String cName) {
		this.customerId = UUID.randomUUID().toString(); //generating an unique ID 
		this.customerName = cName;
	}

	//all my operations come here
	
	public void Deposit(int amount) {
		if(amount > 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	public void Withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction  = amount;
		}
	}
	
	public void GetPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited: " +previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn: " + Math.abs(previousTransaction)); //always gives a positive value with the Math.abs
		}
		else {
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu() {
		char option ='\0';
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nWelcome " + customerName + " your id number is: " + customerId);
		System.out.println("\n");
		
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous transaction");
		System.out.println("E. Exit");
		
		do {
			System.out.println("====================================================================================================");
			System.out.println("Enter an option");
			System.out.println("====================================================================================================");
			option = scanner.next().charAt(0);
			System.out.println();
			
			
			switch (option) {
			case 'A':
				System.out.println("-----------------------------------");
				System.out.println("Balance = " + balance);
				System.out.println("-----------------------------------");
				System.out.println("\n");
				break;

			case 'B':
				System.out.println("-----------------------------------");
				System.out.println("Enter the amount to deposit");
				System.out.println("-----------------------------------");
				int amount = scanner.nextInt();
				Deposit(amount);
				System.out.println("\n");
				break;
			case 'C':
				System.out.println("-----------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("-----------------------------------");
				int amount1 = scanner.nextInt();
				Withdraw(amount1);
				System.out.println("\n");
				break;
			case 'D':
				System.out.println("-----------------------------------");
				GetPreviousTransaction();
				System.out.println("-----------------------------------");
				System.out.println("\n");
				break;
			case 'E':
				System.out.println("Thank you have a great day");
				break;
			default:
				System.out.println("Invalid Option! Try using a valid one.");
				break;
			}
			
		} while (option != 'E');
		
	}

}
