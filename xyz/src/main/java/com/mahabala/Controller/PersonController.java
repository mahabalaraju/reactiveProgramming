package com.mahabala.Controller;

import java.security.Provider.Service;
import java.util.List;

import javax.sound.midi.VoiceStatus;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahabala.model.Person;
import com.mahabala.model.PhoneNumList;
import com.mahabala.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService service;

	@GetMapping("/getall")
	public ResponseEntity<List<Person>> getall(){
		return ResponseEntity.ok().body(service.listAllContacts());
	}
	
	@PostMapping("/save")
	public void save(Person person){
		 service.addcontact(person);
	}
	
	@GetMapping("/phonenumbers/{personname}")
	public ResponseEntity<List<PhoneNumList>> getallnumbers(@PathVariable String personname){
		return ResponseEntity.ok(service.getPhoneNumbers(personname));
	}
}











