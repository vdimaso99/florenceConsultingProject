package com.florenceConsultingProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florenceConsultingProject.apiuser.model.User;
import com.florenceConsultingProject.entity.UserEntity;
import com.florenceConsultingProject.mapper.MapperEntity;
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
	
	@Autowired
	private MapperEntity mapper;
	
	public Optional<Integer> createUser(User user) {
		
		Integer resultId = null;
		UserEntity userToInsert = mapper.getEntityFromUser(user);
		UserEntity insertedUser = repository.persistAndFlush(userToInsert);
		
		if (insertedUser != null && insertedUser.getId() != null) {
			
			log.info("User inserted has this id : {}", insertedUser.getId());
			resultId = insertedUser.getId();
			
		}
		
		if (resultId != null) {
			
			return Optional.of(resultId);
			
		} else {
			
			return Optional.empty();
			
		}
		
	}
	
	public Optional<List<User>> readUser() {
		
		List<UserEntity> userEntities = new ArrayList<>();
		List<User> users = new ArrayList<>();
		
		userEntities = repository.findAll();
		
		if (userEntities != null && !userEntities.isEmpty()) {
			
			for (UserEntity userEntity : userEntities) {
				
				User user = mapper.getUserFromEntity(userEntity);
				users.add(user);
				
			}
			
			log.info("List of user is : {}", users);	
		}
		
		if (users != null && !users.isEmpty()) {
			return Optional.empty();
		}	
		
		return Optional.of(users);
	}
	
	public Optional<Integer> updateUser(User user) {
		
		log.info("Update user with these informations: {}", user);
		Integer resultId = null;
		UserEntity userToUpdate = mapper.getEntityFromUser(user);
		UserEntity updatedUser = repository.update(userToUpdate);
		
		if (updatedUser != null && updatedUser.getId() != null) {
			
			log.info("User updated has this id : {}", updatedUser.getId());
			resultId = updatedUser.getId();
			
		}
		
		if (resultId != null) {
			
			return Optional.of(resultId);
			
		} else {
			
			return Optional.empty();
			
		}
		
	}
	
	public Optional<Integer> deleteUser(Integer id) {
		repository.deleteById(id);
		return Optional.of(id);
	}
	
	public Optional<List<User>> readUserByNameAndSurname(String name, String surname) {
		
		List<User> users = new ArrayList<>();
		List<UserEntity> userEntities = new ArrayList<>();
		
		if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(surname)) {
			
			log.info("Find user by name: {} and surname: {}", name, surname);
			userEntities = repository.findUserByNameAndSurname(name, surname);
			
		} else if (StringUtils.isNotBlank(name)) {
			
			log.info("Find user by name: {}", name);
			userEntities = repository.findUserByName(name);
			
		} else if (StringUtils.isNotBlank(surname)) {
			
			log.info("Find user by surname: {}", surname);
			userEntities = repository.findUserBySurname(surname);
			
		} else {
			
			log.info("Name and surname no valued!Read all users!");
			userEntities = repository.findAll();
			
		}
		
		for (UserEntity entity : userEntities) {
			
			User user = mapper.getUserFromEntity(entity);
			users.add(user);
			
		}
		
		if (users != null && !users.isEmpty()) {
			return Optional.empty();
		}	
		
		return Optional.of(users);	
	}

}