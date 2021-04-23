package lv.javaguru.crm.core.modules.teachers.requests;

import lombok.Getter;
import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

public class UpdateTeacherRequest {
    @Getter
    private final Teacher teacher;

    public UpdateTeacherRequest(Teacher teacher) {
        this.teacher = teacher;
    }
}