package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.DeleteCourseByIdRequest;
import lv.javaguru.crm.core.modules.courses.responses.DeleteCourseByIdResponse;
import lv.javaguru.crm.core.modules.courses.validators.DeleteCourseByIdValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeleteCourseByIdService {

    @Autowired private JpaCourseRepository courseRepository;
    @Autowired private DeleteCourseByIdValidator validator;

    public DeleteCourseByIdResponse execute(DeleteCourseByIdRequest courseIdRequest) {
        List<CoreError> errors = validator.validate(courseIdRequest);
        Long id = courseIdRequest.getCourseId();

        if (!errors.isEmpty()) {
            return new DeleteCourseByIdResponse(errors);
        } else return new DeleteCourseByIdResponse(courseRepository.deleteCourseById(id) == 1);
    }

}
