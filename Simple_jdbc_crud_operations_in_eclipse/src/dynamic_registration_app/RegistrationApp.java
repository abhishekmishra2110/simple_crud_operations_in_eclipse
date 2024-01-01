package dynamic_registration_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RegistrationApp {
	public static void main(String[] args) {
		System.out.println("WELCOME TO REGISTRATION APP!!");
		
		System.out.println("SELECT OPTION");
		
		System.out.println("Select:1 For Add Registration");
		
		System.out.println("Select:2 For Delete Registration");
		
		System.out.println("Select:3 For Update Registration");
		
		System.out.println("Select:4 For Read Registration");
		
		System.out.println("Give Your Input...");
		try {
			// code for jdbc connection to data base
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Student_Table","root","123456789");
			Statement stmnt = con.createStatement();
			
			//taking input from users 
			Scanner input = new Scanner(System.in);
			System.out.println("Input:");
			int options = input.nextInt();
			
			if(options==1) {
				
				System.out.println("Enter Your ID");
		
				String id = input.next();
				
				System.out.println("Enter Your Name");
				String name = input.next();
				
				System.out.println("Enter your Course");
				String cource = input.next();
				
				System.out.println("Enter your Fees");
				String fee = input.next();
				
				stmnt.executeUpdate("insert into Student_Table values('"+id+"','"+name+"','"+cource+"','"+fee+"')");
				
				con.close();

				
			}
			else if(options==2) {
				System.out.println("Enter Your Email Id Delete Record ");
				String name = input.next();
				stmnt.executeUpdate("Delete from Student_Table where name=('"+name+"') ");
			
			}
			else if(options==3) {
				System.out.println("Enter Your Id to update your Record ");
				String id1 = input.next();
				
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter Your New Name");
				String newname = scanner.next();
				
				System.out.println("Enter your New Course");
				String newcourse = scanner.next();
				
				System.out.println("Enter your New Fees");
				String newfee = scanner.next();
				
				String updateQery= "UPDATE Student_Table SET name = ?, course = ?, fee = ? WHERE id =('"+id1+"')";
				PreparedStatement preparedStatement = con.prepareStatement(updateQery);
	                preparedStatement.setString(1, newname);
	                preparedStatement.setString(2, newcourse);
	                preparedStatement.setString(3, newfee);
	               

	                preparedStatement.executeUpdate();
	                con.close();
			
			
			
			}
			else if(options==4) {
				ResultSet result = stmnt.executeQuery("select * from Student_Table");
				while(result.next()) {
					System.out.println(result.getString(1));
					System.out.println(result.getString(2));
					System.out.println(result.getString(3));
					System.out.println(result.getString(4));
					
				}
			}
			else {
				System.out.println("Invalid Output");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
