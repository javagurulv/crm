package lv.javaguru.crm.core.modules.courses.responses;

import lombok.Getter;
import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.courses.domain.Course;

import java.util.List;

public class UpdateCourseResponse extends CoreResponse {
    @Getter
    private Course updatedCourse;

    public UpdateCourseResponse(List<CoreError> errors) {
        super(errors);
    }

    public UpdateCourseResponse(Course updatedCourse) {
        this.updatedCourse = updatedCourse;
    }
}