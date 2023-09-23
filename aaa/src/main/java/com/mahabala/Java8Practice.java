package com.mahabala;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SuppressWarnings("unused")
public class Java8Practice {
public static void main(String[] args) {
	List<person> getall= PersonRepo.getall();
	List<String> emails= getall.stream()
			.sorted((o1,o2)->o1.getName().compareTo(o2.getName()))
			.map(p->p.getEmail()) .collect(Collectors.toList());
	//System.out.println(emails);
	
	List<List<String>> phonenumbers= getall.stream().map(p->p.getPhoneNumbers()) .collect(Collectors.toList());
	//System.out.println(phonenumbers);
	
	List<String> phone= getall.stream().flatMap(p->p.getPhoneNumbers().stream()).collect(Collectors.toList());
	//System.out.println(phone);
	

		Map<Object, List<person>> persons= getall.stream()
				.collect(Collectors.groupingBy(e->e.getId()));
	System.out.println(persons);
	
}
}
