package lv.javaguru.crm.core.modules.students.response;

import lombok.Getter;

public class VerifyStudentResponse {

    @Getter
    private boolean studentExists;

    public VerifyStudentResponse(boolean studentExists) {this.studentExists = studentExists;}
}
