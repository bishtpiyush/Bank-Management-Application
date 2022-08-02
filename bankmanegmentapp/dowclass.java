package bankmanegmentapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class dowclass {

/*|---------------------------------------Apply New Customer Account-------------------------------------------|*/
	public static boolean applynewcustomer(Information inp) {
		boolean f = false;
		try {
			// connection create
			Connection con = cp.createC();

			// query
			String q = "insert into table1(AccountType,CustomerName,DateOfBirthday,PAN,AadharCard, Occupation, GuradianNameIfMinor,InternetBanking,DebitCardOrATMCard,CardNumber,Lone,Address,Amount,mobail) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			// Prepared Statement

			PreparedStatement pstmt = con.prepareStatement(q);

			// set perameter
			pstmt.setString(1, inp.getAccountType());
			pstmt.setString(2, inp.getCustomername());
			pstmt.setString(3, inp.getDob());
			pstmt.setString(4, inp.getPancard());
			pstmt.setDouble(5, inp.getAadhar());
			pstmt.setString(6, inp.getOccupation());
			pstmt.setString(7, inp.getMinor());
			pstmt.setString(8, "No");
			pstmt.setString(9, "NO");
			pstmt.setLong(10, 0);
			pstmt.setFloat(11, 0);
			pstmt.setString(12, inp.getAddress());
			pstmt.setFloat(13, 0);
			pstmt.setLong(14, inp.getMobail());
			
			

			// excute....
			pstmt.executeUpdate();
			
			
			
			/*
			 * Statement stmt = con.createStatement();{
			 * 
			 * String r
			 * ="insert into table2 select AccountNo,CustomerID,AccountType,CustomerName,DateOfBirthday,PAN,AadharCard,Occupation,GuradianNameIfMinor,InternetBanking,DebitCardOrATMCard,CardNumber,Lone,Address,Amount\r\n"
			 * + "from table1";
			 * 
			 * stmt.executeUpdate(r); //2
			 * 
			 * String t
			 * ="insert into table3 select AccountNo,CustomerID,AccountType,CustomerName,DateOfBirthday,PAN,AadharCard,Occupation,GuradianNameIfMinor,InternetBanking,DebitCardOrATMCard,CardNumber,Lone,Address,Amount\r\n"
			 * + "from table2";
			 * 
			 * stmt.executeUpdate(t); //3 String u=
			 * "insert into table4 select AccountNo,CustomerID,AccountType,CustomerName,DateOfBirthday,PAN,AadharCard,Occupation,GuradianNameIfMinor,InternetBanking,DebitCardOrATMCard,CardNumber,Lone,Address,Amount\\r\\n"
			 * + "from table3"; stmt.executeUpdate(u); }
			 */

			f = true;

			
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Something went to worng in dow class applynewcustomer method please try again letter.....");
		}
		return f;

	}
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|--------------------------------------------Apply New ATM--------------------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/
	public static boolean applynewatm(int customerid,long accountno, String dob, long mobail ) {
		boolean f = false;
		try {
			Connection con = cp.createC();
			String q ="select * from table1 where CustomerID="+customerid;
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			int setcustomerid =0;
			long setaccountnumber =0;
			String setdob = null;
			long setmobail = 0;
			String setAddress = null;
			String setname = null;
			while(set.next()) {
				setcustomerid = set.getInt(2);
				setaccountnumber = set.getLong(1);
				setdob = set.getString(5);
				setmobail = set.getLong(16);
				setAddress = set.getString(14);
				setname = set.getString(4);
				//System.out.println("customer id "+setcustomerid);
			}
			//1
/*------------------------------------------------------------------------------------------------------------*/			
			/*int i = 0;
			String b = "";
			String c="";
			while (i < setdob.length()) {
				if (setdob.charAt(i) != '-') {

					b = b + setdob.charAt(i);
					c= c+ dob.charAt(i);
					
				} else {
					b = b;
					c=c;
				}
				i++;
			}
			int h = Integer.parseInt(b);
			int d = Integer.parseInt(c);*/
/*-----------------------------------------------------------------------------------------------------------*/
			if(customerid==setcustomerid && accountno==setaccountnumber  && mobail==setmobail && dob.equals(setdob) ) {
				String r = "insert into Atminformation(AccountNo,CustomerID,Mobailnumber,Customername,DateOfBirthday,Address)values\r\n"
						+ "(?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(r);
				pstmt.setInt(2, setcustomerid);
				pstmt.setLong(1, setaccountnumber);
				pstmt.setString(5, setdob);
				pstmt.setLong( 3,setmobail);
				pstmt.setString(6, setAddress);
				pstmt.setString(4, setname);
				
				pstmt.executeUpdate();
				//2
/*------------------------------------------------------------------------------------------------------------*/
				
				String g ="select * from Atminformation where AccountNo="+setaccountnumber;
				Statement kstmt = con.createStatement();
				 ResultSet sett= kstmt.executeQuery(g);
				 long setcardnumber = 0;
				 while(sett.next()) {
					 setcardnumber= sett.getLong(3);
				 }//3
/*------------------------------------------------------------------------------------------------------------*/
			   String s="update table1 set CardNumber=? where AccountNo=?";
			   PreparedStatement spstmt = con.prepareStatement(s);
			   spstmt.setLong(1,setcardnumber );
			   spstmt.setLong(2, setaccountnumber);
			   spstmt.executeUpdate();
			  //4
/*------------------------------------------------------------------------------------------------------------*/
			  String p="update table1 set DebitCardOrATMCard=? where AccountNo=?";
			   PreparedStatement sspstmt = con.prepareStatement(p);
			   sspstmt.setString(1,"YES" );
			   sspstmt.setLong(2, setaccountnumber);
			   sspstmt.executeUpdate();
			  f= true;
			}
			else {
				System.out.println("please enter valid information........");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something went worng in apply  new atm connect to the bank");
		}
		return f;
	}
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|--------------------------------------------Add Money in Bank----------------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/
	public static boolean addbankmoney(long accountno,float amount) {
		boolean f = false;
		try {
			Connection con  = cp.createC();
			String q="select * from table1 where AccountNo="+accountno;
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			float g=0;
			while(set.next()) {
				
				g = set.getFloat(15);
			
		    }
			amount = amount+g;
			String r = "update table1 set Amount=? where AccountNo =?";
			PreparedStatement pstmt = con.prepareStatement(r);
			pstmt.setFloat(1, amount);
			pstmt.setLong(2, accountno);
			
			pstmt.executeUpdate();
			
			f =true;
			
		}
		catch(Exception  e) {
			System.out.println("Add money problem contect devloper team....");
			e.printStackTrace();
		}
		return f;
	}
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|--------------------------------------------Withdraw Money Bank--------------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/
	public static boolean withbankdraw(long accountno , float amount) {
		boolean f = false;
		try {
			Connection con  = cp.createC();
			String q="select * from table1 where AccountNo="+accountno;
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			float g=0;
			while(set.next()) {
				
				g = set.getFloat(15);
			
		    }if(g>amount) {
			amount = g-amount;
			String r = "update table1 set Amount=? where AccountNo =?";
			PreparedStatement pstmt = con.prepareStatement(r);
			pstmt.setFloat(1, amount);
			pstmt.setLong(2, accountno);
			
			pstmt.executeUpdate();
			f=true;
		    }
		    else {
		    	System.out.println("Please fill wright amount");
		    }
		    
			
			
		}
		catch(Exception  e) {
			System.out.println("Withdraw money problem contect devloper team....");
			e.printStackTrace();
		}
		
		
		
		return f;
	}

/*|-----------------------------------------------------------------------------------------------------------|*/
/*|--------------------------------------------TranjactinOnetoAnthor------------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/
	public static boolean tranjactiononetoanthor(long accountno,float amount,long trafariaccno) {
		boolean f = false;
		try {
			Connection con  = cp.createC();
			{String q="select * from table1 where AccountNo="+accountno;
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			float g=0;
			while(set.next()) {
				
				g = set.getFloat(15);
			
		    }if(g>amount) {
			g = g-amount;
			String r = "update table1 set Amount=? where AccountNo =?";
			PreparedStatement pstmt = con.prepareStatement(r);
			pstmt.setFloat(1, g);
			pstmt.setLong(2, accountno);
			
			pstmt.executeUpdate();
		    }
		    else {
		    	System.out.println("Please fill wright amount");
		    }}
/*-----------------------------------------------------------------------------------------------------------*/
		    String q="select * from table1 where AccountNo="+trafariaccno;
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			float h=0;
			while(set.next()) {
				
				h = set.getFloat(15);
			
		    }
			h = amount+h;
			String r = "update table1 set Amount=? where AccountNo =?";
			PreparedStatement pstmt = con.prepareStatement(r);
			pstmt.setFloat(1, h);
			pstmt.setLong(2, trafariaccno);
			
			pstmt.executeUpdate();
			
			f=true;
			
		}
		catch(Exception e) {
			System.out.println("TranjactinOnetoAnthor problem contect devloper team....");
			e.printStackTrace();
		}
		
		
		return f;
	}
	
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|--------------------------------------------DebitCardTranjaction-------------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/

	public static boolean debittranjaction(long cardnumber , int pin) {
		boolean f = false;
		Scanner sb = new Scanner(System.in);
		try {
			Connection con = cp.createC();
			String  q = "select * from atmpin where Cardnumber="+cardnumber;
					Statement stmt = con.createStatement();
			       ResultSet set = stmt.executeQuery(q);
			        long setcardnumber = 0;
			        int setpin =0;
			        while(set.next()) {
			        	setcardnumber = set.getLong(1);
			        	setpin = set.getInt(2);
			        }
			        if(setcardnumber==cardnumber&& pin ==setpin) {
			        	System.out.println("Enter amount....");
			        	float amount =sb.nextFloat();
			        	 String r ="select * from table1 where CardNumber="+cardnumber;
			        	 Statement stmtt = con.createStatement();
			        	 ResultSet sett = stmtt.executeQuery(r);
			        	 float setamount =0;
			        	 while(sett.next()) {
			        		 setamount = sett.getFloat(15);
			        	 }
/*-----------------------------------------------------------------------------------------------------------*/
			        	 
			        	 if(amount<setamount) {
			        		 setamount = setamount-amount;
			        		 String d ="update table1 set Amount=? where CardNumber=?";
			        		 PreparedStatement pstmt=con.prepareStatement(d);
			        		 pstmt.setFloat(1, setamount);
			        		 pstmt.setLong(2, setcardnumber);
			        		 
			        		pstmt.executeUpdate();
/*------------------------------------------------------------------------------------------------------------*/			        		
			        		 
			        		f=true;
			        	 }
			        	 else {
			        		 System.out.println("money is exit");
			        	 }
			        }
		}
		catch(Exception e) {
			System.out.println("DebitCardTranjaction problem contect devloper team....");
			e.printStackTrace();
		}
		return f;

	}

	
