package Callable_statement;
import java.util.*;
import java.sql.*;

public class Student_retrived_data 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##vicky","123");
			CallableStatement ca=con.prepareCall("{call retrivestudentdata(?,?,?,?,?,?,?,?,?,?,?) }");
			System.out.println("Enter the Student Roll Number: ");
			long stdrno=Long.parseLong(sc.nextLine().trim());
			ca.setLong(1, stdrno);
			ca.registerOutParameter(2, Types.VARCHAR);
			ca.registerOutParameter(3, Types.VARCHAR);
			ca.registerOutParameter(4, Types.VARCHAR);
			ca.registerOutParameter(5, Types.VARCHAR);
			ca.registerOutParameter(6, Types.INTEGER);
			ca.registerOutParameter(7, Types.VARCHAR);
			ca.registerOutParameter(8, Types.BIGINT);
			ca.registerOutParameter(9, Types.FLOAT);
			ca.registerOutParameter(10, Types.FLOAT);
			ca.registerOutParameter(11, Types.VARCHAR);
			ca.execute();
			System.out.println("-----Student details--------");
			System.out.println("Studants Name: "+ca.getString(2));
			System.out.println("Studants Branch : "+ca.getString(3));
			System.out.println("Studants city: "+ca.getString(4));
			System.out.println("Studants State: "+ca.getString(5));
			System.out.println("Studants pincode: "+ca.getInt(6));
			System.out.println("Studants Mail-Id: "+ca.getString(7));
			System.out.println("Studants Phone Number: "+ca.getLong(8));
			System.out.println("Studants Total-marks: "+ca.getFloat(9));
			System.out.println("Studants Percentage: "+ca.getFloat(10));
			System.out.println("Studants Result: "+ca.getString(11));
			ca.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
