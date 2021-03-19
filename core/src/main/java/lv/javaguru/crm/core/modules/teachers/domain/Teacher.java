package lv.javaguru.crm.core.modules.teachers.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "teachers", schema = "javaguru_crm")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "email", nullable = false)
    private String email;

}
