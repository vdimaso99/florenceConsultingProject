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
		var userOptional = this.service.createUser(user);
		
		if (userOptional.isPresent()) {
			return new ResponseEntity<Integer>(userOptional.get(), HttpStatus.OK);
		}
		
		log.info("No data found!");
		return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<List<User>> readUser() {
		
		log.info("Read a list of user contained in database!");
		var users = this.service.readUser();
		
		if (users.isPresent()) {
			return new ResponseEntity<List<User>>(users.get(), HttpStatus.OK);
		}
		
		log.info("No data found!");
		return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<String> updateUser(@NotNull @Valid Integer id) {
		return UserApi.super.updateUser(id);
	}
	
	@Override
	public ResponseEntity<String> deleteUser(@NotNull @Valid Integer id) {
		return UserApi.super.deleteUser(id);
	}
	
	@Override
	public ResponseEntity<List<User>> readUserByNameAndSurname(@Valid String name, @Valid String surname) {
		return UserApi.super.readUserByNameAndSurname(name, surname);
	}
	
	@Override
	public ResponseEntity<List<User>> createUserByFile(MultipartFile file) {
		return UserApi.super.createUserByFile(file);
	}
	
}