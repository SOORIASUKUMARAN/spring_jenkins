package com.example.testdriven.testdrivendemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//public class TestdrivendemoApplication implements CommandLineRunner{
	public class TestdrivendemoApplication{
	
//	@Autowired
//	ToDoRepository toDoRepository;
//	
//	  @Override
//	    public void run(String... args) throws Exception {
//		  
//		  toDoRepository.save(new ToDo(2L,"sdsd",false) );
//		  
//		  toDoRepository.save(new ToDo(1L,"sdsd",true) );
//	  }
//	  
	  
	  
	public static void main(String[] args) {
		SpringApplication.run(TestdrivendemoApplication.class, args);
	}

}
