package am.capstone.project.service;

import am.capstone.project.model.Course;
import java.util.Set;

public interface CourseService extends CrudService<Course, Long> {

    Course findByName(String name);

}