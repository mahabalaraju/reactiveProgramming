package com.mahabala.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahabala.model.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
List<Person> findByName(String name);
}
