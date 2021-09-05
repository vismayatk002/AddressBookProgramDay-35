package com.addressbook_program_day_35;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class AddressBookMain {
	
    public static void main( String[] args ) {
    	
    	AddressBookOperation operate = new AddressBookOperation();
    	
    	Scanner sc= new Scanner(System.in);
    	operate.addContact();
    	System.out.print("\nDo you want to edit? press Y / N : ");
        char editOption = sc.next().charAt(0);
        if(editOption == 'Y'){
            operate.editContact();
            operate.showAddrBook();
        }
       
        System.out.print("\nDo you want to delete? press Y / N : ");
        char deleteOption = sc.next().charAt(0);
        if(deleteOption == 'Y'){
            operate.deleteContact();
            operate.showAddrBook();
        }
        System.out.print("\nDo you want to search? press Y / N : ");
        char searchOption = sc.next().charAt(0);
        if(searchOption == 'Y'){
        	operate.searchPerson();
        }
        System.out.print("\nDo you want to Sort AddressBook? press Y / N : ");
        char sortOption = sc.next().charAt(0);
        if(sortOption == 'Y') {
        	operate.sortByName();
        }
        
    	FileOperation file = new FileOperation(operate.getAddrBookMap());
    	
    	System.out.print("\nDo you want to write into file? press Y / N : ");
        char fileWriteOption = sc.next().charAt(0);
        if(fileWriteOption == 'Y'){
        	file.writeContactToFile();
        }
    	System.out.print("\nDo you want to write into CSV? press Y / N : ");
        char csvWriteOption = sc.next().charAt(0);
        if(csvWriteOption == 'Y'){
        	try {
				file.writeContactToCsv();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        System.out.print("\nDo you want to write into JSON? press Y / N : ");
        char jsonWriteOption = sc.next().charAt(0);
        if(jsonWriteOption == 'Y') {
			file.writeContactToJson();
        }
        
        DataBaseOperation db = new DataBaseOperation();
        
        System.out.print("\nDo you want to Retrieve all contacts? press Y / N : ");
        char retrieveOption = sc.next().charAt(0);
        if(retrieveOption == 'Y') {
	        try {
				db.retrieveAllContacts();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        System.out.print("\nDo you want to Update your contact? press Y / N : ");
        char updateOption = sc.next().charAt(0);
        if(updateOption == 'Y') {
	        try {
				db.updateDataByName();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    }
}
