package lv.javaguru.crm.core.modules.students.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.request.GetStudentListRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetStudentListValidator {

    public List<CoreError> validate(GetStudentListRequest request) {
        List<CoreError> errors = new ArrayList<>();

        if (request.getQueryString().isBlank() || request.getQueryString() == null) {
            CoreError error = new CoreError("query", "Must be not empty");
            errors.add(error);
        }

        return errors;
    }

}
