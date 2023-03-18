package com.springboot.restApi.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate SpringJdbcTemplate;
	
//	private static String INSERT_QUERY =
//			"""
//			insert into course (id, name, author)
//			values(1, 'aws', 'in28minutes');
//		    """;
	
//	@SuppressWarnings("preview")
//	private static String INSERT_QUERY =
//			"""
//			insert into course (id, name, author)
//			values(?, ?, ?);
//	""";
//
//	@SuppressWarnings("preview")
//	private static String DELETE_QUERY=
//			"""
//			delete from course where id= ?;
//	""";
//
//	@SuppressWarnings("preview")
//	private static String SELECT_QUERY=
//			"""
//			select * from course where id= ?;
//	""";
//
//			 
//	 public void insert(Course course) {
//		 SpringJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
//	 }
//	 
//	
//
//	 public void deleteById(long id){
//		 SpringJdbcTemplate.update(DELETE_QUERY, id);
//	 }
//		
//	 public Course findById(long id) {
//		 return SpringJdbcTemplate.queryForObject(SELECT_QUERY,
//				 new BeanPropertyRowMapper<>(Course.class), id);
//	 }
}
