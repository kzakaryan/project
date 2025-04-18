package am.capstone.project.controller;

import am.capstone.project.service.InstructorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/instructors")
@Controller
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String instructorsIndex(Model model) {
        model.addAttribute("instructors", instructorService.findAll());
        return "instructors/index";
    }
}
