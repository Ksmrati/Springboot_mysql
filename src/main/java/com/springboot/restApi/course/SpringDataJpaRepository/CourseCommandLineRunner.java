package com.springboot.restApi.course.SpringDataJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.restApi.course.Course;


//import com.springboot.restApi.course.jdbc.Course;
//import com.springboot.restApi.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{


//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
//	@Override
//	public void run(String... args) throws Exception {
//		repository.insert(new Course(1,"AWS", "in28"));
//		repository.insert(new Course(2,"Spring", "in28"));
//		repository.insert(new Course(3,"Java", "in28"));
//		repository.insert(new Course(4,"RestApi", "in28"));
//		
//		repository.deleteById(1);
//		
//		System.out.println(repository.findById(3));
//		
//	}
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Course(1, "Sping", "in28"));
		repository.save(new Course(2,"Spring", "in28"));
		repository.save(new Course(3,"Java", "in281"));
		repository.save(new Course(4,"RestApi", "in28"));
		
//		repository.deleteById(2);
//		//repository.deleteById(1);
//		
//		System.out.println(repository.findById(3));
		
		repository.deleteById(2l);
		System.out.println(repository.findById(3l));
		System.out.println(repository.findByAuthor("in281"));
		
		
	}

}
