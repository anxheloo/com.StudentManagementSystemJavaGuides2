package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Controller;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.User;
//import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationRequest;
//import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationResponse;
//import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.JwtUtil;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationRequest;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationResponse;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.JwtUtil;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Security.CustomUserDetailsService;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/")
    public String home() {
        return "index";
    }


    @GetMapping("/registration")
    public String showRegistrationForm(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") User user) {
        userService.saveUserWithDefaultRole(user);
        return "redirect:/registration?success";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage()
    {
        return "access-denied";
    }



    @PostMapping ("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        } catch (BadCredentialsException e)
        {
            throw new Exception("Incorrect UserName or Password!",e);
        }

        UserDetails userDetails =
                customUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }









    //--------------------------------------------------------------------------------------------------

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

//----------------------------------------------------------------------------------------------------


}
