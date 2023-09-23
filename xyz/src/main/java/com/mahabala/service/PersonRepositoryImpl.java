package com.mahabala.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mahabala.model.Person;
import com.mahabala.model.PhoneNumList;
import com.mahabala.repository.PersonRepository;

public class PersonRepositoryImpl implements PersonService {

	@Autowired
	private PersonRepository repository;

	@Override
	public List<PhoneNumList> getPhoneNumbers(String name) {
		List<Person> person=repository.findByName(name);
	if (person!=null) {
		List<PhoneNumList>phoneNumbers=	person.stream()
				.flatMap(e->e.getPhoneNumberList().stream())
				.collect(Collectors.toList());
		return phoneNumbers;
	}
	else {
		return null;
	}}

	@Override
	public List<Person> listAllContacts() {
		return repository.findAll();
	}

	@Override
	public void addcontact(Person person) {
		Optional<Person>existingperson= repository.findById(person.getId());
		if(existingperson.isPresent()) {
	      existingperson.get().setPhoneNumberList(person.getPhoneNumberList());
		}
	}


	
}
