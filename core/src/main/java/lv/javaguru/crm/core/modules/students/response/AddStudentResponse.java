package lv.javaguru.crm.core.modules.students.response;


import lombok.Getter;
import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.students.domain.Student;

import java.util.List;

public class AddStudentResponse extends CoreResponse {

    @Getter
    private Student student;

    public AddStudentResponse(List<CoreError> coreError){
        super(coreError);
    }

    public AddStudentResponse(Student student){this.student = student;}
}
