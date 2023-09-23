package com.mahabala;

import java.util.function.Function;

import javax.print.attribute.IntegerSyntax;

public class FunctionDemo {
	public static Function<Integer, Integer> syz(int... sms) {
		Function<Integer, Integer> aFunction= t->t*t;
		return aFunction;
	}
public static void main(String[] args) {
	int a[]= {1,1,1,11,1,1,11,1,1,1};
	Function<String, Integer> function=(t)->t.length();
	System.out.println(function.apply("raj"));
	Function<Integer, String> function2= (Number)->{
	if(Number%2==0) {
		return "Even Number";
	}else {
			return "Odd number";
		}
};
System.out.println(function2.apply(3));

Function<String,Integer> function3= (t)->t.length();
Function<Integer, Integer> function5= (t)->t+2;
Integer integer= function3.andThen(function5).apply("raj");
System.out.println(integer);
	
System.out.println(FunctionDemo.syz(a));

Function<Integer, Integer> function6= t->t*t;
Function<Integer,Integer> function51=t->t/3;
System.out.println(function6.andThen(function51).apply(31));

}}








