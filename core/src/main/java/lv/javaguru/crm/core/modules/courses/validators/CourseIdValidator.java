package lv.javaguru.crm.core.modules.courses.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.requests.DeleteCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.DeleteCourseResponse;

import java.util.ArrayList;
import java.util.List;

public class CourseIdValidator {
    public DeleteCourseResponse validate(DeleteCourseRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request.getCourseId() == null) {
            errors.add(new CoreError("Course Id", "Should not be empty"));
        }
        return new DeleteCourseResponse(errors);
    }
}