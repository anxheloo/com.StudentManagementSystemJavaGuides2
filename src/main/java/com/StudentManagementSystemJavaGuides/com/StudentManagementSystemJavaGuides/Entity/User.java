package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.JWT.AuthenticationResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(nullable = false)  //,unique = true
    private String email;

    @Column(nullable = false)
    private String password;

    //FetchType.EAGER - when we retrieve user, along with user we retrieve the roles
    //CascadeType - when we perform operations on parent entity it will be applied to child entities
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles= new ArrayList<>();


    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "users_tokens",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "token_id"))
    private Token token;




    public User(String firstName, String lastName, String email, String password, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    //For TOKEN
//    public User(String firstName, String lastName, String email, String password, List<Role> roles, String token) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.roles = roles;
//        this.token = token;
//    }


    public void addRoles(Role role)
    {
        roles.add(role);
    }

}
