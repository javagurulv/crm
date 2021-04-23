package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.GetTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.GetTeacherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GetTeacherService {
    @Autowired
    private JpaTeachersRepository teachersRepository;

    public GetTeacherResponse getTeacherById(GetTeacherRequest request) {
        List<CoreError> errors = new ArrayList<>();
        return teachersRepository
                .findById(request.getId())
                .map(GetTeacherResponse::new)
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "not found"));
                    return new GetTeacherResponse(errors);
                });
    }
}