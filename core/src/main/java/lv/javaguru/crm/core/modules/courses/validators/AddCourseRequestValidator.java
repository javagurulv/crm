package lv.javaguru.crm.core.modules.courses.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.requests.AddCourseRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AddCourseRequestValidator {

    public List<CoreError> validate(AddCourseRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateCourseName(request).ifPresent(errors::add);
        validateCourseType(request).ifPresent(errors::add);
        validateStartDate(request).ifPresent(errors::add);
        validateEndDate(request).ifPresent(errors::add);
        validateDayOfWeek(request).ifPresent(errors::add);
        validateStartTime(request).ifPresent(errors::add);
        validateEndTime(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateCourseName(AddCourseRequest request) {
        return (request.getName() == null || request.getName().isBlank()
                ? Optional.of(new CoreError("Course Name", "must not be empty"))
                : Optional.empty());
    }

    private Optional<CoreError> validateCourseType(AddCourseRequest request) {
        return (request.getCourseType() == null || request.getCourseType().isBlank()
                ? Optional.of(new CoreError("Course Type", "must not be empty"))
                : Optional.empty());
    }

    private Optional<CoreError> validateStartDate(AddCourseRequest request) {
        return (request.getStartDate() == null
                ? Optional.of(new CoreError("Start Date", "must not be null"))
                : Optional.empty());
    }

    private Optional<CoreError> validateEndDate(AddCourseRequest request) {
        return (request.getEndDate() == null
                ? Optional.of(new CoreError("End Date", "must not be null"))
                : Optional.empty());
    }

    private Optional<CoreError> validateDayOfWeek(AddCourseRequest request) {
        return (request.getDayOfWeek() == null || request.getDayOfWeek().isBlank()
                ? Optional.of(new CoreError("Day of Week", "must not be empty"))
                : Optional.empty());
    }

    private Optional<CoreError> validateStartTime(AddCourseRequest request) {
        return (request.getStartTime() == null
                ? Optional.of(new CoreError("Start Time", "must not be null"))
                : Optional.empty());
    }

    private Optional<CoreError> validateEndTime(AddCourseRequest request) {
        return (request.getEndTime() == null
                ? Optional.of(new CoreError("End Time", "must not be null"))
                : Optional.empty());
    }

}
