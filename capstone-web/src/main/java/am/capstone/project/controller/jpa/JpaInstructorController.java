package am.capstone.project.controller.jpa;

import am.capstone.project.model.Instructor;
import am.capstone.project.service.spring_data_task.EntityManagerInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructors")
public class JpaInstructorController {

    private final EntityManagerInstructorService instructorService;


    @Autowired
    public JpaInstructorController(EntityManagerInstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/save")
    public String saveInstructor(@RequestBody Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "Instructor saved!";
    }
}