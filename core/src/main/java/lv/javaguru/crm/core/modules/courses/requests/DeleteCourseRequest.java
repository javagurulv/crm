package lv.javaguru.crm.core.modules.courses.requests;

import lombok.Getter;


public class DeleteCourseRequest {
    @Getter
    private final Long courseId;

    public DeleteCourseRequest(Long courseId) {
        this.courseId = courseId;
    }
}