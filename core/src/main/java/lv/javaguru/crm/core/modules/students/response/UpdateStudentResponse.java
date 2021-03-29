package lv.javaguru.crm.core.modules.students.response;

import lombok.Getter;
import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.students.domain.Student;

import java.util.List;

public class UpdateStudentResponse extends CoreResponse {

    @Getter
    private Student updatedStudent;

    public UpdateStudentResponse(List<CoreError> coreError) {
        super(coreError);
    }

    public UpdateStudentResponse(Student updateStudent){this.updatedStudent = updateStudent;}

}
