package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.VerifyCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.VerifyCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerifyCourseDatabaseService {
    @Autowired
    private JpaCourseRepository courseRepository;

    public VerifyCourseResponse isCourseExists(VerifyCourseRequest request) {
        boolean courseExits = false;
        Course course = request.getCourse();
        if (course != null) {
            courseExits = courseRepository.existsById(course.getId());
        }
        return new VerifyCourseResponse(courseExits);
    }
}