package lv.javaguru.crm.core.modules.courses.responses;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;

import java.util.List;

public class AddCourseFieldResponse extends CoreResponse {
    public AddCourseFieldResponse(List<CoreError> coreError) {
        super(coreError);
    }
}