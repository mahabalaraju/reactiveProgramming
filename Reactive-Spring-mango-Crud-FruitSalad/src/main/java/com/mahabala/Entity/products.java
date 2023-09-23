package com.mahabala.Entity;

import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class products {

	@Id
	private String id;
	private String name;
	private String discription;
	private int qty;
	private double price;
   // private ZonedDateTime time;
    
    
}
