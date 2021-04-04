package lv.javaguru.crm.core.modules.students.service;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.GetStudentListRequest;
import lv.javaguru.crm.core.modules.students.response.GetStudentListResponse;
import lv.javaguru.crm.core.modules.students.validators.GetStudentListValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GetStudentListService {

    @Autowired
    private JpaStudentRepository studentRepository;

    @Autowired
    private GetStudentListValidator validator;

    public GetStudentListResponse execute(GetStudentListRequest request) {
        List<CoreError> errors = validator.validate(request);

        if (studentRepository.findAll().isEmpty()) {
            errors.add(new CoreError("database", "Database is empty"));
            return new GetStudentListResponse(errors, new ArrayList<>());
        }
        List<Student> students = studentRepository.findAll();
        return new GetStudentListResponse(students);
    }
}
      /*  List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetStudentListResponse(errors, null);
        }

        List<Student> listStudents = studentRepository.findByNameAndSurnameAndPhoneNumberAndComment(
                "%" + request.getQueryString() + "%",
                "%" + request.getQueryString() + "%",
                "%" + request.getQueryString() + "%",
                "%" + request.getQueryString() + "%"
        );

        return new GetStudentListResponse(null, listStudents);
    }
}
*/