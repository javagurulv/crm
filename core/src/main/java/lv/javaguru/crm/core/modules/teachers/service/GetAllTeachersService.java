package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.responses.GetAllTeachersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetAllTeachersService {
    @Autowired
    private JpaTeachersRepository teachersRepository;

    public GetAllTeachersResponse execute() {
        List<Teacher> teachersList = teachersRepository.findAll();
        return new GetAllTeachersResponse(teachersList);
    }
}