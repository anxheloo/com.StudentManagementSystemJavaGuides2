package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String JwtToken;

}
