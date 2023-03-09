package com.spring.StudentDao;

import java.util.List;

import com.spring.entities.Student;

public interface StudentDao {
   public int insert(Student student);
   public int change(Student student);
   public int delete(Student student);
   public Student getStudent (int studentId);
   public List<Student> getAllStudent ();
}
