package com.mahabala;

import java.util.stream.IntStream;

public class parallelStream {
	public static void main(String[] args) {
		long start = 0;
		long end= 0;
		//plain stream
		start = System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::print);
		end= System.currentTimeMillis();
		System.out.println("\n plain stream took time:"+(end-start));
		
		System.out.println("-----------------");
		
		//parallel stream
		start = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::print);
		end= System.currentTimeMillis();
		System.out.println("\n parallel stream took time:"+(end-start));

}
}
