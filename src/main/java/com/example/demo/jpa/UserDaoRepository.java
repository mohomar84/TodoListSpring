package com.example.demo.jpa;

import com.example.demo.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@Repository
public interface UserDaoRepository extends JpaRepository<Users, Long> {

	
	Users findByUsernameAndPassword(String username, String password);
	

}
