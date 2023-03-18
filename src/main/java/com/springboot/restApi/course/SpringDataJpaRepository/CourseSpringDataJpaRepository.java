package com.springboot.restApi.course.SpringDataJpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restApi.course.Course;



public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {


	List<Course> findByAuthor(String author);

}
