package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.GetCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.GetCourseResponse;
import lv.javaguru.crm.core.modules.courses.validators.GetCourseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetCourseService {
    @Autowired
    private JpaCourseRepository courseRepository;
    @Autowired
    private GetCourseValidator validator;

    public GetCourseResponse execute(GetCourseRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetCourseResponse(errors);
        }
        return courseRepository.findById(request.getId())
                .map(GetCourseResponse::new)
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new GetCourseResponse(errors);
                });
    }
}
