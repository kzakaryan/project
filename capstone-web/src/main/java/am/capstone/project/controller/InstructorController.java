package am.capstone.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/instructors")
@Controller
public class InstructorController {

    @RequestMapping({"/", "/index", "/index.html"})
    public String instructorsIndex() {
        return "instructors/index";
    }
}
