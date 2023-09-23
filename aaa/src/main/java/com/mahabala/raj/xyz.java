package com.mahabala.raj;

import javax.management.loading.PrivateClassLoader;

import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;

public interface xyz {

	public abstract void abstractmethod();

	public default void defaultmethod() {
		privateMethod();
		System.out.println("default method");
	}

	public static void staticmethod() {
	privatStaticmethod();
		System.out.println("static method");
	}

	private void privateMethod() {
		System.out.println("private method");
	}

	private static void privatStaticmethod() {
		System.out.println("private static method");
	}
}
