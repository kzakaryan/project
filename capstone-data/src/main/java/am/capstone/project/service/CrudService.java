package am.capstone.project.service;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T entity);

    void deleteById(ID id);

    void delete(T entity);

}
