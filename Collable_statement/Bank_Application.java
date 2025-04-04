package Callable_statement;
import java.sql.*;
import java.util.Scanner;
public class Bank_Application {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		try(sc;){
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##vicky","123");
		CallableStatement ca=con.prepareCall("{call createaccount70(?,?,?,?,?,?,?,?,?)}");
		System.out.println("Enter the Account Number:");
		long accno=Long.parseLong(sc.nextLine());
		System.out.println("Enter the Cust-Name:");
		String name=sc.nextLine();
		System.out.println("Enter the Cust-Bal:");
		float bal=Float.parseFloat(sc.nextLine());
		System.out.println("Enter the Cust-Acctype:");
		String acctype=sc.nextLine();
		System.out.println("Enter the Cust-city:");
		String city=sc.nextLine();
		System.out.println("Enter the Cust-state:");
		String state=sc.nextLine();
		System.out.println("Enter the Cust-pincode:");
		int pincode=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Cust-MailID:");
		String mid=sc.nextLine();
		System.out.println("Enter the Cust-Mobile Number:");
		long phno=Long.parseLong(sc.nextLine());
		
		ca.setLong(1,accno);
		ca.setString(2, name);
		ca.setFloat(3, bal);
		ca.setString(4, acctype);
		ca.setString(5, city);
		ca.setString(6, state);
		ca.setInt(7,pincode);
		ca.setString(8,mid);
		ca.setLong(9, phno);
		ca.execute();
		System.out.println("Customer Account Created Successfully.");
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
