package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Controller;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/s1")
public class StudentRestController {

    @Autowired
    StudentService studentService;

    // build create student REST API
    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    // build get all students REST API
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // build get student by id REST API
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId){
        return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    // build update employee REST API
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> uStudent(@PathVariable("id") long id
            ,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.uStudent(student, id), HttpStatus.OK);
    }

    // build delete employee REST API
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){

        // delete student from DB
        studentService.deleteStudentById(id);

        return new ResponseEntity<String>("Student deleted successfully!.", HttpStatus.OK);
    }
}
