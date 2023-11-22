package com.florenceConsultingProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florenceConsultingProject.apiuser.model.User;
import com.florenceConsultingProject.repository.UserRepository;


/**
 * 
 * @author Vincenzo.DI-MASO
 *
 */
@Service
public class UserService {
	
	@Autowired
	private Logger log;
	
	@Autowired
	private UserRepository repository;
	
	public Optional<Integer> createUser(User user) {
		
		Integer resultId = null;
		
		User insertedUser = repository.persistAndFlush(user);
		
		if (user != null && user.getId() != null) {
			
			log.info("User inserted has this id : {}", insertedUser.getId());
			resultId = user.getId();
			
		}
		
		Optional<Integer> result = Optional.of(resultId);
		return result;
	}
	
	public Optional<List<User>> readUser() {
		
		List<User> users = new ArrayList<>();
		Optional<List<User>> result = Optional.of(users);
		
		users = repository.findAll();
		
		if (users != null && !users.isEmpty()) {
			
			log.info("List of user is : {}", users);
			result = Optional.of(users);
			
		}
		
		return result;
	}

}