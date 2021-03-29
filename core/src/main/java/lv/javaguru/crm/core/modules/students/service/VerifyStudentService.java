package lv.javaguru.crm.core.modules.students.service;


import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.VerifyStudentRequest;
import lv.javaguru.crm.core.modules.students.response.VerifyStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerifyStudentService {

    @Autowired
    private JpaStudentRepository repository;

    public VerifyStudentResponse isStudent(VerifyStudentRequest request){
        boolean studentExists = false;
        Student student = request.getStudent();
        if (student != null) {
            studentExists = repository.existsById(student.getId());
        }
        return new VerifyStudentResponse(studentExists);
    }
}
