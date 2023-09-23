package com.mahabala;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import ch.qos.logback.core.net.SyslogOutputStream;

public class PredicatefunctionalInterface {
public static void main(String[] args) {
	
	 Predicate<Integer> predicate= (t)->{
		 if(t%2==0) 
			 return true;
		 else {
			return false;
		}
	 };
	 System.out.println(predicate.test(10));
	 

		List<Integer> list= Arrays.asList(1,2,3,5,6,7);
		Predicate<Integer> predicate2= (t)->t>5;
		list.stream().filter(predicate2).forEach(System.out::println);
	 
}}







