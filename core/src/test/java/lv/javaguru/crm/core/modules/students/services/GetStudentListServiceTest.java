package lv.javaguru.crm.core.modules.students.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.GetStudentListRequest;
import lv.javaguru.crm.core.modules.students.response.GetStudentListResponse;
import lv.javaguru.crm.core.modules.students.service.GetStudentListService;
import lv.javaguru.crm.core.modules.students.validators.GetStudentListValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)

public class GetStudentListServiceTest {

    @Mock
    private JpaStudentRepository studentRepository;
    @Mock
    private GetStudentListValidator getStudentListValidator;
    @InjectMocks
    GetStudentListService getStudentListService;

    @Test
    public void emptyStudentListTest() {

        GetStudentListRequest request1 = new GetStudentListRequest();

        List<CoreError> errors1 = new ArrayList<>();
        CoreError expectedError = new CoreError("list", "Student list is empty");
        errors1.add(expectedError);
        Mockito.when(getStudentListValidator.validate(request1)).thenReturn(new ArrayList<>());
        Mockito.when(studentRepository.findAll()).thenReturn(new ArrayList<>());

        GetStudentListResponse response = getStudentListService.execute(request1);
        assertEquals(response.hasErrors(), true);
    }

    @Test
    public void successfullyReceivedStudentListTest() {
        Student firstStudent = new Student();
        firstStudent.setName("Jaroslav");
        firstStudent.setSurname("Brutaha");
        firstStudent.setEmail("jaroslav.brutan@gmail.com");
        firstStudent.setPhoneNumber("26926929");
        List<Student> students = new ArrayList<>();

        studentRepository.save(firstStudent);

        GetStudentListRequest request1 = new GetStudentListRequest();

        Mockito.when(getStudentListValidator.validate(request1)).thenReturn(new ArrayList<>());
        Mockito.when(studentRepository.findAll()).thenReturn(students);

        GetStudentListResponse response = getStudentListService.execute(request1);
        assertTrue(response.getStudentList().equals(students));
    }
}
