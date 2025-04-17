package am.capstone.project;


import am.capstone.project.model.Instructor;
import am.capstone.project.repositories.InstructorRepository;
import am.capstone.project.service.spring_data_task.EntityManagerInstructorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InstructorJpaTests {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private EntityManagerInstructorService entityManagerInstructorService;

    @PersistenceContext
    private EntityManager entityManager;

    private Instructor testInstructor;

    @BeforeEach
    void setup() {
        testInstructor = new Instructor();
        testInstructor.setFirstName("John");
        testInstructor.setLastName("Doe");
        testInstructor.setEmail("john.doe@example.com");
        testInstructor.setPassword("securepass");
    }

    @Test
    @Order(1)
    void testRepositorySave() {
        Instructor savedInstructor = instructorRepository.save(testInstructor);
        assertNotNull(savedInstructor.getId());
    }

    @Test
    @Order(2)
    @Transactional
    void testEntityManagerPersist() {
        entityManagerInstructorService.persistInstructor(testInstructor);
        entityManager.flush();

        Instructor retrievedInstructor = entityManager.find(Instructor.class, testInstructor.getId());
        assertNotNull(retrievedInstructor);
    }

    @Test
    @Order(3)
    @Transactional
    void testEntityManagerMerge() {
        Instructor detachedInstructor = new Instructor();
        detachedInstructor.setId(1L); // Simulating an existing instructor
        detachedInstructor.setFirstName("Updated Name");

        Instructor mergedInstructor = entityManagerInstructorService.mergeInstructor(detachedInstructor);
        entityManager.flush();

        assertEquals("Updated Name", mergedInstructor.getFirstName());
    }

    @AfterEach
    void cleanup() {
        instructorRepository.deleteAll();
    }
}
