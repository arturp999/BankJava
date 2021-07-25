package BankingApplication;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String cName;
		Scanner obj = new Scanner(System.in);
		
		System.out.println("Your Name: " );
		cName = obj.next();

		
		BankAccount bank = new BankAccount(cName);
		bank.showMenu();
	}
}
