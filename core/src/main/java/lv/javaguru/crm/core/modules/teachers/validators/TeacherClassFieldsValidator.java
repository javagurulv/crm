package lv.javaguru.crm.core.modules.teachers.validators;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import lv.javaguru.crm.core.modules.teachers.requests.TeacherFieldRequest;
import lv.javaguru.crm.core.modules.teachers.responses.TeacherFieldResponse;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TeacherClassFieldsValidator {
    public TeacherFieldResponse validate(TeacherFieldRequest request) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Teacher>> violations = validator.validate(request.getTeacher());

        List<CoreError> errors = new ArrayList<>();
        violations.forEach(v -> errors.add(new CoreError("Teacher", v.getMessage())));
        return new TeacherFieldResponse(errors);
    }
}