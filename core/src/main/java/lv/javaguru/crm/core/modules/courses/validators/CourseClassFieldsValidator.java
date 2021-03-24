package lv.javaguru.crm.core.modules.courses.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.requests.CourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.responses.CourseFieldResponse;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CourseClassFieldsValidator {

    public CourseFieldResponse validate(CourseFieldRequest request) throws NoSuchFieldException, IllegalAccessException {
        List<String> obligateFields = List.of("name", "courseType", "startDate", "endDate",
                "dayOfWeek", "startTime", "endTime");
        List<CoreError> courseFieldsErrors = new ArrayList<>();
        Course course = request.getCourse();

        for (String fieldName : obligateFields) {
            Field courseField = Course.class.getDeclaredField(fieldName);
            courseField.setAccessible(true);
            CoreError error = checkCourseField(courseField.get(course), courseField.getName());
            if (isErrorCourseField(error)) {
                courseFieldsErrors.add(error);
            }
        }
        return new CourseFieldResponse(courseFieldsErrors);
    }

    private boolean isErrorCourseField(CoreError error) {
        return error.getField().length() != 0;
    }

    private CoreError checkCourseField(Object courseClassField, String courseClassFieldName) {
        if (courseClassField == null) {
            return new CoreError(courseClassFieldName, "must not be null");
        }
        if (courseClassField instanceof String && ((String) courseClassField).isBlank()) {
            return new CoreError(courseClassFieldName, "must not be empty");
        }
        return new CoreError("", "");
    }
}