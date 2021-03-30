package lv.javaguru.crm.core.modules.students.request;

import lombok.Getter;
import lv.javaguru.crm.core.modules.students.domain.Student;

public class UpdateStudentRequest {

    @Getter
    private Student student;

    public UpdateStudentRequest(Student student) {
        this.student = student;
    }
}
