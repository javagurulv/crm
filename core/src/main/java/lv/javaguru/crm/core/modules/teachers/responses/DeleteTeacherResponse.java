package lv.javaguru.crm.core.modules.teachers.responses;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.core_error.CoreResponse;

import java.util.List;

public class DeleteTeacherResponse extends CoreResponse {
    public DeleteTeacherResponse(List<CoreError> errors) {
        super(errors);
    }
}