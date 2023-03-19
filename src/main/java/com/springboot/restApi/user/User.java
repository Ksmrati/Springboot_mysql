package com.springboot.restApi.user;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.restApi.post.Post;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class User {

	
	@Id
	@GeneratedValue
    private Integer id;
    
    @Size(min=2, message="Name should have atleast 2 character")
    private String name;
    
    @Past(message="Birth date should be only past")
    private LocalDate birthdate;
    
    @OneToMany(mappedBy= "user")
    @JsonIgnore
    private List<Post> posts;
    
    public User() {
    	
    }
	public User(Integer id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
	
}
