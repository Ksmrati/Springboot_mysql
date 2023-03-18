package com.springboot.restApi.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.restApi.user.User;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer Id;
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	public Post() {
		
	}
	public Post(Integer id, String description) {
		super();
		Id = id;
		this.description = description;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [Id=" + Id + ", description=" + description + "]";
	}
	
	
	
}
