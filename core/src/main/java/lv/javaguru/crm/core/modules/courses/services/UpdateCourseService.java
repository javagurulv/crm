package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.CourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.requests.UpdateCourseRequest;
import lv.javaguru.crm.core.modules.courses.requests.VerifyCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.CourseFieldResponse;
import lv.javaguru.crm.core.modules.courses.responses.UpdateCourseResponse;
import lv.javaguru.crm.core.modules.courses.responses.VerifyCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UpdateCourseService {
    @Autowired
    private VerifyCourseDatabaseService verifyCourseDatabaseService;
    @Autowired
    private AddCourseService addCourseService;
    @Autowired
    private JpaCourseRepository courseRepository;

    public UpdateCourseResponse updateCourse(UpdateCourseRequest request) throws NoSuchFieldException, IllegalAccessException {
        List<CoreError> errors = new ArrayList<>();

        VerifyCourseResponse verifyCourseResponse = verifyCourseDatabaseService
                .isCourse(new VerifyCourseRequest(request.getCourse()));

        if (!verifyCourseResponse.isCourseExists()) {
            errors.add(new CoreError("Course", "object not exists"));
            return new UpdateCourseResponse(errors);
        }

        CourseFieldResponse response = addCourseService
                .addCourse(new CourseFieldRequest(request.getCourse()));

        if (response.getErrors().isEmpty()) {
            courseRepository.save(request.getCourse());
        }
        return new UpdateCourseResponse(response.getErrors());
    }
}