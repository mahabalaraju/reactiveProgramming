package com.mahabala.raj;

import java.util.Iterator;


//input=1,3,4
//we want to first multiply and then divide by individual elements
//output=12,4,3


public class abc {
	public static void main(String[] args) {
		int input[] = {1,3,4};
		product(input);
		}

	private static void product(int[] input) {
		int product= 1;          //here mistake product=0;
		for(int value:input) {
			product*=value;
		}
		System.out.println(product);
		int div=product;
		for(int value:input) {
		div/=value;
		System.out.println(div);
		}
	}
	}
 

