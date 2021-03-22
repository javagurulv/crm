package lv.javaguru.crm.core.modules.courses.requests;

import lombok.Getter;
import lv.javaguru.crm.core.modules.courses.domain.Course;

public class AddCourseFieldRequest {
    @Getter
    private final Course course;

    public AddCourseFieldRequest(Course course) {
        this.course = course;
    }
}