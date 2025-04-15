package am.capstone.project.controller;

import am.capstone.project.model.Administrator;
import am.capstone.project.service.AdministratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Set;

@RequestMapping("api/administrators")
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

    @GetMapping
    public Set<Administrator> getAllAdministrators() {
        return administratorService.findAll();
    }

    @GetMapping("/{id}")
    public Administrator getAdministratorById(Long id) {
        return administratorService.findById(id);
    }

    @PostMapping
    public Administrator createAdministrator(@RequestBody Administrator administrator) {
        return administratorService.save(administrator);
    }
}
