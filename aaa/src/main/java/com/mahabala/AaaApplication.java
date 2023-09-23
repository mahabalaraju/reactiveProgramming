package com.mahabala;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AaaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AaaApplication.class, args);
	}

	public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }
}
