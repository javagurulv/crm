package lv.javaguru.crm.core.modules.courses.requests;

import lombok.Getter;

public class GetCourseRequest {
    @Getter
    private final Long id;

    public GetCourseRequest(Long id) {
        this.id = id;
    }
}