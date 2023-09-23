package com.mahabala.Utils;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;

import com.mahabala.Entity.products;
import com.mahabala.dto.productDto;

public class AppUtils {

	public static productDto entitytoDto(products products) {
			productDto dto= new productDto(); 
			BeanUtils.copyProperties(products, dto);	
			return dto;
	}
	
	public static products dtotoProducts(productDto dto) {
		products products= new products(); 
		BeanUtils.copyProperties(dto, products);	
		return products;
}	
}






