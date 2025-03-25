package am.capstone.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/courses")
@Controller
public class CourseController {

    @RequestMapping({"/", "/index", "/index.html"})
    public String studentsIndex() {
        return "students/index";
    }
}
