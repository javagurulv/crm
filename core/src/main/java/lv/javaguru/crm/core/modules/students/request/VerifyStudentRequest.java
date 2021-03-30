package lv.javaguru.crm.core.modules.students.request;

import lombok.Getter;
import lv.javaguru.crm.core.modules.students.domain.Student;

public class VerifyStudentRequest {

    @Getter
    private Student student;

    public VerifyStudentRequest(Student student){this.student = student;}
}
