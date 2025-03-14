package am.capstone.project;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@Entity
public class Student {

    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;

    @ManyToMany(mappedBy = "courses")
    private Set<Course> coursesEnrolled;

    private int credits;

}