package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Controller;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.User;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping("/registration")
//    public String registerUserAccount(@RequestBody User user) {
//      userService.saveUserWithDefaultRole(user);
//      return "User created succesfully";
//    }


    @PostMapping("/registration")
    public ResponseEntity<User> saveStudent(@RequestBody User user){
        return new ResponseEntity<User>(userService.saveUserWithDRole(user), HttpStatus.CREATED);
    }

}
