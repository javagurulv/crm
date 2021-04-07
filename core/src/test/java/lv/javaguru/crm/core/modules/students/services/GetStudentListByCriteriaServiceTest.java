package lv.javaguru.crm.core.modules.students.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
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
        assertEquals(response.hasErrors(), true);

    }
}