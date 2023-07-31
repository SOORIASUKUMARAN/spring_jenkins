package com.example.testdriven.testdrivendemo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
//@AllArgsConstructor
public class ToDo {

	
	@Id
	@GeneratedValue()
	 private long id;
	    private String text;
	    private boolean completed;

		

	

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public boolean isCompleted() {
			return completed;
		}

		public void setCompleted(boolean completed) {
			this.completed = completed;
		}
		
		public ToDo(long id, String text, boolean completed) {
			super();
			this.id = id;
			this.text = text;
			this.completed = completed;
		}
}
