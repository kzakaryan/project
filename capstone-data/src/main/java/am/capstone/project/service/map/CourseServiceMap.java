package am.capstone.project.service.map;

import am.capstone.project.model.Course;
import am.capstone.project.service.CourseService;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class CourseServiceMap extends AbstractMapService<Course, Long> implements CourseService {

    @Override
    public Set<Course> findAll() {
        return super.findAll();
    }

    @Override
    public Course save(Course entity) {
        return super.save(entity);
    }

    @Override
    public Course findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Course entity) {
        super.delete(entity);
    }

    @Override
    public Course findByName(String name) {
        return null;
    }
}
