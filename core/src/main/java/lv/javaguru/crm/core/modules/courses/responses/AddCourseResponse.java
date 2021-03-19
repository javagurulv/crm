package lv.javaguru.crm.core.modules.courses.responses;

import lv.javaguru.crm.core.domain.Course;
import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;

import java.util.List;

public class AddCourseResponse extends CoreResponse {

    private Course newCourse;

    public AddCourseResponse(Course newCourse) {
        this.newCourse = newCourse;
    }

    public AddCourseResponse(List<CoreError> errors) {
        super(errors);
    }

    public Course getNewCourse() {
        return newCourse;
    }

}
