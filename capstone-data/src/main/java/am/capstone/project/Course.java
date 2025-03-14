package am.capstone.project;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.*;

@Entity
public class Course {

    @Id
    private Long courseId;
    private String name;
    private String description;
    @OneToOne
    private Instructor instructor;
    private int credits;
    private int capacity;
    @ManyToMany(mappedBy = "students")
    private Set<Student> studentsEnrolled = new HashSet<>();

}