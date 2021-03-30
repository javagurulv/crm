package lv.javaguru.crm.core.modules.students.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.AddStudentRequest;
import lv.javaguru.crm.core.modules.students.response.AddStudentResponse;
import lv.javaguru.crm.core.modules.students.service.AddStudentService;
import lv.javaguru.crm.core.modules.students.validators.AddStudentValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class AddStudentServiceTest {

        @Mock
        private JpaStudentRepository studentRepository;
        @Mock private AddStudentValidator addStudentValidator;
        @InjectMocks
        AddStudentService addStudentService;

        @Test
        public void noNameAddedToStudentRequestTest() {

            Student firstStudent = new Student();
            firstStudent.setName("");
            firstStudent.setSurname("Brutan");
            firstStudent.setEmail("jaroslav.brutan@gmail.com");
            firstStudent.setPhoneNumber("26926929");

            AddStudentRequest request1 = new AddStudentRequest(firstStudent);

            List<CoreError> errors1 = new ArrayList<>();
            errors1.add(new CoreError("name","This field can't be empty"));
            Mockito.when(addStudentValidator.validate(request1)).thenReturn(errors1);

            AddStudentResponse response = addStudentService.execute(request1);
            assertEquals(response.hasErrors(),true);
            assertEquals(response.getErrors().size(),1);
            assertEquals(response.getErrors().get(0).getField(),"name");

            Mockito.verifyNoInteractions(studentRepository);
        }

    @Test
    public void noSurnameAddedToStudentRequestTest() {

        Student firstStudent = new Student();
        firstStudent.setName("Jaroslav");
        firstStudent.setSurname("");
        firstStudent.setEmail("jaroslav.brutan@gmail.com");
        firstStudent.setPhoneNumber("26926929");

        AddStudentRequest request1 = new AddStudentRequest(firstStudent);

        List<CoreError> errors1 = new ArrayList<>();
        errors1.add(new CoreError("surname","This field can't be empty"));
        Mockito.when(addStudentValidator.validate(request1)).thenReturn(errors1);

        AddStudentResponse response = addStudentService.execute(request1);
        assertEquals(response.hasErrors(),true);
        assertEquals(response.getErrors().size(),1);
        assertEquals(response.getErrors().get(0).getField(),"surname");

        Mockito.verifyNoInteractions(studentRepository);
    }

    @Test
    public void noMailAddedToStudentRequestTest() {

        Student firstStudent = new Student();
        firstStudent.setName("Jaroslav");
        firstStudent.setSurname("Brutan");
        firstStudent.setEmail("");
        firstStudent.setPhoneNumber("26926929");

        AddStudentRequest request1 = new AddStudentRequest(firstStudent);

        List<CoreError> errors1 = new ArrayList<>();
        errors1.add(new CoreError("email","This field can't be empty"));
        Mockito.when(addStudentValidator.validate(request1)).thenReturn(errors1);

        AddStudentResponse response = addStudentService.execute(request1);
        assertEquals(response.hasErrors(),true);
        assertEquals(response.getErrors().size(),1);
        assertEquals(response.getErrors().get(0).getField(),"email");

        Mockito.verifyNoInteractions(studentRepository);
    }

}
