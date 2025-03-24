package am.capstone.project.service;

import am.capstone.project.model.Course;
import java.util.Set;

public interface CourseService {

    Course findByName(String name);

    Course findById(Long id);

    Set<Course> findAll();

    Course save(Course course);

}
