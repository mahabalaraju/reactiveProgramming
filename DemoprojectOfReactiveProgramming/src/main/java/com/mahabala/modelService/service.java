package com.mahabala.modelService;

import java.util.List;

import javax.lang.model.element.ModuleElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahabala.Dao.ModelDao;
import com.mahabala.model.model;

import ch.qos.logback.core.net.SyslogOutputStream;
import reactor.core.publisher.Flux;

@Service
public class service {

	@Autowired
	private ModelDao dao;
	
//	public List<model> loadAllModelObjects(){
//		long start=System.currentTimeMillis();
//		List<model> getallList=dao.getall();
//		long end =System.currentTimeMillis();
//		System.out.println("total execution time:"+(end-start));
//		return getallList;
//	}
	
	public Flux<model> loadAllModelObjects(){
		long start=System.currentTimeMillis();
		Flux<model> getallList=dao.getall();
		long end =System.currentTimeMillis();
		System.out.println("total execution time:"+(end-start));
		return getallList;
	}
	
	
}
