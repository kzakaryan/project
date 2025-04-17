package am.capstone.project.service.map;

import am.capstone.project.model.Faculty;
import am.capstone.project.service.FacultyService;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class FacultyServiceMap extends AbstractMapService<Faculty, Long> implements FacultyService {

    @Override
    public Set<Faculty> findAll() {
        return super.findAll();
    }

    @Override
    public Faculty save(Faculty entity) {
        return super.save(entity);
    }

    @Override
    public Faculty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Faculty entity) {
        super.delete(entity);
    }
}
