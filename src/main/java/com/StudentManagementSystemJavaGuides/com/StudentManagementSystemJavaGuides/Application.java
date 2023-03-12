package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Role;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Subject;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.User;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.RoleRepository;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.StudentRepository;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.SubjectRepository;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;


@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Autowired
	StudentRepository studentRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

////		Create Students to test the app
//		Student student1=new Student("Anxhelo","Cenollari","anxhelo@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2=new Student("xhoni","nixho","xhoni@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3=new Student("Tony","Stark","tony@gmail.com");
//		studentRepository.save(student3);
//
//	//	Create Subjects to test the app
//		Subject subject1=new Subject("Physics");
//		subjectRepository.save(subject1);
//
//		Subject subject2=new Subject("Programming");
//		subjectRepository.save(subject2);
//
//		Subject subject3=new Subject("Math");
//		subjectRepository.save(subject3);
//
//		//Create Roles to test  the app
//		Role role1 = new Role("User");
//		roleRepository.save(role1);
//		Role role2 = new Role("Admin");
//		roleRepository.save(role2);
//
//		//Create Admin role to test the app
//		User admin = new User("xhoni","xhoni","xhoni@gmail.com", passwordEncoder.encode("xhoni123"), Arrays.asList(role2));
//		userRepository.save(admin);
//		User user = new User("Noel","Ceno","noel@gmail.com", passwordEncoder.encode("noel123"), Arrays.asList(role1));
//		userRepository.save(user);

		//CREATING ROLES USING BUILDER
		Role role1 = Role.builder().name("User").build();
		roleRepository.save(role1);
		Role role2 = Role.builder().name("Admin").build();
		roleRepository.save(role2);

		//CREATING USERS USING BUILDER
		User admin = User.builder().firstName("xhoni")
				.lastName("xhoni")
				.email("xhoni@gmail.com")
				.password(passwordEncoder.encode("xhoni123"))
				.roles(Arrays.asList(role2)).build();
		userRepository.save(admin);

		User user = User.builder().firstName("noel")
				.lastName("noel")
				.email("noel@gmail.com")
				.password(passwordEncoder.encode("noel123"))
				.roles(Arrays.asList(role1)).build();
		userRepository.save(user);

		
	}
}
