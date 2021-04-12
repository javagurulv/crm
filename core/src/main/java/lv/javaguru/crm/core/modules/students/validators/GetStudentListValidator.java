package lv.javaguru.crm.core.modules.students.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.request.GetStudentListRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetStudentListValidator {

    public List<CoreError> validate (GetStudentListRequest getStudentListRequest){

        return new ArrayList<>();

    }

}
