package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.TeacherFieldRequest;
import lv.javaguru.crm.core.modules.teachers.requests.UpdateTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.requests.VerifyTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.TeacherFieldResponse;
import lv.javaguru.crm.core.modules.teachers.responses.UpdateTeacherResponse;
import lv.javaguru.crm.core.modules.teachers.responses.VerifyTeacherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UpdateTeacherService {
    @Autowired
    private VerifyTeacherDatabaseService verifyTeacherDatabaseService;
    @Autowired
    private AddTeacherService addTeacherService;
    @Autowired
    private JpaTeachersRepository teachersRepository;

    public UpdateTeacherResponse updateTeacher(UpdateTeacherRequest request) {
        List<CoreError> errors = new ArrayList<>();

        VerifyTeacherResponse verifyTeacherResponse = verifyTeacherDatabaseService
                .isTeacher(new VerifyTeacherRequest(request.getTeacher()));

        if (!verifyTeacherResponse.isTeacherExists()) {
            errors.add(new CoreError("Teacher", "object not exists"));
            return new UpdateTeacherResponse(errors);
        }

        TeacherFieldResponse response = addTeacherService
                .addTeacher(new TeacherFieldRequest(request.getTeacher()));

        return new UpdateTeacherResponse(response.getErrors());
    }
}