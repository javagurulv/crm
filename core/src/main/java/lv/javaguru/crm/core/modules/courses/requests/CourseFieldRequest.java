package lv.javaguru.crm.core.modules.courses.requests;

import lombok.Getter;
import lv.javaguru.crm.core.modules.courses.domain.Course;

public class CourseFieldRequest {

    @Getter
    private final Course course;

    public CourseFieldRequest(Course course) {
        this.course = course;
    }

}