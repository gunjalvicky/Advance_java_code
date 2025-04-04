package Callable_statement;

import java.util.*;
import java.awt.Window.Type;
import java.lang.*;
import java.sql.*;

public class Retrived_bankApplication_data {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##vicky","123");
		CallableStatement ca=con.prepareCall("{call retrivedetails70(?,?,?,?,?,?,?,?,?) }");
		System.out.println("Enter the Bank account Number to Retrive the Details:");
		Long accno=Long.parseLong(sc.nextLine().trim());
		ca.setLong(1, accno);
		ca.registerOutParameter(2, Types.VARCHAR);
		ca.registerOutParameter(3, Types.FLOAT);
		ca.registerOutParameter(4, Types.VARCHAR);
		ca.registerOutParameter(5, Types.VARCHAR);
		ca.registerOutParameter(6,  Types.VARCHAR);
		ca.registerOutParameter(7, Types.INTEGER);
		ca.registerOutParameter(8, Types.VARCHAR);
		ca.registerOutParameter(9, Types.BIGINT);
		ca.execute();
		System.out.println("-------------Customer Details---------");
		System.out.println("Customer Name: "+ca.getString(2));
		System.out.println("Customer balance: "+ca.getFloat(3));
		System.out.println("Customer account Type: "+ca.getString(4));
		System.out.println("Customer City: "+ca.getString(5));
		System.out.println("Customer State: "+ca.getString(6));
		System.out.println("Customer Pincode: "+ca.getInt(7));
		System.out.println("Customer Mail-id: "+ca.getString(8));
		System.out.println("Customer Phone-number: "+ca.getString(9));
		ca.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}

	}

}
