package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String SECRET_KEY="secret";

    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }


    public Date extractExpiration(String token)
    {
        return extractClaim(token,Claims::getExpiration);
    }


    public<T> T extractClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims= extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {

        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }


    public Boolean isTokenExpired(String token)
    {   //here it will check if the token has created before time limit,
        return extractExpiration(token).before(new Date());
    }

    //main method
    public String generateToken(UserDetails userDetails)
    { //based on the username we will generate the token
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }

    //in this method createToken subject argument is username
    //here we are setting the time for 10 hrs to expire the token
    //we are using HS512 algorithm
    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY).compact();

    }


    public Boolean validateToken(String token,UserDetails userDetails)
    {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


}