/*-------------------------------------onlinebanklogin---------------------------------------------------------*/
	public static boolean onlinebanklogin(int userid,String password) {
		boolean f = false;
		try {
			
			Connection con = cp.createC();
			String q = "select * from bankloging where userid="+userid;
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			int setuserid =0;
			String setpassword ="";
			while(set.next()) {
				setuserid = set.getInt(1);
				setpassword = set.getString(2);
			}
			if(setuserid==userid&&setpassword.equals(password)) {
				f =true;
			}else {
				f= false;
			}
			
		}
		catch(Exception e) {
			System.out.println("Onlinebanklogin problem contect devloper team....");
			e.printStackTrace();
		}
		return f;
	}
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|--------------------------------------------ShowAllDeatils-------------------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/	
	public static boolean showAlldeatls(long number,int i) {
		boolean f = false;
		try {
			Connection con = cp.createC();
			String q="";
			if(i==1) {
			 q="select * from table1 where AccountNo="+number;}
			else {
				 q="select * from table1 where CustomerID="+number;
			}
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			
			
			while(set.next()) {
				long accountno =set.getLong(1);
                int  CustomerID =set.getInt(2);
				String AccountType=set.getString(3);
				String CustomerName=set.getString(4);
				String DateOfBirthday=set.getString(5);
				String PAN = set.getString(6);
				long AadharCard = set.getLong(7);
				String Occupation = set.getString(8);
				String GuradianNameIfMinor= set.getString(9);
				String InternetBanking=set.getString(10);
				String DebitCardOrATMCard= set.getString(11);
				long CardNumber = set.getLong(12);
				float Lone= set.getFloat(13);
			    String	Address = set.getString(14);
				Float Amount = set.getFloat(15);
				System.out.println("1");
/*-----------------------------------------------------------------------------------------------------------*/
				System.out.println("Account number "+accountno);
				System.out.println("CustomerID "+CustomerID);
				System.out.println("AccountType "+AccountType);
				System.out.println("Customer Name "+CustomerName);
				System.out.println("DOB "+DateOfBirthday);
				System.out.println("Pan "+ PAN);
                System.out.println("AadharCard "+AadharCard);
                System.out.println("Occupation "+Occupation);
                System.out.println("Minor "+GuradianNameIfMinor);
	      	   System.out.println("InternetBanking "+InternetBanking);
	      	   System.out.println("DebitCard OR ATM Card "+DebitCardOrATMCard);
	      	   System.out.println("CardNumber "+CardNumber);
	      	   System.out.println("Lone "+Lone);
	      	   System.out.println("Address "+ Address);
	      	   System.out.println("Amount " + Amount);
	      	   
	      	   f= true;
			}
		}
		catch(Exception e) {
			System.out.println("ShowAllDeatils problem contect devloper team....");
			e.printStackTrace();
			
		}
		
		return f;
	}

	
