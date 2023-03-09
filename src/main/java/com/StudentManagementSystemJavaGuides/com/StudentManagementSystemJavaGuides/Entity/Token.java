package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;


    public Token(Long id){
        this.id = id;
    }

    public Token(String token){
        this.token = token;
    }

}
