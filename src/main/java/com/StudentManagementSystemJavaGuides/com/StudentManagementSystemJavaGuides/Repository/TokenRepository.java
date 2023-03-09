package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Role;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Token;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.User;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TokenRepository extends JpaRepository<Token,String> {

    @Query("select r from Token r where r.token=?1")
    public AuthenticationResponse findByName(@Param("token")String token);

//    @Query("select r from Token r where r.token=?1")
//    public Token findByToken(String token);

}
