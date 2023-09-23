package com.mahabala.cal;

import java.util.Calendar;
import java.util.function.BiConsumer;

public class customCalculator implements customCal{
	public static void main(String[] args) {
		customCal cal= new customCalculator();
		int x= cal.addeven(7,2,5,8,0,9);
		int y= cal.addodd(9,7,6,8,5);
		
		System.out.println(x+"\n"+y);
		
		
	}
 
}

