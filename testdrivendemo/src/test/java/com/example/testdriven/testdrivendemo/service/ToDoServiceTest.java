package com.example.testdriven.testdrivendemo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testdriven.testdrivendemo.Entity.ToDo;
import com.example.testdriven.testdrivendemo.repo.ToDoRepository;

@SpringBootTest
public class ToDoServiceTest {
	
	
	  @InjectMocks
	    private ToDoService toDoService;
	  
		// @MockBean
		 //DocumentationPluginsBootstrapper documentationPluginsBootstrapper;
	  
	  
	  @Mock
	    private ToDoRepository toDoRepository;
	  
	
	  
	  @Test
	  void saveToDos(){
	      ToDo todoSample = new ToDo();
	      todoSample.setId(1L);
	      todoSample.setText("Test");
	      todoSample.setCompleted(true);
	     
	      
	     
	      given(toDoRepository.save(Mockito.any())).willReturn(todoSample);
	      String result  = toDoService.saveTodo(todoSample);
	  

	     
	        assertEquals("SAVED_SUCCESSFULLY",result);
	        
	  }
	  
	  
	  @Test
	  void getAllToDos(){
	      ToDo todoSample = new ToDo();
	      todoSample.setId(1L);
	      todoSample.setText("Test");
	      todoSample.setCompleted(true);
	      ToDo todoSample1 = new ToDo();
	      todoSample1.setId(2L);
	      todoSample1.setText("Test");
	      todoSample1.setCompleted(false);
	      
	     
	      given(toDoRepository.findAll()).willReturn(List.of(todoSample,todoSample1));
	      List<ToDo> toDoList = toDoService.findAll();
	  

	     
	        assertThat(toDoList).isNotNull();
	        assertThat(toDoList.size()).isEqualTo(2);
	  }

}
