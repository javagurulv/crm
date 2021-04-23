package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.DeleteTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.DeleteTeacherResponse;
import lv.javaguru.crm.core.modules.teachers.validators.TeacherIdValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteTeacherService {
    @Autowired
    private JpaTeachersRepository teachersRepository;

    public DeleteTeacherResponse deleteTeacher(DeleteTeacherRequest teacherIdRequest) {
        DeleteTeacherResponse errors = new TeacherIdValidator().validate(teacherIdRequest);
        Long id = teacherIdRequest.getTeacherId();

        if (errors.getErrors().isEmpty()) {
            teachersRepository.deleteTeacherById(id);
        }
        return errors;
    }
}