package lv.javaguru.crm.core.modules.teachers.requests;

import lombok.Getter;

public class GetTeacherRequest {
    @Getter
    private final Long id;

    public GetTeacherRequest(Long id) {
        this.id = id;
    }
}