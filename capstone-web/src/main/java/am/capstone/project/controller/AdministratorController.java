package am.capstone.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/administrators")
@Controller
public class AdministratorController {

    @RequestMapping({"/", "/index", "/index.html"})
    public String administratorsIndex() {
        return "administrators/index";
    }
}
