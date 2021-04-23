package lv.javaguru.crm.core.modules.teachers.responses;

import lv.javaguru.crm.core.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

import java.util.List;

public class GetAllTeachersResponse extends CoreResponse {

    private final List<Teacher> teacherList;

    public GetAllTeachersResponse(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Teacher> getCourseList() {
        return teacherList;
    }

}