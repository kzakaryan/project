package am.capstone.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/faculties")
@Controller
public class FacultyController {

    @RequestMapping({"/", "/index", "/index.html"})
    public String facultiesIndex() {
        return "faculties/index";
    }
}
