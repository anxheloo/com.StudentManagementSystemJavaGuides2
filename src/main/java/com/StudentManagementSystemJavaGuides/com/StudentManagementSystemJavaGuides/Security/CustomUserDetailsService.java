//package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Security;
//
//import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Role;
//import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.User;
//import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    UserRepository userRepository;
//
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////
////        User user = userRepository.findByEmail(email);
////        if(user == null)
////        {
////            throw new UsernameNotFoundException("User Not Found!");
////        }
////
////        return new CustomUserDetails(user);
////    }
//
//
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user= userRepository.findByEmail(email);
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found!"+ email));
//        return user.map(CustomUserDetails::new).get();
//
////        return new CustomUserDetails(user);
//
//
//    }
//
//
//}
