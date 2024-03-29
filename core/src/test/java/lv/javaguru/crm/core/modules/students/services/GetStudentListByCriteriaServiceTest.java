package lv.javaguru.crm.core.modules.students.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.persistance.JpaStudentRepository;
import lv.javaguru.crm.core.modules.students.request.GetStudentListByCriteriaRequest;
import lv.javaguru.crm.core.modules.students.response.GetStudentListResponse;
import lv.javaguru.crm.core.modules.students.service.GetStudentListByCriteriaService;
import lv.javaguru.crm.core.modules.students.validators.GetStudentListByCriteriaValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class GetStudentListByCriteriaServiceTest {

    @Mock
    private JpaStudentRepository repository;
    @Mock
    private GetStudentListByCriteriaValidator validator;
    @InjectMocks
    private GetStudentListByCriteriaService service;

    @Test
    public void emptyStudentListTest() {

        GetStudentListByCriteriaRequest request = new GetStudentListByCriteriaRequest("");

        List<CoreError> errors = new ArrayList<>();
        CoreError expectedError = new CoreError("database", "There is no data for this criteria.");
        errors.add(expectedError);

        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        Mockito.when(repository.findAll("")).thenReturn(new ArrayList<>());

        GetStudentListResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().get(0).getMessage(), errors.get(0).getMessage());
        assertEquals(response.getErrors().get(0).getField(), errors.get(0).getField());

    }

    @Test
    public void successfullyReceivedStudentListTest() {

        Student firstStudent = new Student();
        firstStudent.setName("Jaroslav");
        firstStudent.setSurname("Brutaha");
        firstStudent.setEmail("jaroslav.brutan@gmail.com");
        firstStudent.setPhoneNumber("26926929");
        List<Student> students = new ArrayList<>();
        students.add(firstStudent);

        GetStudentListByCriteriaRequest request = new GetStudentListByCriteriaRequest("Jaroslav");
        Mockito.when(validator.validate(request)).thenReturn(new ArrayList<>());
        Mockito.when(repository.findAllStudentsByName(request.getStudentListRequest())).thenReturn(students);

        GetStudentListResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getStudentList().get(0).getName(), students.get(0).getName());
    }
}