/*---------------------------------------------Password Change-------------------------------------------------*/
	public static boolean changepassword(int customerid , String oldpassword) {
		boolean f = false;
		Scanner sb = new Scanner(System.in);
		try {
			Connection con = cp.createC();
			String q ="select * from onlinebanking where CustomerID="+customerid;
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			int setcustomerid =0;
			String setoldpassword="";
			while(set.next()) {
				setcustomerid= set.getInt(2);
				setoldpassword = set.getString(3);
				
			}
			if(setcustomerid==customerid&&setoldpassword.equals(oldpassword));
			{
				System.out.println("Enter new password");
				String newpassword= sb.next();
				System.out.println("Enter same password again");
				String newpasswordagain= sb.next();
				if(newpassword.equals(newpasswordagain)) {
					String s ="Update onlinebanking set onlinebankingpassword=? where CustomerID=? ";
					PreparedStatement pstmt = con.prepareStatement(s);
					pstmt.setString(1, newpassword);
					pstmt.setInt(2, setcustomerid);
					pstmt.executeUpdate();
					 f=true;
				}
				else {
					System.out.println("pleace Enter same passowrd both time");
				}
			}
		}
		catch(Exception e) {
			System.out.println("Password Change problem contect devloper team....");
			e.printStackTrace();
		}
		return f;
	}

