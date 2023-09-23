package com.mahabala.raj;

import java.lang.invoke.CallSite;
import java.security.PublicKey;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.aop.aspectj.annotation.ReflectiveAspectJAdvisorFactory;

import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.experimental.var;

public class asdfa {
	public static Optional<Integer> sa(String name) {
		
	Optional<Integer> ls=	personrepo.getall()
.stream().filter(e->e.getName().startsWith(name))
.map(e->e.getCount()).reduce(Integer::sum);	
	
	return ls;
	}
public static void main(String[] args) {
	System.out.println("enter your name :");
   Scanner scanner= new Scanner(System.in);
   String name=scanner.next();
   sa(name);
 
//    people.forEach(person -> {
//        System.out.println("Name: " + person.getName());
//        System.out.println("Age: " + person.getCount());
//        });
        // Access and print other attributes here
	
	// personrepo.getall().stream().forEach(e->System.out.println(e.getName()));

			//list.stream().map(e->e.getName()).forEach(System.out::println);
// List<person> li= list.stream().filter(w->w.getName().matches("raj")).collect(Collectors.toList());
// System.out.println(li);
// for (Iterator iterator = list.iterator(); iterator.hasNext();) {
//	person person = (person) iterator.next();
//	System.out.println(person.getName());
//}
//	person t=list.get(1);
//	System.out.println(t.getName());
// 
//boolean	a=	list.equals("raj");
//	person person =list.forEach(e->e.getName());

// person person= list.forEach(e->e.getName().contentEquals("raj"));

//Iterator<String> iterator = people.stream().flatMap(Collection::stream).map(person::getName).iterator();  while(iterator.hasNext());
	//llist.stream().flatMap(Collection::stream).map(person::getName).forEach(System.out::println);
//if(list2) {
//		list2.stream()
//	    .filter
//	    .filter(e->e.getCount())
//	    .map(Integer::sum);
//	}
	
    
}}
class person
{
	
//	@Override
//	public String toString() {
//		return "person [id=" + id + ", name=" + name + ", count=" + count + "]";
//	}
	private int id;
	private String name;
	private int count;
	public int getId() {
		return id;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(count, id, name);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		person other = (person) obj;
//		return count == other.count && id == other.id && Objects.equals(name, other.name);
//	}
	public void setId(int id) {
		this.id = id;
	}
	public person(int id, String name, int count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}}
class personrepo{
		public static List<person> getall(){

			return Stream.of(
			  new person(1,"Alice", 25),
			    new person(2,"raj", 30),
			   new person(3,"raj", 28)).collect(Collectors.toList());
		}
	}
	
