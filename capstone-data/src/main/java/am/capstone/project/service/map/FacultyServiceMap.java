package am.capstone.project.service.map;

import am.capstone.project.model.Course;
import am.capstone.project.model.Faculty;
import am.capstone.project.service.CrudService;

import java.util.Set;

public class FacultyServiceMap extends AbstractMapService<Faculty, Long> implements CrudService<Faculty, Long>  {

    @Override
    public Set<Faculty> findAll() {
        return super.findAll();
    }

    @Override
    public Faculty save(Faculty entity) {
        return super.save(entity.getId(), entity);
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