/*|-----------------------------------------------------------------------------------------------------------|*/
/*|--------------------------------------------ApplyOnlineBanking---------------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/

	public static boolean applyonlinebanking(long accountno, int customerid, int mobail,String dob) {
		Scanner sb = new Scanner(System.in);
		boolean f = false;
		try {
			Connection con = cp.createC();
			String q="select * from table1 where AccountNo="+accountno;
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery(q);
            long setaccno=0;
            int setcustid =0;
            int setmobail=0;
            String setdob =null;
            String setname = null;
			while(set.next()) {
				
				 setaccno=set.getLong(1);
				 setcustid =set.getInt(2);
				 setmobail = set.getInt(16);
				 setdob = set.getString(5);
				 setname=set.getString(4);
			
		    }
			if(accountno==setaccno&&customerid==setcustid&&mobail==setmobail&&dob.equals(setdob)) {
				System.out.println("Enter password");
				String password= sb.next();
				System.out.println("Enter password agin same....");
				String passwordcopy = sb.next();
				if(password.equals(passwordcopy)) {
					String r="insert into onlinebanking(AccountNo,CustomerID,onlinebankingpassword,Mobailnumber,Customername,"
							+ "DateOfBirthday)value(?,?,?,?,?,?)"; 
					PreparedStatement pstmt=con.prepareStatement(r);
					pstmt.setLong(1, accountno);
					pstmt.setInt(2, customerid);
					pstmt.setString(3, password);
					pstmt.setInt(4, setmobail);
					pstmt.setString(5, setname);
					pstmt.setString(6, setdob);
					
					pstmt.executeUpdate();
					
					f=true;
					System.out.println("Password is set.....");
					String h ="update table1 set InternetBanking=? where AccountNo= ?";
					PreparedStatement spstmt = con.prepareStatement(h);
					spstmt.setString(1, "YES");
					spstmt.setLong(2, accountno);
					spstmt.executeUpdate();
					System.out.println("done...");
				}
				else {
					System.out.println("please enter same password both time");
				}
			}
		}
		catch(Exception e) {
			System.out.println("ApplyOnlineBanking problem contect bank team....");
			e.printStackTrace();
		}
		
		
		
		
		return f;
	}
	
/*|------------------------------------GenrateCustomerID-----------------------------------------------------|*/	
	public static boolean genratecustomerid(long accountno) {
		boolean f= false;
		try {
		Connection con = cp.createC();
		
		String q ="insert into table12(AccountNo)value(?)";
		 PreparedStatement pstmt=con.prepareStatement(q);
		 pstmt.setLong(1, accountno);
		 
		 pstmt.executeUpdate();
		 
		 f=true;
		 
		 
		 System.out.println("Customer ID is created.......");
		 
		}
		catch(Exception e){
			
			System.out.println("GenrateCustomerID problem contect bank team....");
			e.printStackTrace();
		    
		}
		
		return  f;
		
		
	}
	
