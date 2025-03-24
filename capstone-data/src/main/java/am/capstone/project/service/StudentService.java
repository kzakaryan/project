package am.capstone.project.service;

import am.capstone.project.model.Student;
import java.util.Set;

public interface StudentService {

    Student save(Student student);

    Set<Student> findAll();

    Student findById(Long id);

}
