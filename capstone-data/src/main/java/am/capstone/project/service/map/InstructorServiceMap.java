package am.capstone.project.service.map;

import am.capstone.project.model.Instructor;
import am.capstone.project.service.CrudService;
import java.util.Set;

public class InstructorServiceMap extends AbstractMapService<Instructor, Long> implements CrudService<Instructor, Long> {
    @Override
    public Set<Instructor> findAll() {
        return super.findAll();
    }

    @Override
    public Instructor save(Instructor entity) {
        return super.save(entity.getId(), entity);
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
