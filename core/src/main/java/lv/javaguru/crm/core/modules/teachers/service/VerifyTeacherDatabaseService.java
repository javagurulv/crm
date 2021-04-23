package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.VerifyTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.VerifyTeacherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerifyTeacherDatabaseService {
    @Autowired
    private JpaTeachersRepository teachersRepository;

    public VerifyTeacherResponse isTeacher(VerifyTeacherRequest request) {
        boolean courseExits = false;
        Teacher teacher = request.getTeacher();
        if (teacher != null) {
            courseExits = teachersRepository.existsById(teacher.getId());
        }
        return new VerifyTeacherResponse(courseExits);
    }
}