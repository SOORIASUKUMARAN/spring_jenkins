package com.example.testdriven.testdrivendemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testdriven.testdrivendemo.Entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}