package lv.javaguru.crm.core.modules.courses.requests;

import lombok.Getter;
import lv.javaguru.crm.core.modules.courses.domain.Course;

public class VerifyCourseRequest {
    @Getter
    private final Course course;

    public VerifyCourseRequest(Course course) {
        this.course = course;
    }
}