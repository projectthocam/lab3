package com.fptaptech.lab3.controller;

import com.fptaptech.lab3.model.FileStore;
import com.fptaptech.lab3.model.SiteClass;
import com.fptaptech.lab3.model.Student;
import com.fptaptech.lab3.model.StudentSearch;
import com.fptaptech.lab3.service.impl.SiteClassService;
import com.fptaptech.lab3.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private SiteClassService siteClassService;
    @Autowired
    StudentService studentService;
    @GetMapping("add-student")
    public String addStudent(Model model)
    {
        model.addAttribute("student",new Student());
        model.addAttribute("listsiteClass" , siteClassService.list());
        return "/student/add-student";
    }
    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student , BindingResult result , ModelMap modelMap)
    {
            studentService.add(student);
            return "redirect:/student/student-list";
    }
    @GetMapping("/student-list")
    public String list(Model model)
    {
        model.addAttribute("studentSearch",new StudentSearch());
        model.addAttribute("list",studentService.list());
        return "/student/student-list";
    }
    @PostMapping("/search-student")
    public String search(@ModelAttribute("studentSearch")StudentSearch studentSearch , BindingResult result , ModelMap modelMap)
    {
        modelMap.addAttribute("list" ,studentService.search(studentSearch));
        modelMap.addAttribute("studentSearch",studentSearch);
        return "/student/student-list";
    }
    @GetMapping("/detail-student/{id}")
    public String detailStudent(@PathVariable int id, Model model){
        Student student = studentService.detail(id);
        model.addAttribute("student",student);
        return "student/detail-student";
    }
}
