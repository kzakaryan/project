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



    public DataLoader() {
        this.studentService = new StudentServiceMap();
        this.courseService = new CourseServiceMap();
        this.instructorService = new InstructorServiceMap();
        this.facultyService = new FacultyServiceMap();
        this.administratorService = new AdministratorServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
