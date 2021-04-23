package lv.javaguru.crm.core.modules.teachers.responses;

import lombok.Getter;
import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

import java.util.List;

public class UpdateTeacherResponse extends CoreResponse {
    @Getter
    private Teacher updatedTeacher;

    public UpdateTeacherResponse(List<CoreError> errors) {
        super(errors);
    }

    public UpdateTeacherResponse(Teacher updatedTeacher) {
        this.updatedTeacher = updatedTeacher;
    }
}