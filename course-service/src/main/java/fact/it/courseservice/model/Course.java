package fact.it.courseservice.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true) // Assuming course numbers are unique
    private String courseNumber;

    private String title;
    private String description;
    private String instructor;

}

