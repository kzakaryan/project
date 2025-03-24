package am.capstone.project.service;

import am.capstone.project.model.Instructor;
import java.util.Set;

public interface InstructorService {

    Set<Instructor> findAll();

    Instructor save(Instructor instructor);

    Instructor findById(Long id);
}
