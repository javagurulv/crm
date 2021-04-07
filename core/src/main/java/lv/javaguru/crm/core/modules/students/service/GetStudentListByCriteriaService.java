package lv.javaguru.crm.core.modules.students.service;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.GetStudentListByCriteriaRequest;
import lv.javaguru.crm.core.modules.students.response.GetStudentListResponse;
import lv.javaguru.crm.core.modules.students.validators.GetStudentListByCriteriaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GetStudentListByCriteriaService {

    @Autowired
    private JpaStudentRepository studentRepository;

    @Autowired
    private GetStudentListByCriteriaValidator validator;

    public GetStudentListResponse execute(GetStudentListByCriteriaRequest request) {

        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()) {
            return new GetStudentListResponse(errors, null);
        }

        List<Student> students = studentRepository.findAll(request.getStudentListRequest());

        if (students.isEmpty()) {
            errors.add(new CoreError("database", "There is no data for this criteria."));
            return new GetStudentListResponse(errors, null);
        }

        return new GetStudentListResponse(null, students);
    }
}
