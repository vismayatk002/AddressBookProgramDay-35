package com.addressbook_program_day_35;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DataBaseOperation {

	private static Connection getSqlConnection() {
		Connection con = null;
	       try {
	    	   
	    	   String dbHostUrl = "jdbc:mysql://localhost:3306/AddressBookService_ws?useSSL=false";
	    	   String userName = "root";
	    	   String passWord = "vismaya";
	    	   con = DriverManager.getConnection(dbHostUrl, userName, passWord);  	   
	       }catch(SQLException sqlException) {
	    	   System.out.println(sqlException.getMessage());
	       }
		return con;
	}
	
	public void retrieveAllContacts() throws SQLException {
		
		Connection con = getSqlConnection();
		//Retrieve all the data
		if(con != null) {
		   String retrieveQuery = "SELECT * FROM addressBook JOIN person ON addressBook.addressBookId = person.addressBookId";
		   Statement statement = (Statement) con.createStatement();
		   ResultSet resultSet = statement.executeQuery(retrieveQuery);
		   displayResultSet(resultSet);
		}
	}
	
	public void updateDataByName() throws SQLException {
		
		Connection con = getSqlConnection();
		//Update data with salary by person's name
		if(con != null) {
			
			String updateQuery = "UPDATE person SET address = ? WHERE firstName = ?";
			PreparedStatement updateStatement = con.prepareStatement(updateQuery);
			updateStatement.setString(1, "Koyilandy");
			updateStatement.setString(2, "Vyshak");
		   
			int rowUpdated = updateStatement.executeUpdate();
			if(rowUpdated > 0){
			   System.out.println("Contact Updated");
		   }
		}
	}
	
	public void  displayResultSet(ResultSet resultSet) throws SQLException {
		
		System.out.println("\nContact retrieved..");
		while(resultSet.next()) {
			   
		   int addressBookId = resultSet.getInt("addressBookId");
		   String addressBookName = resultSet.getString("addressBookName");
		   int personId = resultSet.getInt("personId");
		   String firstName = resultSet.getString("firstName");
		   String lastName = resultSet.getString("lastName");
		   String address = resultSet.getString("address");
		   String city = resultSet.getString("city");
		   String state = resultSet.getString("state");
		   String phoneNo = resultSet.getString("phoneNo");
		   String email = resultSet.getString("email");
		   int zip = resultSet.getInt("zip");
		   String date = resultSet.getDate("date").toString();
		   
		   String rowData = String.format("\nAddressBook Id : %d \nAddressBook Name : %s \nPerson Id : %d \nFirst Name : %s  \nLast Name : %s \nAddress : %s \nCity : %s \nState : %s \nPhone Number : %s \nE-mail : %s \nZip : %d \nDate : %s", addressBookId, addressBookName, personId, firstName,lastName,address,city,state,phoneNo,email,zip,date);
		   System.out.println(rowData + " \n ");
		}
	}
}
