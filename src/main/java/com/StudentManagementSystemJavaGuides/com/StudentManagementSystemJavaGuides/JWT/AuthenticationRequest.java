package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationRequest {

    private String username;
    private String password;
}



//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class AuthenticationRequest {
//
//    private String email;
//    String password;
//}