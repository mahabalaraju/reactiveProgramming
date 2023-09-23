package com.mahabala.cal;

import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import javax.print.attribute.IntegerSyntax;

public interface customCal {

	default int addeven(int... nums) {
		return add(n -> n % 2 == 0, nums);
	}

	default int addodd(int... nums) {
		return add(n -> n % 2 != 0, nums);
	}

	private int add(IntPredicate predicate, int... nums) {
		return IntStream.of(nums).filter(predicate).sum();
	}
//	private Function<Integer, Integer> product(int... nums) {
//		Function<Integer, Integer>aFunction=t->t*t;
//		//Function<Integer, Integer>xFunction=t->t/t;
//		return xFunction ;
//	}
}
