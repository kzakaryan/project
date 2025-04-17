package am.capstone.project.service.map;

import am.capstone.project.model.Course;
import am.capstone.project.service.CrudService;
import java.util.Set;

public class CourseServiceMap extends AbstractMapService<Course, Long> implements CrudService<Course, Long> {

    @Override
    public Set<Course> findAll() {
        return super.findAll();
    }

    @Override
    public Course save(Course entity) {
        return super.save(entity.getId(), entity);
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
}
