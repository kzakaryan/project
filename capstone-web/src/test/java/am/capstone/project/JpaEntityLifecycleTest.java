package am.capstone.project;

import am.capstone.project.repositories.CourseRepository;
import am.capstone.project.repositories.InstructorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Import({InstructorRepository.class, CourseRepository.class})
public class JpaEntityLifecycleTest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    void cleanDatabase() {
        courseRepository.deleteAll();
        instructorRepository.deleteAll();
    }

    @Test
    @Order(1)
    void saveParentWithoutId() {
        Instructor instructor = new Instructor();
        instructor.setFirstName("John");
        instructor.setLastName("Doe");

        // Save using repository
        Instructor savedInstructor1 = instructorRepository.save(instructor);
        assertNotNull(savedInstructor1.getInstructorId());

        // Save using persist()
        Instructor instructor2 = new Instructor();
        instructor2.setFirstName("Jane");
        instructor2.setLastName("Doe");
        entityManager.persist(instructor2);
        entityManager.flush();
        assertNotNull(instructor2.getInstructorId());

        // Save using merge()
        Instructor instructor3 = new Instructor();
        instructor3.setFirstName("Alex");
        instructor3.setLastName("Smith");
        Instructor mergedInstructor = entityManager.merge(instructor3);
        entityManager.flush();
        assertNotNull(mergedInstructor.getInstructorId());
    }

    @Test
    @Order(2)
    void saveParentWithId() {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(100L);
        instructor.setFirstName("Khachik");
        instructor.setLastName("Smith");

        // Using repository
        Instructor savedInstructor = instructorRepository.save(instructor);
        Assertions.assertEquals(100L, savedInstructor.getInstructorId());

        // Using persist() - This will fail
        Instructor instructor2 = new Instructor();
        instructor2.setInstructorId(200L);
        instructor2.setLastName("James");
        assertThrows(Exception.class, () -> {
            entityManager.persist(instructor2);
            entityManager.flush();
        });

        // Using merge() - Should work
        Instructor instructor3 = new Instructor();
        instructor3.setInstructorId(300L);
        instructor3.setLastName("Henry");
        Instructor mergedInstructor = entityManager.merge(instructor3);
        entityManager.flush();
        assertNotNull(mergedInstructor.getInstructorId());
    }

    @Test
    @Order(3)
    void saveParentWithChildren() {
        Instructor instructor = new Instructor();
        instructor.setLastName("Michael");

        Course course1 = new Course();
        course1.setName("AI Basics");

        Course course2 = new Course();
        course2.setName("Machine Learning");

        instructor.setCoursesAssigned(new HashSet<>(List.of(course1, course2)));
        course1.setInstructor(instructor);
        course2.setInstructor(instructor);

        // Using repository
        Instructor savedInstructor = instructorRepository.save(instructor);
        assertNotNull(savedInstructor.getInstructorId());
        Assertions.assertEquals(2, courseRepository.count());

        // Using persist() - Should work
        Instructor instructor2 = new Instructor();
        instructor2.setLastName("Robert");
        Course course3 = new Course();
        course3.setName("Data Science");
        instructor2.setCoursesAssigned(new HashSet<>(List.of(course3)));
        course3.setInstructor(instructor2);

        entityManager.persist(instructor2);
        entityManager.flush();
        assertNotNull(instructor2.getInstructorId());
        Assertions.assertEquals(3, courseRepository.count());
    }

    @Test
    @Order(4)
    void fetchAndModifyParent() {
        Instructor instructor = new Instructor();
        instructor.setLastName("Matthew");

        instructorRepository.save(instructor);

        // Fetch using JpaRepository and modify without saving
        Instructor fetchedInstructor = instructorRepository.findById(instructor.getInstructorId()).orElseThrow();
        fetchedInstructor.setLastName("Dr. New Matthew");

        entityManager.flush();

        Optional<Instructor> updatedInstructor = instructorRepository.findById(instructor.getInstructorId());
        Assertions.assertEquals("Dr. Changed Name", updatedInstructor.get().getLastName());
    }
}
