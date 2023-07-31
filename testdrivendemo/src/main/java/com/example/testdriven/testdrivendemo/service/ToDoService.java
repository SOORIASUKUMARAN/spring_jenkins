package com.example.testdriven.testdrivendemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testdriven.testdrivendemo.Entity.ToDo;
import com.example.testdriven.testdrivendemo.repo.ToDoRepository;

@Service
public class ToDoService {

	
	@Autowired
	ToDoRepository toDoRepository;
	
//	public List<ToDo> findAll() {
//		
//		
//	    return new ArrayList<>();
//	}
	
public List<ToDo> findAll() {
		
		
	return toDoRepository.findAll();
	}



public String saveTodo(ToDo todo) {
	
	toDoRepository.save(todo);
	 
	return "SAVED_SUCCESSFULLY";
}


}
