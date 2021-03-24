package lv.javaguru.crm.core.modules.courses.requests;

import lombok.Getter;
import lv.javaguru.crm.core.modules.courses.domain.Course;

public class UpdateCourseRequest {
    @Getter
    private final Course course;

    public UpdateCourseRequest(Course course) {
        this.course = course;
    }
}