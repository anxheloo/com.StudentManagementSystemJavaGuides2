package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role(Long id)
    {
        this.id = id;
    }

    public Role(String name)
    {
        this.name=name;
    }

}
