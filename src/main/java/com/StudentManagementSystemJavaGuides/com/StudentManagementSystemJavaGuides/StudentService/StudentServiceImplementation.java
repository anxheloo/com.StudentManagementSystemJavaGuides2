package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.StudentService;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.StudentRepository;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student uStudent(Student student, long id) {
        // we need to check whether student with given id is exist in DB or not
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "Id", id));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        // save existing employee to DB
        studentRepository.save(existingStudent);
        return existingStudent;
    }


    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
