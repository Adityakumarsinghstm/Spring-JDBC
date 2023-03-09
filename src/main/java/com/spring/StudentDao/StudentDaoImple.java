package com.spring.StudentDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.entities.Student;
@Component("studentDao")
public class StudentDaoImple implements StudentDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
     @Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query = "insert into student(id,name,city) values(?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public int change(Student student) {
		String query = "update student set name=?, city=? where id=?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	public int delete(Student student) {
		String query = "delete from student where id=?";
		int r = this.jdbcTemplate.update(query, student.getId());
		return r;
	}

	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		
		String query = "select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImple();
		    
		    Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);

			return student;

	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImple());
		return students;
	}

}
