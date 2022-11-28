package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {


    @GetMapping("/helloAdmin")
    public String helloAdmin()
    {
        return "Hello Admin";
    }

    @GetMapping("/helloUser")
    public String helloUser()
    {
        return "Hello User";
    }


}
