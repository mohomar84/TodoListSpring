package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Users;
import com.example.demo.jpa.UserDaoRepository;
import com.example.demo.model.AuthModel;

@Service
public class UserServices {
	
	
	@Autowired
	UserDaoRepository userDoa;
	public Boolean checkUserAuthontecation(AuthModel model) {
		Users  user=userDoa.findByUsernameAndPassword( model.getUsername() , model.getPassword());
		if(user==null) {
			return false;
		}
		return  true;
	}

}
