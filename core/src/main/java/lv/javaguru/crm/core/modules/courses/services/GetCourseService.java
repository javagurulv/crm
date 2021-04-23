package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.GetCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.GetCourseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GetCourseService {
    @Autowired
    private JpaCourseRepository courseRepository;

    public GetCourseResponse getCourseById(GetCourseRequest request) {
        List<CoreError> errors = new ArrayList<>();
        return courseRepository
                .findById(request.getId())
                .map(GetCourseResponse::new)
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "not found"));
                    return new GetCourseResponse(errors);
                });
    }
}