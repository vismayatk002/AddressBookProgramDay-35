package com.addressbook_program_day_35;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	
	String addrName;
	List<PersonContact> personList = new ArrayList<>();
	
	public AddressBook(String addrName) {
		
		this.addrName = addrName;
	}
	public void setAddrName(String addrName){
        this.addrName = addrName;
    }
    public String getAddrName(){
        return addrName;
    }
    public List<PersonContact> getPersonList(){
        return personList;
    }
    
    public void addContactToList(PersonContact contact) {
    	
    	this.personList.add(contact);
    }
}
