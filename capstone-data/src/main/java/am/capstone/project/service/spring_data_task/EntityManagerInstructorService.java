package am.capstone.project.service.spring_data_task;

import am.capstone.project.model.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EntityManagerInstructorService {

    public EntityManagerInstructorService() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void persistInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Transactional
    public Instructor mergeInstructor(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    public Instructor findInstructor(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    public void saveInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }
}
