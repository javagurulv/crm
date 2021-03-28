package lv.javaguru.crm.core.modules.students.request;


import lombok.Getter;
import lombok.Setter;
import lv.javaguru.crm.core.modules.students.domain.Student;

public class AddStudentRequest {

    @Getter
    @Setter
    private Student student;

    public AddStudentRequest(Student student) {
        this.student = student;
    }
}
