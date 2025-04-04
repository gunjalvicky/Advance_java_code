package First_advjava_program;
import java.util.*;
import java.sql.*;
public class Customer70_insert_Operation 
{

	public static void main(String[] args) throws SQLIntegrityConstraintViolationException
	{
		Scanner sc=new Scanner(System.in);
		try(sc;) {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","C##VICKY","123");
			Statement stm=con.createStatement();
			while(true)
			{
				System.out.println("--------operation choice----------");
				System.out.println("1) Add Customer\n"
						+"2) View All customer Data\n"
						+"3) View Customer data by ID\n"
						+"4) Exit");
				System.out.println("Enter the Choice:");
				int choice=Integer.parseInt(sc.nextLine());
				switch(choice)
				{
				case 1:
					System.out.println("Adding a customer Details...");
					System.out.println("Enter the Customer Id: ");
					int id=Integer.parseInt(sc.nextLine());
					System.out.println("Enter the Customer Name:");
					String name=sc.nextLine();
					System.out.println("Enter the Customer City:");
					String city=sc.nextLine();
					System.out.println("Enter the EmailId:");
					String mailid=sc.nextLine();					
					System.out.println("Enter the Mobile Number:");
					long phoNo=Long.parseLong(sc.nextLine());
					int k=stm.executeUpdate("insert into customer70 values("+id+",'"+name+"','"+city+"','"+mailid+"',"+phoNo+")");
					
					if(k>0)
					{
						System.out.println("Customer data added successefully..");
					}
					break;
				case 2:
					ResultSet set=stm.executeQuery("select * from customer70");
					System.out.println("-----Customer Data-------");
					while(set.next())
					
					{
					System.out.println(set.getInt(1)+"\t"+set.getString(2)+"\t"+set.getString(3)+"\t"+set.getString(4)+"\t"+set.getLong(5));
					}
					break;
				case 3:
					System.out.println("Enter the Customer id to diplay the details..");
					int cid=Integer.parseInt(sc.nextLine());
					
					ResultSet set1=stm.executeQuery("select * from customer70 where id="+cid+"");
					if(set1.next())
					{
						System.out.println(set1.getInt(1)+"\t"+set1.getString(2)+"\t"+set1.getString(3)+"\t"+set1.getString(4)+"\t"+set1.getLong(5));
					}else 
					{
						System.out.println("Invalid Customer Id.");
					}
					break;
				case 4:
					System.out.println("Operation Stopped....");
					System.exit(0);
					default:
						System.out.println("Invalid choice..");
					
				}

			}
			
		} catch (Exception e) 
		{
			System.out.println("Customer Details are already exist..");
		}
		

	}

}
