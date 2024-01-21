package com.example.demo.repositories;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//2 zadanie
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
