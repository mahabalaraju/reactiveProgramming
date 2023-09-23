package com.mahabala;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class xyz {
	
public static void main(String[] args) {
	List<person> list= PersonRepo.getall();
	//list.stream().filter(e->e.getClass());
}
}
