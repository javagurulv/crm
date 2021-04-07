package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.CourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.responses.CourseFieldResponse;
import lv.javaguru.crm.core.modules.courses.validators.CourseClassFieldsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddCourseService {
    @Autowired
    private JpaCourseRepository courseRepository;

    public CourseFieldResponse addCourse(CourseFieldRequest request) throws IllegalAccessException, NoSuchFieldException {

        CourseFieldResponse courseClassErrors = new CourseClassFieldsValidator().validate(
                new CourseFieldRequest(request.getCourse()));

        if (courseClassErrors.getErrors().isEmpty()) {
            courseRepository.save(request.getCourse());
        }
        return courseClassErrors;
    }
}