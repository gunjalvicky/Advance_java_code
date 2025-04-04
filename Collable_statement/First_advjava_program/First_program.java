package First_advjava_program;

import java.sql.*;

public class First_program 
{
	public static void main(String[] args)
	{
		//loading driver
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//create connection 
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##VICKY","123");
		//creating jdbc connection
		Statement stm=con.createStatement();
		//execute query
		ResultSet rs=stm.executeQuery("select * from customer70");
		System.out.println("---------Customer Details-------------");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getLong(5));
		}
		//con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

	