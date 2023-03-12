package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Controller;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationRequest;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationResponse;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.JwtUtil;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

//    @Autowired
//    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JwtUtil jwtUtil;


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


//    @PostMapping("/authenticate")
//    public String logTheUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            authenticationRequest.getUsername(), authenticationRequest.getPassword()));
//
//        } catch (BadCredentialsException e)
//        {
//            throw new Exception("Incorrect UserName or Password!",e);
//        }
//
//        UserDetails userDetails =
//                customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        String jwt = jwtUtil.generateToken(userDetails);
//
//        return jwt;
//    }



}