/*|-----------------------------------------------------------------------------------------------------------|*/
/*|--------------------------------------------FetchCustomerIDMaindatabase------------------------------------|*/	
/*|-----------------------------------------------------------------------------------------------------------|*/
	public static boolean fetchcustomeridmaindatabase(int customerid, Long accountno) {
		boolean f = false;
		try {
			Connection con = cp.createC();
			
			String q = "update table1 set CustomerID=? where AccountNo =?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, customerid);
			pstmt.setLong(2, accountno);
			
			pstmt.executeUpdate();
			
			f =true;
			
			System.out.println("Your Account is succfully created......");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Something went to worng in  FetchCustomerIDtoMaindatabases  please try again letter.....");
		}
		
		
		return f;
	}
	
/*|------------------------------------------------FindCustomerID---------------------------------------------|*/	
	public static int findcustomerid() {
		// TODO Auto-generated method stub
		int f=0;
		try {
			//jdbc code.....
			Connection con=cp.createC();
			
			String q="select * from table12";
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			
			while(set.next()) {
				
				f = set.getInt(1);
				/*int id = set.getInt(1);
				String name = set.getString(2);
				String phone=set.getString(3);
				String city = set.getString(4);
				System.out.println("ID:"+id);
				System.out.println("NAME:"+name);
				System.out.println("PHONE:"+phone);
				System.out.println("CITY:"+city);
				System.out.println("---------------------------------------------------------");*/
				
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("FindCustomerID");
		}
		
		return f;
		
	}

/*|------------------------------------------------FindAccountNumber------------------------------------------|*/
    public static long findaccountnumber() {
		// TODO Auto-generated method stub
		long f=0;
		try {
			//jdbc code.....
			Connection con=cp.createC();
			
			String q="select * from table1";
			Statement stmt = con.createStatement();
			ResultSet set =stmt.executeQuery(q);
			
			while(set.next()) {
				
				f = set.getLong(1);
				/*int id = set.getInt(1);
				String name = set.getString(2);
				String phone=set.getString(3);
				String city = set.getString(4);
				System.out.println("ID:"+id);
				System.out.println("NAME:"+name);
				System.out.println("PHONE:"+phone);
				System.out.println("CITY:"+city);
				System.out.println("---------------------------------------------------------");*/
				
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("FindAccountNumber problem");
		}
		
		return f;
	}

/*|---------------------------------------OnlineTranjactionPasswordCheaking-----------------------------------|*/	
	public static boolean cheackonlinetranjaction(int customerid, String password) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			Connection con  = cp.createC();
			String q = "select * from onlinebanking where Customerid="+customerid;
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			int setcustomerid =0;
			String setpassword=null;
			String setname= null;
			while(set.next()) {
				setcustomerid = set.getInt(2);
				setpassword = set.getString(3);
				setname = set.getString(5);
			}
			if(setcustomerid==customerid&&setpassword.equals(password)) {
				System.out.println("Your Details are currect  MR. "+setname+" our net banking system....");
			}
			else {
				System.out.println("please enter wright customerid and password");
			}
			
			f= true;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("OnlineTranjactionPasswordCheaking Problem");
			
		}
		return f;
	}

