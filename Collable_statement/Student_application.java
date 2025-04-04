package Callable_statement;
import java.util.*;
import java.sql.*;
import java.io.*;
public class Student_application {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		final String result;
		try(sc;)
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##vicky","123");
		CallableStatement ca=con.prepareCall("{ call createstudentdata(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		System.out.println("Enter the Roll Number:");
		int rno=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the name :");
		String stdname=sc.nextLine();
		System.out.println("Enter the branch:");
		String branch=sc.nextLine();
		System.out.println("Enter the City:");
		String city=sc.nextLine();
		System.out.println("Enter the state:");
		String state=sc.nextLine();
		System.out.println("Enter the pincode:");
		int pin=Integer.parseInt(sc.nextLine());
		System.out.println("Ente the mid:");
		String mail=sc.nextLine();
		System.out.println("Enter the Mobile Number:");
		long phno=Long.parseLong(sc.nextLine());
		System.out.println("Enter the ML Mark:");
		int ml=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Toc  Mark:");
		int toc=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the DBMS Mark:");
		int dbms=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the IOT Mark:");
		int iot=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the CNS Mark:");
		int cns=Integer.parseInt(sc.nextLine());
		System.out.println("Enter the SPOS Mark:");
		int spos=Integer.parseInt(sc.nextLine());
		
		float totmarks=(ml+toc+dbms+iot+cns+spos);
		float per =totmarks/6;
		if(per>=35)
		{
			result="pass";
//			ca.setString(17,result);
		}else
		{
			 result="Failed";
//			ca.setString(17, result);
		}
		
		ca.setInt(1, rno);
		ca.setString(2, stdname);
		ca.setString(3, branch);
		ca.setString(4, city);
		ca.setString(5, state);
		ca.setInt(6, pin);
		ca.setString(7, mail);
		ca.setLong(8, phno);
		ca.setInt(9,ml);
		ca.setInt(10,toc);
		ca.setInt(11,dbms);
		ca.setInt(12,iot);
		ca.setInt(13,cns);
		ca.setInt(14,spos);
		ca.setFloat(15,totmarks);
		ca.setFloat(16, per);
		ca.setString(17, result);
		ca.execute();
		System.out.println("Student Data Are Successful.");
		
		}catch( Exception e)
		{
			e.printStackTrace();
		}
		
		
		

	}

}
