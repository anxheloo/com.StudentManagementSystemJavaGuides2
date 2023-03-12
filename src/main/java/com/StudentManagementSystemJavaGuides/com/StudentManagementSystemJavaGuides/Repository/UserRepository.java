package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


//    @Query("Select u from User u where u.email=?1")
//    User findByEmail(String email);
    @Query("Select u from User u where u.email=?1")
    Optional<User> findByEmail(String email);

//    @Query("Select u from User u where u.email=?1")
//    Optional<User> findByEmail(String email);

//    Optional<User> findByEmail(String email);
}
