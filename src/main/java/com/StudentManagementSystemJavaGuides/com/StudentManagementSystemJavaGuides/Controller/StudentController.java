package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Controller;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    //handler method to handle the list of students and return model and view
    @GetMapping
    public String listOfStudents(Model model)
    {
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }


    @GetMapping("/new")
    public String createStudentForm(Model model)
    {
        //create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";

    }

    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model)
    {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model)
    {
        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        //save updated student object
        studentService.updateStudent(existingStudent);

        return "redirect:/students";
    }

    //handeler method for delete student
    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

}
