package com.mahabala.raj;

public class xyzImpl implements xyz{

	@Override
	public void abstractmethod() {
		System.out.println("abstractmethod");
	}

	public static void main(String[] args) {
		xyz a= new xyzImpl();
		a.abstractmethod();
		a.defaultmethod();
		xyz.staticmethod();
	}
}
