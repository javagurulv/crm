package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.DeleteCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.DeleteCourseResponse;
import lv.javaguru.crm.core.modules.courses.validators.CourseIdValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteCourseService {
    @Autowired
    private JpaCourseRepository courseRepository;

    public DeleteCourseResponse deleteCourse(DeleteCourseRequest courseIdRequest) {
        DeleteCourseResponse errors = new CourseIdValidator().validate(courseIdRequest);
        Long id = courseIdRequest.getCourseId();

        if (errors.getErrors().isEmpty()) {
            courseRepository.deleteCourseById(id);
        }
        return errors;
    }
}