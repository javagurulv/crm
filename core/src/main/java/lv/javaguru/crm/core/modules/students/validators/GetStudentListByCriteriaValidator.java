package lv.javaguru.crm.core.modules.students.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.request.GetStudentListByCriteriaRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GetStudentListByCriteriaValidator {

    private static final Pattern PATTERN_ALPHABET = Pattern.compile("[a-zA-Z]+");

    public List<CoreError> validate (GetStudentListByCriteriaRequest studentListRequest){

        List<CoreError> errors = new ArrayList<>();

        if (studentListRequest.getStudentListRequest().isBlank() || studentListRequest.getStudentListRequest() == null) {
            CoreError error = new CoreError("searchCriteria", "It is required to define at list one of the search criteria.");
            errors.add(error);
        }

        if (!PATTERN_ALPHABET.matcher(studentListRequest.getStudentListRequest()).matches()) {
            CoreError error = new CoreError("searchCriteria", "The search criteria contains incorrect symbols.");
            errors.add(error);
        }

        return errors;

    }
}
