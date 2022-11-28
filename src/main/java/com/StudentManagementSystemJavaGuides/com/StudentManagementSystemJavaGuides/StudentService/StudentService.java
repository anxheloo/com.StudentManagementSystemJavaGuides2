package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.StudentService;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    Student uStudent(Student student, long id);

    public void deleteStudentById(Long id);

}
