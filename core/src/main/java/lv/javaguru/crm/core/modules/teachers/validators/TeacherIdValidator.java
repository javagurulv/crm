package lv.javaguru.crm.core.modules.teachers.validators;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.teachers.requests.DeleteTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.DeleteTeacherResponse;

import java.util.ArrayList;
import java.util.List;

public class TeacherIdValidator {
    public DeleteTeacherResponse validate(DeleteTeacherRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getTeacherId() == null) {
            errors.add(new CoreError("Teacher Id", "Should not be empty"));
        }
        return new DeleteTeacherResponse(errors);
    }
}