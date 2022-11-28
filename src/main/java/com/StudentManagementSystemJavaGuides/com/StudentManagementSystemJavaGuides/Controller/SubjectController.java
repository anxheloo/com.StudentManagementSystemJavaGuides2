package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Controller;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Student;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Subject;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.StudentService.StudentService;
import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.SubjectService.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    //handler method to handle the list of subjects and return model and view
    @GetMapping
    public String listOfSubjects(Model model)
    {
        model.addAttribute("subjects",subjectService.getAllSubjects());
        return "subjects";
    }


    @GetMapping("/new")
    public String createSubjectForm(Model model)
    {
        //create student object to hold student form data
        Subject subject = new Subject();
        model.addAttribute("subject",subject);
        return "create_subject";

    }

    @PostMapping
    public String saveSubject(@ModelAttribute("student") Subject subject)
    {
        subjectService.saveSubject(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/edit/{id}")
    public String editSubjectForm(@PathVariable Long id, Model model)
    {
        model.addAttribute("subject",subjectService.getSubjectById(id));
        return "edit_subject";
    }

    @PostMapping("/{id}")
    public String updateSubject(@PathVariable Long id, @ModelAttribute("subject") Subject subject,Model model)
    {
        //get student from database by id
        Subject existingSubject = subjectService.getSubjectById(id);
        existingSubject.setId(id);
        existingSubject.setSubjectName(subject.getSubjectName());

        //save updated student object
        subjectService.updateSubject(existingSubject);

        return "redirect:/subjects";
    }

    //handeler method for delete student
    @GetMapping("/{id}")
    public String deleteSubject(@PathVariable Long id)
    {
        subjectService.deleteSubjectById(id);
        return "redirect:/subjects";
    }
}
