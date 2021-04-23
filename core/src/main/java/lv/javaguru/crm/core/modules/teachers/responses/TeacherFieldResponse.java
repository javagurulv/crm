package lv.javaguru.crm.core.modules.teachers.responses;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.core_error.CoreResponse;

import java.util.List;

public class TeacherFieldResponse extends CoreResponse {
    public TeacherFieldResponse(List<CoreError> coreError) {
        super(coreError);
    }
}