/*-------------------------------------cheacktranctiontimedeatilsonline---------------------------------------*/
	public static boolean cheacktranctiontimedeatilsonline(int customerid, String password,
			long accountnumberbeneficiary, int customeridbeneficiary, float amount) {
		// TODO Auto-generated method stub
		boolean f= true;
		try {
			Connection con =cp.createC();
			String q="select * from table1 where AccountNo="+accountnumberbeneficiary;
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			long setaccountnumberbeneficiary = 0;
			int setcustomeridbeneficiary =0;
			while(set.next()) {
				setaccountnumberbeneficiary = set.getLong(1);
				setcustomeridbeneficiary = set.getInt(2);
			}
			if(setaccountnumberbeneficiary==accountnumberbeneficiary&& setcustomeridbeneficiary==customeridbeneficiary) {
				//cheackonlinetranjaction(customerid,  password);
				
				
				System.out.println("Benifisary Deatils are correct....");
				String r ="select * from onlinebanking where CustomerID="+customerid;
				Statement sstmt = con.createStatement();
				ResultSet sset = sstmt.executeQuery(r);
				int ssetcustomerid=0;
				long ssetaccountnumber =0;
				String ssetpassword="";
				while(sset.next()) {
					ssetcustomerid = sset.getInt(2);
					ssetaccountnumber = sset.getLong(1);
				      ssetpassword = sset.getString(3);
				}
				if(ssetcustomerid==customerid&&ssetpassword.equals(password)) {
					
					tranjactiononetoanthor( ssetaccountnumber, amount, setaccountnumberbeneficiary);	
					f= true;
				}
				
			}
		}
		catch(Exception e) {
			System.out.println("cheacktranctiontimedeatilsonline Problem");
			e.printStackTrace();
		}
		return f;
	}

/*------------------------------------------------ATMpinGenrate-----------------------------------------------*/	
	public static boolean atmpingenrate(long cardnumber, long accountnumber, int mobail) {
		Scanner sb =new Scanner(System.in);
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			Connection con = cp.createC();
			String q ="select * from atminformation where AccountNo="+accountnumber;
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			long setcardnumber =0;
			long setaccountnumber =0;
			int setmobail =0;
			while(set.next()) {
				setcardnumber = set.getLong(3);
				setaccountnumber = set.getLong(1);
				setmobail = set.getInt(4);
			}
/*----------------------------------------------------------------------------------------------------------*/			
			
			if(cardnumber==setcardnumber && accountnumber==setaccountnumber &&mobail==setmobail) {
				System.out.println("Enter your pin");
				int pin = sb.nextInt();
				System.out.println("Enter pin agin same...");
				int pin2 = sb.nextInt();
				if(pin==pin2) {
					String j="insert into atmpin(Cardnumber,pin)values(?,?)";
					PreparedStatement pstmt = con.prepareStatement(j);
					pstmt.setLong(1, setcardnumber);
					pstmt.setInt(2, pin);
					pstmt.executeUpdate();
					f =true;
/*------------------------------------------------------------------------------------------------------------*/							
				
				}
				else {
					System.out.println("Pleace enter same pin both time...");
				}
			}
			
			
		}
		catch(Exception e) {
			System.out.println("ATMpinGenrate Problem");
			e.printStackTrace();
		}
		return f;
	}
	
	
	

}
