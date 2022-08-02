package bankmanegmentapp;

import java.util.Scanner;

public class Tranjaction {

	public static void onlinepayment() {
		Scanner sb = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("loging click 1 and apply online banking click 2");
		{
			int a = sb.nextInt();

			if (a == 1) {
				System.out.println("Enter your Customer ID");
				int customerid = sb.nextInt();
				System.out.println("Enter your Account Number");
				long accountnumber = sb.nextLong();
				System.out.println("Enter your Password");
				String password = sb.next();
				boolean answer = dowclass.cheackonlinetranjaction(customerid,password);
				if (answer ) {
					int i=2;
					while (true) {
					dowclass.showAlldeatls(customerid,i );
					System.out.println("press 1 for  Transaction");
					System.out.println("press 2 for Change Password");
					System.out.println("press 3 for Logout...");
					int b = sb.nextInt();
					
						if (b == 1) {
							System.out.println("Enter Beneficiary Account Number ");
							long accountnumberbeneficiary = sb.nextLong();
							System.out.println("Enter Beneficiary Customer ID ");
							int customeridbeneficiary = sb.nextInt();
							System.out.println("Enter your Password");
							String passwords = sb.next();
							System.out.println("Enter Amount..");
							float amount =sb.nextFloat(); 
							boolean trajaction = dowclass.cheacktranctiontimedeatilsonline(customerid,password,accountnumberbeneficiary,customeridbeneficiary,amount);
							if (trajaction == true) {
								             System.out.println("Tranjaction is succfully done....");
								/*{
								boolean donetranjaction = dowclass.tranjactiononetoanthor();
								if (donetranjaction == true) {
									System.out.println("Tranjaction is succfully done....");
								} else {
									System.out.println("System error....please try again latter");
								}*/
							}else {
							System.out.println("pleace fill all wright deatils.....");}
							
						} else if (b == 2) {

							System.out.println("Enter your Old Password");
							String oldpassword = sb.next();/*
							System.out.println("Enetr your new password");
							String newpassword = sb.next();
							System.out.println("Enter again same new password");
							String newpasswordagin = sb.next();*/
							boolean answerpassword = dowclass.changepassword(customerid,oldpassword );
							if (answerpassword == true) {
								System.out.println("Your Password is Succfully Changed.....");
							} else {
								System.out.println("Fill all the Details Currect....");
							}

						} else if (b == 3) {

							break;
						} else {
							System.out.println("Enter Right Key....");
						}
					}
				} else {
					System.out.println("Pleace Fill the Right Details");
				}
			}
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|---------------------------------------------Apply online banking------------------------------------------|*/
/*|-----------------------------------------------------------------------------------------------------------|*/			
			if (a == 2) {
				System.out.println("Enter your Customer ID");
				int customerid = sb.nextInt();
				System.out.println("Enter your Account Number");
				long Accountnumber = sb.nextLong();
				System.out.println("Enter your Mobail Number");
				int mobailnumber = sb.nextInt();
				/*System.out.println("Enter your Name");
				String name = sb.next();*/
				System.out.println("Enter your Date of Birth");
				String dob = sb.next();

				boolean answer = dowclass.applyonlinebanking(Accountnumber, customerid, mobailnumber, dob);
				if (answer == true) {
					System.out.println("Succfully apply online banking.....");
				} else {
					System.out.println("please enter wright deatils......");
				}

			}

		}
	}
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|---------------------------------------DebitCard Tranjaction-----------------------------------------------|*/
/*|-----------------------------------------------------------------------------------------------------------|*/

/*all done*/	
	public static void debitcard() {
		// TODO Auto-generated method stub
		Scanner sb = new Scanner(System.in);
		System.out.println("Enter your card Number....");
		long cardnumber = sb.nextLong();
		while(true) {
		System.out.println("Enter password press 1");
		System.out.println("Gentrate password press 2");
		System.out.println("Exit to press 3");
		int a = sb.nextInt();
		 {
			if (a == 1) {
				System.out.println("Enter your pin");
				int pin = sb.nextInt();
				boolean answer =dowclass.debittranjaction(cardnumber, pin);
				if(answer) {
					System.out.println("money withdraw");
				}
				else {
					System.out.println("Money is not withdraw.....");
				}
				// dow class
			} else if (a == 2) {
				System.out.println("Enter your account number");
				long accountnumber = sb.nextLong();
				System.out.println("Enter mobail number....");
				int mobail = sb.nextInt();
				boolean answer=dowclass.atmpingenrate(cardnumber,accountnumber,mobail);
				if(answer) {
					System.out.println("pin genrated.....");
				}
				else {
					System.out.println("Somethng went to worng Pin is not genrated.....");
				}
				// dow class

			} 
		 
			else if (a == 3) {
				break;
			} 
			else {

			}
		}

	}

  }
}
