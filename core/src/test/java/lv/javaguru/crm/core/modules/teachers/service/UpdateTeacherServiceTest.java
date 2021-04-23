package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import lv.javaguru.crm.core.modules.teachers.requests.TeacherFieldRequest;
import lv.javaguru.crm.core.modules.teachers.requests.UpdateTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.requests.VerifyTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.TeacherFieldResponse;
import lv.javaguru.crm.core.modules.teachers.responses.UpdateTeacherResponse;
import lv.javaguru.crm.core.modules.teachers.responses.VerifyTeacherResponse;
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
public class UpdateTeacherServiceTest {
    @Mock
    private VerifyTeacherDatabaseService verifyTeacherDatabaseService;
    @Mock
    private AddTeacherService addTeacherService;
    @InjectMocks
    private UpdateTeacherService updateTeacherService;

    @Test
    public void courseNotExistsInDataBase() {
        Mockito.doReturn(new VerifyTeacherResponse(false))
                .when(verifyTeacherDatabaseService).isTeacher(Mockito.any(VerifyTeacherRequest.class));

        UpdateTeacherResponse response = updateTeacherService
                .updateTeacher(new UpdateTeacherRequest(new Teacher()));

        assertNull(response.getUpdatedTeacher());
        assertTrue(response.hasErrors());
        assertEquals("Teacher", response.getErrors().get(0).getField());
        assertEquals("object not exists", response.getErrors().get(0).getMessage());
    }

    @Test
    public void courseUpdated() {
        Mockito.doReturn(new VerifyTeacherResponse(true))
                .when(verifyTeacherDatabaseService).isTeacher(Mockito.any(VerifyTeacherRequest.class));

        List<CoreError> errors = new ArrayList<>();
        Mockito.doReturn(new TeacherFieldResponse(errors))
                .when(addTeacherService).addTeacher(Mockito.any(TeacherFieldRequest.class));

        UpdateTeacherResponse response = updateTeacherService
                .updateTeacher(new UpdateTeacherRequest(new Teacher()));

        assertFalse(response.hasErrors());
    }

    @Test
    public void courseFieldsContainsErrors() {
        Mockito.doReturn(new VerifyTeacherResponse(true))
                .when(verifyTeacherDatabaseService).isTeacher(Mockito.any(VerifyTeacherRequest.class));

        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Teacher", "Field [Teacher first_name] may not be empty"));
        errors.add(new CoreError("Teacher", "Field [Teacher last_name] may not be empty"));
        Mockito.doReturn(new TeacherFieldResponse(errors))
                .when(addTeacherService).addTeacher(Mockito.any(TeacherFieldRequest.class));

        UpdateTeacherResponse response = updateTeacherService
                .updateTeacher(new UpdateTeacherRequest(new Teacher()));

        assertTrue(response.hasErrors());
        assertEquals("Teacher", response.getErrors().get(0).getField());
        assertEquals("Field [Teacher first_name] may not be empty", response.getErrors().get(0).getMessage());
        assertEquals("Teacher", response.getErrors().get(1).getField());
        assertEquals("Field [Teacher last_name] may not be empty", response.getErrors().get(1).getMessage());
    }
}