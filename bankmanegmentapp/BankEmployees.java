package bankmanegmentapp;

import java.io.Console;
import java.util.Scanner;

public class BankEmployees {

	public static void logingemloyees() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user id ");
		int userid = sc.nextInt();
		System.out.println("Enter password");
		String password = sc.next();
//		Console con = System.console();
//		char[] chars = con.readPassword();
//		String password = new String(chars);
                 boolean answer = dowclass.onlinebanklogin(userid, password);
		if(answer) {
			bankdeatils();
		}
		else {
			System.out.println("Please enter valid user id and password");
		}
		
		
	}
	
	
	public static void bankdeatils() {
		// TODO Auto-generated method stub
		/*Scanner sb = new Scanner(System.in);
		System.out.println("Enter user id ");
		String userid = sb.next();
		System.out.println("Enter password");
		Console con = System.console();
		char[] chars = con.readPassword();
		String password = new String(chars);*/
		Scanner sb = new Scanner(System.in);
		while (true) {
			System.out.println("...............!!!!!!!!!WELCOME TO UTTARAKAHND PRIVATE LIMITED BANK!!!!!!!!!...............");

			System.out.println("Add money press 1");
			System.out.println("Withdraw money press 2");
			System.out.println("Transaction one account to another account press 3");
			System.out.println("Account deatils to press 4");
			System.out.println("Logout deatils to press 5");
			int a = sb.nextInt();
			
				if (a == 1) {
					System.out.println("Enter account number");
					long accno = sb.nextLong();
					System.out.println("Enter amount");
					float amount = sb.nextFloat();
					boolean f = dowclass.addbankmoney(accno, amount);
					if (f) {
						System.out.println("money is succfully add");
					} else {
						System.out.println("server problem try agin latter");
					}
				}

				else if (a == 2) {
					System.out.println("Enter account number");
					long accno = sb.nextLong();
					System.out.println("Enter amount");
					float amount = sb.nextFloat();
					boolean f = dowclass.withbankdraw(accno, amount);
					if (f) {
						System.out.println("money is succfully withdraw");
					} else {
						System.out.println("server problem try agin latter");
					}
				}

				else if (a == 3) {
					System.out.println("Enter account number");
					long accno = sb.nextLong();
					System.out.println("Enter amount");
					float amount = sb.nextFloat();
					System.out.println("Enter tranfari account number");
					long tranfariaccno = sb.nextLong();
					boolean f = dowclass.tranjactiononetoanthor(accno, amount, tranfariaccno);
					if (f) {
						System.out.println("money is succfully transfer " + tranfariaccno + "this account");
					} else {
						System.out.println("server problem try agin latter");
					}

				}

				else if (a == 4) {
					System.out.println("if you enter account number click 1,if you enter customer id click 2"
							+ ",if you won't exit click 3");
					int b = sb.nextInt();
					if (b == 1) {
						System.out.println("Enter account number");
						long number = sb.nextLong();
						boolean answer = dowclass.showAlldeatls(number, b);
						if (answer) {
							System.out.println(".....DONE......");
						} else {
							System.out.println("Something went to worng.....");
						}
					} else if (b == 2) {
						System.out.println("Enter Customer ID");
						long number = sb.nextLong();
						boolean answer = dowclass.showAlldeatls(number, b);
						if (answer) {
							System.out.println(".....DONE......");
						} else {
							System.out.println("Something went to worng.....");
						}
					}

					else if (b == 3) {
						BankEmployees.logingemloyees();
					} else {
						System.out.println("enter valid key");
					}
				}

				else if (a == 5) {
					break;
				} else {

				}

			}

		}

		
		// Console con = System.console();
		// char[] chars=con.readPassword();
		// String password = new String(chars);

	

}
