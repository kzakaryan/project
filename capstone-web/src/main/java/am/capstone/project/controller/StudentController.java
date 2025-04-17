package am.capstone.project.controller;

import am.capstone.project.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/students")
@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String studentsIndex(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students/index";
    }
}
