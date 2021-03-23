package lv.javaguru.crm.core.modules.courses.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.requests.DeleteCourseByIdRequest;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeleteCourseByIdValidator {

    public List<CoreError> validate (DeleteCourseByIdRequest request){
        List<CoreError> errors = new ArrayList<>();
        if (request.getCourseId() == null) {
            errors.add(new CoreError("Course Id", "Should not be empty."));
        } return errors;
    }

}
