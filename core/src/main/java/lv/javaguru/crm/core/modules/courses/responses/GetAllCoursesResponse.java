package lv.javaguru.crm.core.modules.courses.responses;

import lv.javaguru.crm.core.modules.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.courses.domain.Course;
import java.util.List;

public class GetAllCoursesResponse extends CoreResponse {

    private final List<Course> courseList;

    public GetAllCoursesResponse(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

}
