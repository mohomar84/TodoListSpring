package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Todo;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.jpa.TodoRepository;

@RestController
@RequestMapping("/todoService")
public class TodoController {
	
	@Autowired
	TodoRepository todoRepository;
	
	@GetMapping(path="/todo")
	public @ResponseBody List<Todo> getAllUsers() {
	    return todoRepository.findAll();
	}
	
	@GetMapping("/usersTodo/{userId}")
	public List<Todo> getTodoByUserId(@PathVariable(value = "userId") String userId) throws ResourceNotFoundException {
	    return todoRepository.findAllTodoByuserId(userId);
	            
	}
	
	@PostMapping("/todo")
	public Todo createTodo(@Valid @RequestBody Todo todo) {
	    return todoRepository.save(todo);
	}
	
	
	
	@PutMapping("/todo/{id}")
	public Todo updateNote(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody Todo todoDetails) {

		Todo note = todoRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException( id));

	    note.setTodo(todoDetails.getTodo());
	    note.setStatus(todoDetails.getStatus());

	    Todo updatedNote = todoRepository.save(note);
	    return updatedNote;
	}
	
	// Delete a Note
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable(value = "id") Long id) {
		Todo todo = todoRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException( id));

	    todoRepository.delete(todo);

	    return ResponseEntity.ok().build();
	}

}
