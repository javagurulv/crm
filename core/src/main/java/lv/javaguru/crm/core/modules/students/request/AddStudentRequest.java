package lv.javaguru.crm.core.modules.students.request;


import lombok.Getter;
import lv.javaguru.crm.core.modules.students.domain.Student;

public class AddStudentRequest {

    @Getter
    private Student student;

    public AddStudentRequest(Student student) {
        this.student = student;
    }
}
