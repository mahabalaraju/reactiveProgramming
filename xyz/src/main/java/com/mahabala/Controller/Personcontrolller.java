package com.mahabala.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mahabala.repository.PersonRepository;
import com.mahabala.service.PersonService;

@Controller
public class Personcontrolller {
@Autowired
private PersonService service;

@GetMapping("/getall")
public String getalll() {
	return "NewFile";
}
	

}
