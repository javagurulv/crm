package lv.javaguru.crm.core.modules.students.service;


import lv.javaguru.crm.core.modules.students.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.AddStudentRequest;
import lv.javaguru.crm.core.modules.students.response.AddStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddStudentService {

    @Autowired
    private JpaStudentRepository studentRepository;
}
