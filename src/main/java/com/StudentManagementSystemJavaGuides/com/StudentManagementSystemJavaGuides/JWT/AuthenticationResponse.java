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
    private String JwtToken;
}