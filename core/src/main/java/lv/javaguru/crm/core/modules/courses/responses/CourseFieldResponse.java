package lv.javaguru.crm.core.modules.courses.responses;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;

import java.util.List;

public class CourseFieldResponse extends CoreResponse {
    public CourseFieldResponse(List<CoreError> coreError) {
        super(coreError);
    }
}