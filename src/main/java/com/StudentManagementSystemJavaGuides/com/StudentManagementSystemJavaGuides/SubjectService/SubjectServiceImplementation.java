package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.SubjectService;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Subject;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.SubjectRepository;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImplementation implements SubjectService{

    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id).get();
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject uSubject(Subject subject, long id) {
        // we need to check whether student with given id is exist in DB or not
        Subject existingSubject = subjectRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "Id", id));

        existingSubject.setSubjectName(subject.getSubjectName());
        // save existing employee to DB
        subjectRepository.save(existingSubject);
        return existingSubject;
    }

    @Override
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }

}
