package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.UserService;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Role;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.User;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.RoleRepository;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void saveUserWithDefaultRole(User user)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepository.findByName("User");
        user.addRoles(roleUser);

        userRepository.save(user);
    }


    public void saveUser(User user)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);

    }


    public User get(Long id)
    {
        return userRepository.findById(id).get();
    }


    public List<Role> getRoles()
    {
        return roleRepository.findAll();
    }


    public User saveUserWithDRole(User user )
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Role roleUser = roleRepository.findByName("User");
        user.addRoles(roleUser);

       return userRepository.save(user);
    }

}
