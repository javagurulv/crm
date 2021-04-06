package lv.javaguru.crm.core.modules.students.domain;




import lombok.Data;
import lv.javaguru.crm.core.modules.courses.domain.Course;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students", schema = "javaguru_crm")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private  String surname;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(name = "email", nullable = false)
    private String email;
    @OneToMany
    @JoinColumn(name = "courseId")
    private Course course;


}
