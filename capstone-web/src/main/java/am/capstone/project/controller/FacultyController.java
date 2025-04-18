package am.capstone.project.controller;

import am.capstone.project.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/faculties")
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
}
