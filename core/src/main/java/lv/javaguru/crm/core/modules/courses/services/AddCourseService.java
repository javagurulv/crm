package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.AddCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.AddCourseResponse;
import lv.javaguru.crm.core.modules.courses.validators.AddCourseRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddCourseService {
    @Autowired
    private JpaCourseRepository courseRepository;
    @Autowired
    private AddCourseRequestValidator validator;

    public AddCourseResponse execute(AddCourseRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddCourseResponse(errors);
        }
        Course course = new Course();
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

        courseRepository.save(course);
        return new AddCourseResponse(course);
    }

}
