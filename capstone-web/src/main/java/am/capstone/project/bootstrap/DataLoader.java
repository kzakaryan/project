package am.capstone.project.bootstrap;

import am.capstone.project.service.*;
import am.capstone.project.service.map.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentService studentService;
    private final CourseService courseService;
    private final InstructorService instructorService;
    private final FacultyService facultyService;
    private final AdministratorService administratorService;

    public DataLoader(StudentService studentService, CourseService courseService, InstructorService instructorService, FacultyService facultyService, AdministratorService administratorService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.instructorService = instructorService;
        this.facultyService = facultyService;
        this.administratorService = administratorService;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
