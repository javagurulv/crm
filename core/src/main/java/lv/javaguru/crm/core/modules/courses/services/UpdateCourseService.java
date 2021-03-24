package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.UpdateCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.UpdateCourseResponse;
import lv.javaguru.crm.core.modules.courses.validators.UpdateCourseRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UpdateCourseService {

    @Autowired private JpaCourseRepository courseRepository;
    @Autowired private UpdateCourseRequestValidator validator;

    public UpdateCourseResponse execute(UpdateCourseRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new UpdateCourseResponse(errors);
        }

        return courseRepository.findById(request.getId())
                .map(course -> {
                    course.setName(request.getName());
                    course.setCourseType(request.getCourseType());
                    course.setStartDate(request.getStartDate());
                    course.setEndDate(request.getEndDate());
                    course.setDayOfWeek(request.getDayOfWeek());
                    course.setStartTime(request.getStartTime());
                    course.setEndTime(request.getEndTime());
                    course.setOpenClassDate(request.getOpenClassDate());
                    course.setOpenClassStartTime(request.getOpenClassStartTime());
                    course.setOpenClassEndTime(request.getOpenClassEndTime());
                    course.setTeacher(request.getTeacher());
                    return new UpdateCourseResponse(course);
                })
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new UpdateCourseResponse(errors);
                });
    }

}
