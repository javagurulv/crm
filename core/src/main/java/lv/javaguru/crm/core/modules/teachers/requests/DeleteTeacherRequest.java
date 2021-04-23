package lv.javaguru.crm.core.modules.teachers.requests;

import lombok.Getter;

public class DeleteTeacherRequest {
    @Getter
    private final Long teacherId;

    public DeleteTeacherRequest(Long teacherId) {
        this.teacherId = teacherId;
    }
}