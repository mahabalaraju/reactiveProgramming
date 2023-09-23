package com.mahabala.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class productDto {
	private String id;
	private String name;
	private String discription;
	private int qty;
	private double price;
	//private LocalDateTime time;
}
