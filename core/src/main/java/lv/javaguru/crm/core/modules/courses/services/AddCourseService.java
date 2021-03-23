package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.AddCourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.responses.AddCourseFieldResponse;
import lv.javaguru.crm.core.modules.courses.validators.CourseClassFieldsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddCourseService {
    @Autowired
    private JpaCourseRepository courseRepository;

    public AddCourseFieldResponse addCourse(AddCourseFieldRequest request) throws IllegalAccessException, NoSuchFieldException {

        AddCourseFieldResponse courseClassErrors = new CourseClassFieldsValidator().validate(
                new AddCourseFieldRequest(request.getCourse()));

        if (courseClassErrors.getErrors().isEmpty()) {
            courseRepository.save(request.getCourse());
        }
        return courseClassErrors;
    }
}