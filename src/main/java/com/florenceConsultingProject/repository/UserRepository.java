package com.florenceConsultingProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.florenceConsultingProject.entity.UserEntity;

import io.hypersistence.utils.spring.repository.HibernateRepository;

/**
 * 
 * @author Vincenzo.DI-MASO
 *
 */
public interface UserRepository extends HibernateRepository<UserEntity>, JpaRepository<UserEntity, Integer> {
	
	@Query(value = "SELECT user FROM UserEntity user WHERE user.name = :name AND user.surname = :surname ORDER BY user.id")
	public List<UserEntity> findUserByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
	
	@Query(value = "SELECT user FROM UserEntity user WHERE user.name = :name ORDER BY user.id")
	public List<UserEntity> findUserByName(@Param("name") String name);
	
	@Query(value = "SELECT user FROM UserEntity user WHERE user.surname = :surname ORDER BY user.id")
	public List<UserEntity> findUserBySurname(@Param("surname") String surname);
	
}