package oopQ1;

import java.util.Scanner;

class Employee 
{
	String first_name;
	String last_name;
	
	Employee(String first_name, String last_name)
	{
		this.first_name= first_name;
		this.last_name= last_name;
	}
}

class CredentialService extends Employee
{
	private String password;
	private String department;
	private String email;
	private int defaultPasswordLength=8;
	private String companySuffix="company.com";

	//constructor to receive the first name and last name
	public CredentialService(String first_name,String last_name) 
	{
		super(first_name, last_name);
		this.department=setDepartment();
		this.password=generatePassword(defaultPasswordLength);
		System.out.println("Your password is: "+this.password+"\n\n");
		email=first_name.toLowerCase()+"."+last_name.toLowerCase()+"@" +department+"."+companySuffix;
	}

	private String setDepartment() 
	{
		System.out.print("New Employee: "+first_name + " " + last_name + "\nChoose DEPARTMENT:\n1. Technical\n2. Admin\n3. Human Resources\n4. Legal\nEnter the department : ");
		Scanner in=new Scanner(System.in);
		int depchoice=in.nextInt();
		if(depchoice==1) {
			return "tech";
		}
		else if(depchoice==2) {
			return "admin";
		}
		else if(depchoice==3) {
			return "hr";
		}
		else if(depchoice==4) {
			return "legal";
		}
		
		else {
			return "";
		}
	}

	private String generatePassword(int length) 
	{
		String passwordSet= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int rand=(int) (Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}

	public String showCredentials() 
	{
		return "Dear "+first_name+" your generated credentials are as follows: \nCOMPANY EMAIL: "+email+
				"\nTEMPORARY PASSWORD: "+password+"\n";
	}

	private String generateEmail() 
	{
		String email=first_name.toLowerCase()+"."+last_name.toLowerCase()+"@" +department+"."+companySuffix;
		return new String(email);
	}

}

class Main
{
	public static void main(String[] args) 
	{
		CredentialService crds = new CredentialService("Vihaan", "Arora");
		System.out.println(crds.showCredentials());
	}

}
	
	
	
	
	
	
	
	






















