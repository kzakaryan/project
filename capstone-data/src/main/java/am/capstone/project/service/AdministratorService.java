package am.capstone.project.service;

import am.capstone.project.model.Administrator;
import java.util.Set;

public interface AdministratorService {

    Administrator save(Administrator administrator);

    Administrator findById(Long id);

    Set<Administrator> findAll();

}
