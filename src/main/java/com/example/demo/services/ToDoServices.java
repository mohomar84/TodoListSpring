package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Todo;
import com.example.demo.jpa.TodoRepository;


@Service
public class ToDoServices {
	@Autowired
	TodoRepository todoDoa;
	
	public List<Todo> checkUserAuthontecation(String userId) {
		List<Todo>  todo= todoDoa.findAllTodoByuserId(userId);
		
		return  todo;
	}
}
