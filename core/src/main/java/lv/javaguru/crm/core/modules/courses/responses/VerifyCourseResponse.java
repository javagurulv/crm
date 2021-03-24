package lv.javaguru.crm.core.modules.courses.responses;

import lombok.Getter;

public class VerifyCourseResponse {
    @Getter
    private final boolean courseExists;

    public VerifyCourseResponse(boolean courseExists) {
        this.courseExists = courseExists;
    }
}