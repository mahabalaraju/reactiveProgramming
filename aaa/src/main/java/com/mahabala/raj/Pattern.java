package com.mahabala.raj;

public class Pattern {
public static void main(String[] args) {
	for(int i=0;i<5;i++) {
		for(int j=0;j<=i;j++) {
			if(i==4&&j==2)
			System.out.print("A");
			else {
				System.out.print("*");
			}
		}
		System.out.println("");
	}
}	
}
	
