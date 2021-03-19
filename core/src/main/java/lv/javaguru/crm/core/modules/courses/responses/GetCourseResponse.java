package lv.javaguru.crm.core.modules.courses.responses;

import lv.javaguru.crm.core.domain.Course;
import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;

import java.util.List;

public class GetCourseResponse extends CoreResponse {

    private Course course;

    public GetCourseResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetCourseResponse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }

}
