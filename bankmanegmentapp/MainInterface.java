package bankmanegmentapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainInterface {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("!!!....WELCOME TO UTTARAKAHND PRIVATE LIMITED BANK....!!!");
		System.out.println("_________________________________________________________");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       Scanner sb = new Scanner(System.in);
		while (true) {
			System.out.println("\n1.  Apply a New Bank Account Click 1............");
			System.out.println("\n2.  Apply  New ATM Card Click 2.................");
			System.out.println("\n3.  Online Payment Click 3......................");
			System.out.println("\n4.  Bank Employess Longing Click 4..............");
			System.out.println("\n5.  Debit or ATM Card Tranjation Click 5........");
			System.out.println("\n6.  For Exit Click 6............................");

			int click = Integer.parseInt(br.readLine());

			if (click == 1) {

				ApplyNewCustomer.newBankAccount();
				//Information sp= new Information();
				//System.out.println(sp.getAddress())
			}

			else if (click == 2) {
				ApplyNewCustomer.newATMcard();
			}

			else if (click == 3) {
				Tranjaction.onlinepayment();
			} else if (click == 4) {
				BankEmployees.logingemloyees();
			} else if (click == 5) {
				Tranjaction.debitcard();
			}

			else if (click == 6) {
				

				break;
			} else {
                         
			}

		}
		System.out.println("!!!....Thank you   for using UTTARAKAHND PRIVATE LIMITED BANK....!!!");
		System.out.println("!!!....See you soon....!!!");

	}
}
