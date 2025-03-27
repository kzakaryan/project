package am.capstone.project.service.map;

import am.capstone.project.model.Administrator;
import am.capstone.project.service.AdministratorService;
import java.util.Set;

public class AdministratorServiceMap extends AbstractMapService<Administrator, Long> implements AdministratorService {

    @Override
    public Set<Administrator> findAll() {
        return super.findAll();
    }

    @Override
    public Administrator save(Administrator entity) {
        return super.save(entity.getId(), entity);
    }

    @Override
    public Administrator findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Administrator entity) {
        super.delete(entity);
    }
}
