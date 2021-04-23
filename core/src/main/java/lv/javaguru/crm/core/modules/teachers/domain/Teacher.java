package lv.javaguru.crm.core.modules.teachers.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "teachers", schema = "javaguru_crm")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Field [Teacher first_name] may not be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @NotBlank(message = "Field [Teacher second_name] may not be empty")
    @Column(name = "second_name", nullable = false)
    private String secondName;
    @NotBlank(message = "Field [Teacher phone] may not be empty")
    @Column(name = "phone", nullable = false)
    private String phone;
    @NotBlank(message = "Field [Teacher email] may not be empty")
    @Column(name = "email", nullable = false)
    private String email;
}