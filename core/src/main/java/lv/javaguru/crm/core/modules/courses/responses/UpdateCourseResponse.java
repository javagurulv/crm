package lv.javaguru.crm.core.modules.courses.responses;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.courses.domain.Course;
import java.util.List;

public class UpdateCourseResponse extends CoreResponse {

    private Course updatedCourse;

    public UpdateCourseResponse(List<CoreError> errors) {
        super(errors);
    }

    public UpdateCourseResponse(Course updatedCourse) {
        this.updatedCourse = updatedCourse;
    }

    public Course getUpdatedCourse() {
        return updatedCourse;
    }

}
