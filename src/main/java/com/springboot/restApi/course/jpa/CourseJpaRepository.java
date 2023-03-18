package com.springboot.restApi.course.jpa;

import org.springframework.stereotype.Repository;

import com.springboot.restApi.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course find_course = entityManager.find(Course.class, id);
		entityManager.remove(find_course);
	}
}
