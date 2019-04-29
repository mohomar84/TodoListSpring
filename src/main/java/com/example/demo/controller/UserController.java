package com.example.demo.controller;

import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.AuthModel;
import com.example.demo.services.UserServices;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/userservice")
public class UserController {
	
	@Autowired
	private UserServices service;
	

	@GetMapping("/login")
	public ResponseEntity<?> loginAuth (@RequestBody  AuthModel model){
		
		String loginStatus = "Faild" ;
		if(service.checkUserAuthontecation(model))
		{
			loginStatus = "sucess" ;
		}
		
		return new ResponseEntity<String>(loginStatus, HttpStatus.OK);
	}
	

}
