package am.capstone.project.service.spring_data_task;

import am.capstone.project.model.Instructor;
import am.capstone.project.repositories.InstructorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JpaInstructorService {

    private final InstructorRepository instructorRepository;

    public JpaInstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }
}
