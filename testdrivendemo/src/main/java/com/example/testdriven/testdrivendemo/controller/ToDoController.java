package com.example.testdriven.testdrivendemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.testdriven.testdrivendemo.Entity.ToDo;
import com.example.testdriven.testdrivendemo.service.ToDoService;

@RestController
@RequestMapping("/api/v1")
public class ToDoController {

	
	 @Autowired
	    private ToDoService toDoService;

	    @GetMapping("/todos/getAll")
	    ResponseEntity<List<ToDo>> getAllToDos() {
	        return new ResponseEntity<>(toDoService.findAll(), HttpStatus.OK);
}
	    
	    @PostMapping("/todos")
	    //@ResponseStatus(HttpStatus.CREATED)
	    public String createEmployee(@RequestBody ToDo todo){
	        return toDoService.saveTodo(todo);
	    }
}
