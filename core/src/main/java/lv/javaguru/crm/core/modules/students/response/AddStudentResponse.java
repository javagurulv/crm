package lv.javaguru.crm.core.modules.students.response;


import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;

import java.util.List;

public class AddStudentResponse extends CoreResponse {

    public AddStudentResponse(List<CoreError> coreError){
        super(coreError);
    }


}
