package lv.javaguru.crm.core.modules.students.domain;




import javax.persistence.*;

@Entity
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
    @Column(name = "comment")
    private String comment;
    /*@OneToMany
    @JoinColumn(name = "courseId")
    private Course course;
     */

}
