package com.mahabala.service;

import java.util.List;

import com.mahabala.model.Person;
import com.mahabala.model.PhoneNumList;

public interface PersonService {
	
//public void addcontact(String personname,String phonenumbers);
public List<PhoneNumList> getPhoneNumbers(String name);
public List<Person> listAllContacts();
public void addcontact(Person person);

}
