package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

}
