package am.capstone.project.controller;

import am.capstone.project.model.Course;
import am.capstone.project.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RequestMapping("api/courses")
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

    @GetMapping
    public Set<Course> getCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(Long id) {
        return courseService.findById(id);
    }

    @PostMapping
    public Course saveCourse(@RequestBody Course course) {
        return courseService.save(course);
    }
}
