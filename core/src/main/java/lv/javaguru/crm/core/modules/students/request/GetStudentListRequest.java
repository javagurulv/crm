package lv.javaguru.crm.core.modules.students.request;


import lombok.Getter;
import lv.javaguru.crm.core.modules.students.domain.Student;

import java.util.List;

public class GetStudentListRequest {

    @Getter
    private List<Student> studentList;


}
