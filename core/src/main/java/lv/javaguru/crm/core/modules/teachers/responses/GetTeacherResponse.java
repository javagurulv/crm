package lv.javaguru.crm.core.modules.teachers.responses;

import lombok.Getter;
import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.core_error.CoreResponse;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;

import java.util.List;

public class GetTeacherResponse extends CoreResponse {
    @Getter
    private Teacher teacher;

    public GetTeacherResponse(List<CoreError> errors) {
        super(errors);
    }

    public GetTeacherResponse(Teacher teacher) {
        this.teacher = teacher;
    }
}