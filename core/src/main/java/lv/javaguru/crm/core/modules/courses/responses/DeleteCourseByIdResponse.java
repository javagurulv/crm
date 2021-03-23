package lv.javaguru.crm.core.modules.courses.responses;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.core_error.CoreResponse;
import java.util.List;

public class DeleteCourseByIdResponse extends CoreResponse {

    private boolean courseRemoved;

    public DeleteCourseByIdResponse(boolean courseRemoved) {
        this.courseRemoved = courseRemoved;
    }

    public DeleteCourseByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public boolean isCourseRemoved() {
        return courseRemoved;
    }

}
