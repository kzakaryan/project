package am.capstone.project.controller;


import am.capstone.project.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/courses")
@Controller
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String studentsIndex(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "students/index";
    }
}
