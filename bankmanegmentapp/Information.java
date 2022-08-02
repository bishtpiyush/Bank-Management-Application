package bankmanegmentapp;

public class Information {

	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Information(String accountType, String customername, String dob, String pancard, long aadhar,
			String occupation, String minor, String address,Long mobail) {
		super();
		AccountType = accountType;
		Customername = customername;
		this.dob = dob;
		this.pancard = pancard;
		this.aadhar = aadhar;
		this.occupation = occupation;
		this.minor = minor;
		Address = address;
		this.mobail = mobail;
		
	}

	public long getAccountno() {
		return Accountno;
	}

	public void setAccountno(int accountno) {
		Accountno = accountno;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getAccountType() {
		return AccountType;
	}

	public void setAccountType(String accountType) {
		AccountType = accountType;
	}

	public String getCustomername() {
		return Customername;
	}

	public void setCustomername(String customername) {
		Customername = customername;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public double getAadhar() {
		return aadhar;
	}

	public void setAadhar(int aadhar) {
		this.aadhar = aadhar;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public float getAmount() {
		return Amount;
	}

	public void setAmount(float amount) {
		Amount = amount;
	}

	public float getLone() {
		return lone;
	}

	public void setLone(float lone) {
		this.lone = lone;
	}

	public String getInternetbanking() {
		return Internetbanking;
	}

	public void setInternetbanking(String internetbanking) {
		Internetbanking = internetbanking;
	}

	public String getDebitCardIsu() {
		return DebitCardIsu;
	}

	public void setDebitCardIsu(String debitCardIsu) {
		DebitCardIsu = debitCardIsu;
	}

	public long getDebitcardnumber() {
		return Debitcardnumber;
	}

	public void setDebitcardnumber(int debitcardnumber) {
		Debitcardnumber = debitcardnumber;
	}

	public int getAtmpass() {
		return atmpass;
	}

	public void setAtmpass(int atmpass) {
		this.atmpass = atmpass;
	}

	public String getInternetbankingpassword() {
		return internetbankingpassword;
	}

	public void setInternetbankingpassword(String internetbankingpassword) {
		this.internetbankingpassword = internetbankingpassword;
	}

	private long Accountno;
	private int customerid;
	private String AccountType;
	private String Customername;
	private String dob;
	private String pancard;
	private long aadhar;
	private String occupation;
	private String minor;
	private String Address;
	private float Amount;
	private float lone;
	private String Internetbanking;
	private String DebitCardIsu;
	private long Debitcardnumber;
	private int atmpass;
	private String internetbankingpassword;
	private long mobail;
	
	
	

	public void setAccountno(long accountno) {
		Accountno = accountno;
	}

	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}

	public void setDebitcardnumber(long debitcardnumber) {
		Debitcardnumber = debitcardnumber;
	}

	public long getMobail() {
		return mobail;
	}

	public void setMobail(long mobail) {
		this.mobail = mobail;
	}
	
	
	
	
	

}
