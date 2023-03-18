package com.springboot.restApi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	//UserDaoService->static List
	private static List<User> users = new ArrayList<>();
	
	private static int UserCount=0;
	static {
		users.add(new User(++UserCount, "smrati", LocalDate.now().minusYears(30)));
		users.add(new User(++UserCount, "Pradeep", LocalDate.now().minusYears(34)));
		users.add(new User(++UserCount, "Ishu", LocalDate.now().minusYears(28)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user){
		user.setId(++UserCount);
		users.add(user);
		return user;
	
	}
	
	public User findOne(int id){
		Predicate<? super User> predicate = users->users.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	public void deleteById(int id){
		Predicate<? super User> predicate = users->users.getId().equals(id);
		users.removeIf(predicate);
		
	}
}
