package lv.javaguru.crm.core.modules.courses.validators;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.requests.CourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.responses.CourseFieldResponse;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CourseClassFieldsValidator {
    public CourseFieldResponse validate(CourseFieldRequest request) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Course>> violations = validator.validate(request.getCourse());

        List<CoreError> errors = new ArrayList<>();
        violations.forEach(v -> errors.add(new CoreError("Course", v.getMessage())));
        return new CourseFieldResponse(errors);
    }
}