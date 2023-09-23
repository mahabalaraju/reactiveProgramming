package com.mahabala;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo  {

public static void main(String[] args) {
	Supplier<LocalDateTime> supplier= ()-> LocalDateTime.now();
	System.out.println(supplier.get());

	
	Supplier<List<String>> productSupplier=()->{
		List<String> listSupplier= List.of("A","B","C");
		return listSupplier;
	};
	System.out.println(productSupplier.get());
	
}
}
