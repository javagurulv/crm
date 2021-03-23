package lv.javaguru.crm.core.modules.courses.responses;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;

import java.util.List;

public class DeleteCourseResponse extends CoreResponse {
    public DeleteCourseResponse(List<CoreError> errors) {
        super(errors);
    }
}