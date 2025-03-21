package UserManage;

import java.sql.*;
import java.util.Scanner;

public class UserManagement {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Input 
				while(true) {
					
					System.out.println("****** USER MANAGEMENT SYSTEM ******");
					System.out.println("1. ADD USER");
					System.out.println("2. VIEW USERS");
					System.out.println("3. UPDATE USER");
					System.out.println("4. DELETE USER");
					System.out.println("5. EXIT");
					System.out.println("Enter Your Choice : ");
					int mychoice = scan.nextInt();
					scan.nextLine();
					
					switch(mychoice) {
					case 1 : addUser(); break;
					case 2 : viewUser(); break;
					case 3 : updateUser(); break;
					case 4 : deleteUser(); break;
					case 5 :  { 
						System.out.println("Exiting From Program....");
						System.out.println("Thank You");
					    System.exit(0);
					} break;
					default : {System.out.println("Choice Valid Options !");}
					
					}
				}
	
	}

	
	//To Add User's Details
	
	public static void addUser() {
		//To Add User Name
		System.out.println("Enter Name :");
		String name = scan.nextLine();
		
		//To Add User Age
		System.out.println("Enter Age :");
		int age = scan.nextInt();
		scan.nextLine();
		
		//To Add User Salary
		System.out.println("Enter Salary");
		double salary = scan.nextDouble();
		scan.nextLine();
		
	
		String sql = "INSERT INTO usermanage (name, age, salary) VALUES (?,?,?)";
		try(Connection conn = PostgreSQLConnection.dbconnect();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, salary);
			pstmt.executeUpdate();
			
			System.out.println("User's Details Added Successfully....! \n");
			
			
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}


	//To View List Of Added Users.
	public static void viewUser(){
		String sql = "SELECT * FROM usermanage";
		try( Connection conn = PostgreSQLConnection.dbconnect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql); 
				
			){System.out.println("Users List :");
			while(rs.next()) {
				System.out.println("ID :"+ rs.getInt("id") 
				                   +", Name :"+ rs.getString("name") 
				                   +", Age :"+ rs.getInt("age") 
				                   +", Salary :"+ rs.getInt("salary") +"\n");
			}
			
		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	//To Update User Details.
	public static void updateUser() {
		
		//Enter ID To Update Particular User Details.
		System.out.println("Enter Current User's ID To Update");
		int id = scan.nextInt();
		scan.nextLine();
		
		//Enter Name To Update Particular User Details.
		System.out.println("Enter Current User's Name To Update");
		String name = scan.nextLine();
		
		//Enter New User ID
		System.out.println("Enter New User's ID :");
		int newid = scan.nextInt();
		scan.nextLine();
		
		//Enter New Name.
		System.out.println("Enter New User's Name : ");
		String newname = scan.nextLine();
		scan.nextLine();
		
		//Enter New Age.
		System.out.println("Enter New User's Age : ");
		int newage = scan.nextInt();
		scan.nextLine();
		
		//Enter New Salary.
		System.out.println("Enter New User's Salary : ");
		double newsalary =scan.nextDouble();
		scan.nextLine();
		
		
		String sql = "UPDATE usermanage SET id=?, name=?, age=?, salary=? WHERE id=? AND name=?";
		try( Connection conn = PostgreSQLConnection.dbconnect();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, newid);
			pstmt.setString(2,newname);
			pstmt.setInt(3, newage);
			pstmt.setDouble(4, newsalary);
			pstmt.setInt(5, id);
			pstmt.setString(6, name);
			pstmt.executeUpdate();
			System.out.println("User's Details Updated Successfully ! \n");
		}catch(SQLException e) {e.printStackTrace();}
	}


	// To Delete User Details.
	public static void deleteUser(){
		System.out.println("Enter User's ID To Delete :");
		int id = scan.nextInt();
		scan.nextLine();
		
		String sql = "DELETE FROM usermanage WHERE id=?";
		try(Connection conn = PostgreSQLConnection.dbconnect();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("User's Details Deleted Successfully ! \n");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
