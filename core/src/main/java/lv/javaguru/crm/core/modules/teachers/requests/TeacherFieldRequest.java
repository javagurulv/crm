package lv.javaguru.crm.core.modules.teachers.requests;

import lombok.Getter;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

public class TeacherFieldRequest {
    @Getter
    private final Teacher teacher;

    public TeacherFieldRequest(Teacher teacher) {
        this.teacher = teacher;
    }
}