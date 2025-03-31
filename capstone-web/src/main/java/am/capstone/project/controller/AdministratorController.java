package am.capstone.project.controller;


import am.capstone.project.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/administrators")
@Controller
public class AdministratorController {

    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }


    @RequestMapping({"/", "/index", "/index.html"})
    public String administratorsIndex(Model model) {
        model.addAttribute("administrators", administratorService.findAll());
        return "administrators/index";
    }
}
