package com.florenceConsultingProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.florenceConsultingProject.apiuser.model.User;

import io.hypersistence.utils.spring.repository.HibernateRepository;

/**
 * 
 * @author Vincenzo.DI-MASO
 *
 */
public interface UserRepository extends HibernateRepository<User>, JpaRepository<User, Integer> {
	
	
	
}