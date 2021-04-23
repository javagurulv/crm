package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.DeleteTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.DeleteTeacherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteTeacherServiceTest {
    @Mock
    private JpaTeachersRepository teachersRepository;
    @InjectMocks
    private final DeleteTeacherService deleteService = new DeleteTeacherService();

    @Test
    public void delete_Error_Id_Null() {
        DeleteTeacherResponse response = deleteService.deleteTeacher(new DeleteTeacherRequest(null));

        assertTrue(response.hasErrors());
        assertEquals("Teacher Id", response.getErrors().get(0).getField());
        assertEquals("Should not be empty", response.getErrors().get(0).getMessage());
    }

    @Test
    public void delete_Success() {
        DeleteTeacherResponse response = deleteService.deleteTeacher(new DeleteTeacherRequest(1L));

        Mockito.verify(teachersRepository, Mockito.times(1)).deleteTeacherById(1L);

        assertFalse(response.hasErrors());
    }



}