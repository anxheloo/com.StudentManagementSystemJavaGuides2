package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="subject_name", nullable = false)
    private String subjectName;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

}
