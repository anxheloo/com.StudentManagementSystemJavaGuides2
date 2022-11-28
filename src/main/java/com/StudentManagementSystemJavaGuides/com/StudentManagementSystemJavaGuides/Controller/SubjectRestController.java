package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Controller;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Subject;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.SubjectService.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/s2")
public class SubjectRestController {

    @Autowired
    SubjectService subjectService;


    // build create subject REST API
    @PostMapping("/subjects")
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject){
        return new ResponseEntity<Subject>(subjectService.saveSubject(subject), HttpStatus.CREATED);
    }

    // build get all Subjects REST API
    @GetMapping("/subjects")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    // build get Subject by id REST API
    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") long subjectId){
        return new ResponseEntity<Subject>(subjectService.getSubjectById(subjectId), HttpStatus.OK);
    }

    // build update Subject REST API
    @PutMapping("/subjects/{id}")
    public ResponseEntity<Subject> uSubject(@PathVariable("id") long id
            ,@RequestBody Subject subject){
        return new ResponseEntity<Subject>(subjectService.uSubject(subject, id), HttpStatus.OK);
    }

    // build delete employee REST API
    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable("id") long id){

        // delete employee from DB
        subjectService.deleteSubjectById(id);

        return new ResponseEntity<String>("Subject deleted successfully!.", HttpStatus.OK);
    }
}
