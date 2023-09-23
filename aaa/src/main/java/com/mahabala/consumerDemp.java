package com.mahabala;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class consumerDemp {
public static void main(String[] args) {
	/*consumer functional interface can be used in all context where an object need to be 
consumed i.e ., taken as input and some operation is to be performed on the object without 
	returning any result*/
	
	Consumer<String>consumer1 = (t)->System.out.println("H");
	Consumer<String>consumer2 = (t)->System.out.println("mahabala"+t);
	
	Consumer<Integer>con = (t)->System.out.println(t);
	con.accept(10);
//	consumer.accept("raj");

	consumer1.andThen(consumer2).accept("raj");
	
	
	List<Integer> list= Arrays.asList(1,2,3,5,6,7);
	Consumer<Integer> consumer3= (t)->System.out.println(t);
	list.forEach(consumer3);
	
	Consumer<Integer> square= i->System.out.println(i*i);
	Consumer<Integer> dobuleConsumer= i->System.out.println(1*2);
		square.andThen(dobuleConsumer).accept(3);
}
}
