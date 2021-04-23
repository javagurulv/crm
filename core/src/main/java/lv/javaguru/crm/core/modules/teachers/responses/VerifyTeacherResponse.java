package lv.javaguru.crm.core.modules.teachers.responses;

import lombok.Getter;

public class VerifyTeacherResponse {
    @Getter
    private final boolean teacherExists;

    public VerifyTeacherResponse(boolean teacherExists) {
        this.teacherExists = teacherExists;
    }
}