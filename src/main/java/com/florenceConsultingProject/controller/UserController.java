package com.florenceConsultingProject.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.florenceConsultingProject.apiuser.apidefinition.UserApi;
import com.florenceConsultingProject.apiuser.model.User;
import com.florenceConsultingProject.service.UserService;


/**
 * 
 * @author Vincenzo.DI-MASO
 *
 */
@RestController
public class UserController implements UserApi {

	@Autowired
	private Logger log;
	
	@Autowired
	private UserService service;
	
	@Override
	public ResponseEntity<Integer> createUser(@NotNull @Valid User user) {
		
		log.info("Create user :  {}", user);
		var response = this.service.createUser(user);
		
		if (response.isPresent()) {
			return new ResponseEntity<Integer>(response.get(), HttpStatus.OK);
		}
		
		log.info("No data found!");
		return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<List<User>> readUser() {
		
		log.info("Read a list of user contained in database!");
		var response = this.service.readUser();
		
		if (response.isPresent()) {
			return new ResponseEntity<List<User>>(response.get(), HttpStatus.OK);
		}
		
		log.info("No data found!");
		return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Integer> updateUser(@Valid User user) {
		
		log.info("Update user with id : {}", user.getId());
		var response = this.service.updateUser(user);
		
		if (response.isPresent()) {
			return new ResponseEntity<Integer>(response.get(), HttpStatus.OK);
		}
		
		log.info("No data found!");
		return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Integer> deleteUser(@NotNull @Valid Integer id) {
		
		log.info("Delete user with id : {}", id);
		var response = this.service.deleteUser(id);
		
		if (response.isPresent()) {
			return new ResponseEntity<Integer>(response.get(), HttpStatus.OK);
		}
		
		log.info("No data found!");
		return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);	
	}
	
	@Override
	public ResponseEntity<List<User>> readUserByNameAndSurname(@Valid String name, @Valid String surname) {
		
		log.info("Read user by name : {} or surname : {} or both!", name, surname);
		var response = this.service.readUserByNameAndSurname(name, surname);
		
		if (response.isPresent()) {
			return new ResponseEntity<List<User>>(response.get(), HttpStatus.OK);
		}
		
		log.info("No data found!");
		return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<List<User>> createUserByFile(MultipartFile file) {
		return UserApi.super.createUserByFile(file);
	}
	
}