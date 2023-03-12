package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Token.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements UserDetails  {

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
    @ManyToMany()
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles= new ArrayList<>();


    @OneToMany(mappedBy = "user")
    private List<Token>tokens;




//    public User(String firstName, String lastName, String email, String password, List<Role> roles) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.roles = roles;
//    }



    public void addRoles(Role role)
    {
        roles.add(role);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        User user = new User();
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Role role : roles)
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }

    //This is a method of userdetails class, but lombok also have this method. I changed the property name from 'password' to 'pass',
    //than implement the method getPassword() from userDetails, than set the property back again to password
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
