package com.mahabala;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonRepo {

	public static List<person> getall(){
		return Stream.of(
new person(1,"balaraju","balaraj4gmail.com",233211,Arrays.asList("26575675","67564674")),
new person(6,"mahabalaraju","mahabalagmail.com",23232,Arrays.asList("567567676","6786678")),
new person(3,"H mahabalaraju","raj4gmail.com",232323,Arrays.asList("54547676","666678"))
			).collect(Collectors.toList());
		
	}
	public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }
}
