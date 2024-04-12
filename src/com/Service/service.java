package com.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Connection.connection;;

public class service
{
	public static void InsertDta() 
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Employee ID :");
		int id = sc.nextInt();
		System.out.println("Enter the Employee First name:");
		String firstname = sc.next();
		System.out.println("Enter the Employee Last name:");
		String lastname = sc.next();
		System.out.println("Enter the Employee city name:");
		String city = sc.next();

		Connection con = connection.getConnection();
		String sql = "insert into employee(ID,FirstName,LastName,City)" + "values(?,?,?,?)";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, firstname);
			pst.setString(3, lastname);
			pst.setString(4, city);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Data inserted successfully.");
			} else {
				System.out.println("Failed to insert data.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//----------------------------------------------------------------------------------------------
	public static void UpdateData() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Employee ID to update:");
		int id = sc.nextInt();
		System.out.println("Enter the new Employee First name:");
		String firstname = sc.next();
		System.out.println("Enter the new Employee Last name:");
		String lastname = sc.next();
		System.out.println("Enter the new Employee city name:");
		String city = sc.next();

		Connection con = connection.getConnection();

		String sql = "UPDATE employee SET FirstName=?, LastName=?, City=? WHERE ID=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, firstname);
			pst.setString(2, lastname);
			pst.setString(3, city);
			pst.setInt(4, id);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Data updated successfully.");
			} else {
				System.out.println("No employee found with ID " + id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//----------------------------------------------------------------------------------------

	public static void DeleteData() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the Employee ID to delete:");
		int id = sc.nextInt();

		Connection con = connection.getConnection();
		String sql = "DELETE FROM employee WHERE ID=?";

		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Data deleted successfully.");
			} else {
				System.out.println("No employee found with ID " + id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//---------------------------------------------------------------------------------------

	public static void CollableStatement() {

	}

	//------------------------------------------------------------------------------------
	public static void GetData() {
		Connection con = connection.getConnection();
		String sql = "SELECT * FROM employee";

		try {
			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			System.out.println("Employee Data:");
	        System.out.printf("%-5s%-15s%-15s%-10s%n", "ID", "First Name", "Last Name", "City");
			while (rs.next()) {
				int id = rs.getInt("ID");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String city = rs.getString("City");
	            System.out.printf("%-5d%-15s%-15s%-10s%n", id, firstName, lastName, city);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//-----------------------------------------------------------------------------------------------
	public static void FetchData_Byname() {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Your name:");
		String name=sc.next();
	    Connection con = connection.getConnection();
	    String sql = "SELECT * FROM employee WHERE FirstName LIKE ? OR LastName LIKE ?";

	    try {
	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, "%" + name + "%");
	        pst.setString(2, "%" + name + "%");
	        ResultSet rs = pst.executeQuery();

	        System.out.println("Employee Data:");
	        System.out.printf("%-5s%-15s%-15s%-10s%n", "ID", "First Name", "Last Name", "City");
	        
	        boolean found = false;
	        while (rs.next()) {
	        	found =true;
	            int id = rs.getInt("ID");
	            String firstName = rs.getString("FirstName");
	            String lastName = rs.getString("LastName");
	            String city = rs.getString("City");
	            System.out.printf("%-5d%-15s%-15s%-10s%n", id, firstName, lastName, city);
	        }
	        if (!found) {
	            System.out.println("No records found for the employee name: " + name);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
}
