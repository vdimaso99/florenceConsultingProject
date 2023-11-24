package com.florenceConsultingProject.mapper;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.florenceConsultingProject.apiuser.model.User;
import com.florenceConsultingProject.entity.UserEntity;

/**
 * 
 * @author Vincenzo.DI-MASO
 *
 */
public class MapperEntity {
	
	@Autowired
	private Logger log;

	public User getUserFromEntity(UserEntity entity) {
		
		log.info("Mapping user object from entity : {}", entity);
		User user = new User();
		user.setId(entity.getId());
		user.setName(entity.getName());
		user.setSurname(entity.getSurname());
		user.setEmail(entity.getEmail());
		user.setAddress(entity.getAddress());
		
		log.info("User mapped is : {}", user);
		return user;
	}
	
	public UserEntity getEntityFromUser(User object) {
		
		log.info("Mapping entity from user object : {}", object);
		UserEntity userEntity = new UserEntity();
		userEntity.setId(object.getId());
		userEntity.setName(object.getName());
		userEntity.setSurname(object.getSurname());
		userEntity.setEmail(object.getEmail());
		userEntity.setAddress(object.getAddress());
		
		log.info("User entity mapped is : {}", userEntity);
		return userEntity;
	}
	
}