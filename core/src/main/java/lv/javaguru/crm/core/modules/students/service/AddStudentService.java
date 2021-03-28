package lv.javaguru.crm.core.modules.students.service;


import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.AddStudentRequest;
import lv.javaguru.crm.core.modules.students.response.AddStudentResponse;
import lv.javaguru.crm.core.modules.students.validators.AddStudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddStudentService {

    @Autowired
    private JpaStudentRepository repository;
    @Autowired
    private AddStudentValidator validator;

    public AddStudentResponse execute (AddStudentRequest request){

        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()){
            return new AddStudentResponse(errors);
        }

        repository.save(request.getStudent());
        return new AddStudentResponse(request.getStudent());
    }
}
