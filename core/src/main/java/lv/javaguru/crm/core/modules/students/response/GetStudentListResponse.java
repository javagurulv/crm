package lv.javaguru.crm.core.modules.students.response;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.students.domain.Student;

import java.util.List;

public class GetStudentListResponse extends CoreResponse {

    private List<Student> studentList;

    public GetStudentListResponse(List<CoreError> errors, List<Student> studentList) {
        super(errors);
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
