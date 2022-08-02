package bankmanegmentapp;

import java.util.Scanner;

public class ApplyNewCustomer {

	public static void newBankAccount() {
		Scanner sb = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter your Full Name");
		String name = sb.nextLine();
		System.out.println("Enter your Date of Brith(yyyy-mm-dd)");
		String dob = sb.next();
		// System.out.println("is your pancard available click 1 otherwise click 2");
		// {
		// int a = sb.nextInt();
		// if (a == 1) {
		System.out.println("Enter your pancard Number");
		String pancard = sb.next();
		// }
		// if (a == 2) {
		// String pancard = "No";
		// }
		// }
		System.out.println("is your Aadhar Card available click 1 otherwise click 2");
		long aadharcard = 0;
		{
			int a = sb.nextInt();
			if (a == 1) {
				System.out.println("Enter your Aadharcard Number");
				aadharcard = sb.nextLong();
			}
			if (a == 2) {
				aadharcard = 0000;
			}
		}
		System.out.println("what type of account of open it...press 1 if Saving Ac or press 2 if Current AC");
		String accounttype = null;
		{
			int a = sb.nextInt();
			if (a == 1) {
				accounttype = "Saving Account";
			}
			if (a == 2) {
				accounttype = "Current Account";
			}
		}
		System.out.println("is Account Holder is Minor press 1 outherwise press 2");
		String guardianame = null;
		{
			int a = sb.nextInt();
			sb.nextLine();
			if (a == 1) {
				System.out.println("Enter Guardian Name");
				guardianame = sb.nextLine();
				
				
				
			}
			if (a == 2) {
				guardianame = "No";
			}
		}
		System.out.println("Enetr your occupation");
		String occupation = sb.next();
		sb.nextLine();

		System.out.println("Enetr your Address Without pincode, Distict, State Name");
		String address = sb.nextLine();
		System.out.println("Enter your Pincode Number");
		int pincode = sb.nextInt();
		System.out.println("Enter your District Name");
		String district = sb.next();
		System.out.println("Enter your State Name");
		String state = sb.next();

		String Address = address + " " + district + " " + state + " " + pincode;
		
		System.out.println("Enter your mobail number");
		long mobail=sb.nextLong();

		Information inp = new Information(accounttype, name, dob, pancard, aadharcard, occupation, guardianame,
				Address,mobail);
		boolean answer = dowclass.applynewcustomer(inp);
		if (answer) {
			System.out.println("****************1*******************");
/*****************************************************************************************************************/
			long accountno = dowclass.findaccountnumber();
			boolean answer2 = dowclass.genratecustomerid(accountno);
			if(answer2) {
				System.out.println("**************2*******************");
			}
			else {
				System.out.println("something went to worng please contect to the bank");
			}
			int customerid = dowclass.findcustomerid();
			boolean answer3 = dowclass.fetchcustomeridmaindatabase(customerid, accountno);
			if(answer3) {
				System.out.println("account is fully done......");
			}
			else {
				System.out.println("something went to worng please contect to the bank");
			}
/**************************************************************************************************************/
			
		} else {
			System.out.println("work is not done......");
		}
		
		
/*---------------------------------------------------------------------------------------------------------------*/		
		
/*------------------------------------------------------------------------------------------------------------*/
		
	}

	
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|---------------------------------------Apply New ATM-------------------------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/
/*done*/	
	public static void newATMcard() {
		Scanner sb = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter your CustomerID");
		int customerid = sb.nextInt();
		System.out.println("Enter your Account No");
		long accountno =sb.nextLong();
		System.out.println("Enter your DateOfBirthday");
		String dob = sb.next();
		System.out.println("Enter your Mobail Number");
		long mobail = sb.nextLong();
		boolean answer = dowclass.applynewatm(customerid, accountno, dob, mobail);
		if(answer) {
			System.out.println("Succfully atm apply ");
		}
		else {
			System.out.println("ATM is not apply");
		}
		
                 
	}

}
