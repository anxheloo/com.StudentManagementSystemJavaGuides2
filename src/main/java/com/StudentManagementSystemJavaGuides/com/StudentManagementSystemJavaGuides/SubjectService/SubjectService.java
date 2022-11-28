package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.SubjectService;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAllSubjects();

    Subject saveSubject(Subject subject);

    Subject getSubjectById(Long id);

    Subject updateSubject(Subject subject);

    Subject uSubject(Subject employee, long id);

    public void deleteSubjectById(Long id);

}
