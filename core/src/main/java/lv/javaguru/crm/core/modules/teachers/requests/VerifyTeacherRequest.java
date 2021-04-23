package lv.javaguru.crm.core.modules.teachers.requests;

import lombok.Getter;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

public class VerifyTeacherRequest {
    @Getter
    private final Teacher teacher;

    public VerifyTeacherRequest(Teacher teacher) {
        this.teacher = teacher;
    }
}