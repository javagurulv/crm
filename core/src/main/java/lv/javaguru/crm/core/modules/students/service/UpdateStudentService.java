package lv.javaguru.crm.core.modules.students.service;


import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.UpdateStudentRequest;
import lv.javaguru.crm.core.modules.students.response.UpdateStudentResponse;
import lv.javaguru.crm.core.modules.students.validators.UpdateStudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UpdateStudentService {

    @Autowired
    private JpaStudentRepository repository;
    @Autowired
    private UpdateStudentValidator validator;

    public UpdateStudentResponse execute (UpdateStudentRequest request){
        List<CoreError> errors = validator.validate(request);

        if (!errors.isEmpty()){
            return new UpdateStudentResponse(errors);
        }

        return new UpdateStudentResponse(request.getStudent());
    }
}
