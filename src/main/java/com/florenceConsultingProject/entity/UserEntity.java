package com.florenceConsultingProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Vincenzo.DI-MASO
 *
 */

@Entity
@Table(name="user_entity"
    ,schema="anagraphics"
)
public class UserEntity {
	
	private Integer id;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String address;
	
	public UserEntity() {}
	
	public UserEntity(Integer id) {
		this.id = id;
	}
	
	public UserEntity(Integer id, String name, String surname, String email, String address) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
	}
	
	@Id
	@Column(name = "usr_id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "t_nom")
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "t_cog")
	public String getSurname() {
		return this.surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Column(name = "t_eml")
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "t_ind")
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

}