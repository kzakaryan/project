package am.capstone.project.service;

import am.capstone.project.model.Faculty;
import java.util.Set;

public interface FacultyService {

    Faculty save(Faculty faculty);

    Set<Faculty> findAll();

    Faculty findById(Long id);
}
