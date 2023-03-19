package com.springboot.restApi.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.restApi.post.Post;
import com.springboot.restApi.post.PostRepository;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	//private UserDaoService service;
//	private UserRepository repository;
	
	private UserRepository repository;
	
	@Autowired
	private PostRepository postRepository;
	public UserResource(UserRepository repository) {
		//this.service = service;
		this.repository = repository;
	}
	
	//GET/users
	@GetMapping("/users")
	public List<User> getUsers(){
		//return service.findAll();
        return repository.findAll();
	}

	//GET/users/id
	@GetMapping("/users/{id}")
	public Optional<User> getUsersByid(@PathVariable int id){
		//User user = service.findOne(id);
		Optional<User> user = repository.findById(id);
//		if (user== null)
//			throw new userNotFoundException("id:"+id);
		return user;
	}
	
	
	
	//Implementing hateoas
	//EntityModel
	//WebMvcLinkBuilder
	//GET/users/id
	@GetMapping("/getusers/{id}")
	public EntityModel<User> getUserByid(@PathVariable int id){
		//User user = service.findOne(id);
		Optional<User> user = repository.findById(id);
		if (user.isEmpty())
			throw new userNotFoundException("id:"+id);
		EntityModel<User> entityModel = EntityModel.of(user.get());

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	//POST/users/
		@PostMapping("/saveUsers")
		public User saveUser1(@RequestBody User user){
			//return service.save(user);
			return repository.save(user);
		}
	
		
	//POST/users/   if we want location in header, we want to create 201 request
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		 //User saveUser = service.save(user);
		
		User saveUser = repository.save(user);
		 //users/4 => users/{id}, user.getID
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(saveUser.getId())
				 .toUri();
		 return ResponseEntity.created(location).build();
	}
	
	//DELETE/user/id
		@DeleteMapping("/users/{id}")
		public void deleteUserByid(@PathVariable int id){
			//service.deleteById(id);
			repository.deleteById(id);
		}
		
		//GET/users/{id}/posts
		@GetMapping("/users/{id}/posts")
		public List<Post> getPostByUserId(@PathVariable int id){
			Optional<User> user = repository.findById(id);
			if (user.isEmpty())
				throw new userNotFoundException("id:"+id);
			return user.get().getPosts();
		}
		
		//POST/users/
		@PostMapping("/users/{id}/posts")
		public ResponseEntity<Object> createPostForUser(@PathVariable int id, @RequestBody Post post){
			Optional<User> user = repository.findById(id);
			post.setUser(user.get());
			Post savedPost = postRepository.save(post);
			 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					 .path("/{id}")
					 .buildAndExpand(savedPost.getId())
					 .toUri();
			 return ResponseEntity.created(location).build();
			 
			
		}
		
		
}
