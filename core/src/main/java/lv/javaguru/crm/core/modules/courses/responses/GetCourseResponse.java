package lv.javaguru.crm.core.modules.courses.responses;

import lombok.Getter;
import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.courses.domain.Course;

import java.util.List;

public class GetCourseResponse extends CoreResponse {
    @Getter
    private Course course;

    public GetCourseResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetCourseResponse(Course course) {
        this.course = course;
    }
}