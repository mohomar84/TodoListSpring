package com.example.demo.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.dao.Todo;


@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@Repository

public interface TodoRepository extends JpaRepository<Todo, Long>{

	List<Todo> findAllTodoByuserId(String userId);

}
