package com.spirng.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.StudentDao.StudentDao;
import com.spring.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Programme started.....");
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		JdbcTemplate template = context.getBean("JdbcTemplate", JdbcTemplate.class);
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Student stu1 = new Student();
        stu1.setId(21);
        stu1.setName("prawesh");
        stu1.setCity("Sabji bag");
        
       int result =  studentDao.insert(stu1);
        System.out.println("Student added :"+ result);

		/*
		 * Student student = new Student(); student.setId(14);
		 * student.setName("Ramesh"); student.setCity("sitamarhi"); int result =
		 * studentDao.change(student); System.out.println("row changed "+ result);
		 */

		/*
		 * Student stu2 = new Student(); stu2.setId(12); int result
		 * =studentDao.delete(stu2);
		 * 
		 * System.out.println("deleted row "+result);
		 */

		/*
		 * Student student = studentDao.getStudent(13); System.out.println(student);
		 */
		List<Student> students = studentDao.getAllStudent();
		for (Student stu : students) {
			System.out.println(stu);
		}

	}
}
