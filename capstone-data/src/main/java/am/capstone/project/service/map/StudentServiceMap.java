package am.capstone.project.service.map;

import am.capstone.project.model.Student;
import am.capstone.project.service.StudentService;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class StudentServiceMap extends AbstractMapService<Student, Long> implements StudentService {
    @Override
    public Set<Student> findAll() {
        return super.findAll();
    }

    @Override
    public Student save(Student entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Student findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Student entity) {
        super.delete(entity);
    }
}
