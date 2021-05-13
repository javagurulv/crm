package lv.javaguru.crm.core.modules.students.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.UpdateStudentRequest;
import lv.javaguru.crm.core.modules.students.response.UpdateStudentResponse;
import lv.javaguru.crm.core.modules.students.service.UpdateStudentService;
import lv.javaguru.crm.core.modules.students.validators.UpdateStudentValidator;
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

public class UpdateStudentServiceTest {

    @Mock
    private JpaStudentRepository studentRepository;
    @Mock
    private UpdateStudentValidator updateStudentValidator;
    @InjectMocks
    UpdateStudentService updateStudentService;

    @Test
    public void updateSuccessfullyStudentNameRequestTest() {

        Student firstStudent = new Student();
        firstStudent.setName("Jaroslav");
        firstStudent.setSurname("Brutan");
        firstStudent.setEmail("jaroslav.brutan@gmail.com");
        firstStudent.setPhoneNumber("26926929");

        firstStudent.setName("Jaroslavchik");

        UpdateStudentRequest request1 = new UpdateStudentRequest(firstStudent);

        Mockito.when(updateStudentValidator.validate(request1)).thenReturn(new ArrayList<>());

        UpdateStudentResponse response = updateStudentService.execute(request1);
        assertEquals(response.hasErrors(), false);
        assertEquals("Jaroslavchik", firstStudent.getName());

        Mockito.verifyNoInteractions(studentRepository);
    }

    @Test
    public void notSuccessfullyUpdatedStudentNameRequestTest() {

        Student firstStudent = new Student();
        firstStudent.setName("Jaroslav");
        firstStudent.setSurname("Brutan");
        firstStudent.setEmail("jaroslav.brutan@gmail.com");
        firstStudent.setPhoneNumber("26926929");

        firstStudent.setName("");

        UpdateStudentRequest request1 = new UpdateStudentRequest(firstStudent);

        List<CoreError> errors1 = new ArrayList<>();
        errors1.add(new CoreError("name","This field can't be empty"));
        Mockito.when(updateStudentValidator.validate(request1)).thenReturn(errors1);


        UpdateStudentResponse response = updateStudentService.execute(request1);
        assertEquals(response.hasErrors(), true);
        assertEquals(response.getErrors().size(),1);
        assertEquals(response.getErrors().get(0).getField(),"name");

        Mockito.verifyNoInteractions(studentRepository);
    }
}