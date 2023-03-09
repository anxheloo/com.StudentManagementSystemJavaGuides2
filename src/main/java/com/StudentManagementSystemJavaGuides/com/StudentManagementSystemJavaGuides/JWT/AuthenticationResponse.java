//package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class AuthenticationResponse {
//
//    private String JwtToken;
//
//}

//------------------------------------------------------------------------------------------


package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String JwtToken;


    //This were not before, test and delete
//    public AuthenticationResponse(Long id)
//    {
//        this.id = id;
//    }
//    public AuthenticationResponse(String JwtToken)
//    {
//        this.JwtToken=JwtToken;
//    }

}