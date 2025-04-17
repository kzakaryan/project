package am.capstone.project.controller;

import am.capstone.project.model.Faculty;
import am.capstone.project.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Set;

@RequestMapping("api/faculties")
@Controller
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String facultiesIndex(Model model) {
        model.addAttribute("faculties", facultyService.findAll());
        return "faculties/index";
    }

    @GetMapping
    public Set<Faculty> getFaculties() {
        return facultyService.findAll();
    }

    @GetMapping("/{id}")
    public Faculty getFacultyById(Long id) {
        return facultyService.findById(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.save(faculty);
    }
}
