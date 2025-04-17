package am.capstone.project.service.map;

import am.capstone.project.model.Instructor;
import am.capstone.project.service.InstructorService;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class InstructorServiceMap extends AbstractMapService<Instructor, Long> implements InstructorService {
    @Override
    public Set<Instructor> findAll() {
        return super.findAll();
    }

    @Override
    public Instructor save(Instructor entity) {
        return super.save(entity);
    }

    @Override
    public Instructor findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Instructor entity) {
        super.delete(entity);
    }
}
