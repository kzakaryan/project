package am.capstone.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.HashSet;
import java.util.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Course extends BaseEntity {

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    private int credits;
    private int capacity;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> studentsEnrolled = new HashSet<>();

}