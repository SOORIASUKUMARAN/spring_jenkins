package com.example.testdriven.testdrivendemo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.testdriven.testdrivendemo.Entity.ToDo;
import com.example.testdriven.testdrivendemo.service.ToDoService;
import com.fasterxml.jackson.databind.ObjectMapper;

import springfox.documentation.spring.web.plugins.DocumentationPluginsBootstrapper;

@WebMvcTest

public class ToDoControllerTest {

	
	 @Autowired
	  MockMvc mockMvc;

	 @MockBean
	 ToDoService toDoService;
	 
	 //@MockBean
	 //DocumentationPluginsBootstrapper documentationPluginsBootstrapper;
	 
	 @Autowired
	 ObjectMapper objectMapper;
	 
	 
	 @Test
	    void getAllToDos() throws Exception {
	        List<ToDo> toDoList = new ArrayList<ToDo>();
		      ToDo todoSample = new ToDo();
		      todoSample.setId(1L);
		      todoSample.setText("Test");
		      todoSample.setCompleted(true);
		      ToDo todoSample1 = new ToDo();
		      todoSample1.setId(2L);
		      todoSample1.setText("Test");
		      todoSample1.setCompleted(false);
	        
		      toDoList.add(todoSample);
		      toDoList.add(todoSample1);

	        given(toDoService.findAll()).willReturn(toDoList);
	        
	        ResultActions res =   mockMvc.perform(get("/api/v1/todos/getAll")
	                .contentType(MediaType.APPLICATION_JSON)
	        ) ;
	        		
	        		res .andExpect(jsonPath("$.size()",
	                        is(toDoList.size())));
	    }
	 
	 @Test
	    void postToDos() throws Exception {
	    
		      ToDo todoSample = new ToDo();
		      todoSample.setId(1L);
		      todoSample.setText("Test");
		      todoSample.setCompleted(true);
		
		       

	        given(toDoService.saveTodo(Mockito.any())).willReturn("SAVED_SUCCESSFULLY");
	        
		      ResultActions res =    mockMvc.perform(post("/api/v1/todos")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(objectMapper.writeValueAsString(todoSample)));
		      
		      res.andExpect(status().isOk());
	        

	              
	    }
}
