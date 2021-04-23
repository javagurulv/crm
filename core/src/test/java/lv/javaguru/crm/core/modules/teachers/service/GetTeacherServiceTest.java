package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.GetTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.GetTeacherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GetTeacherServiceTest {
    @Mock
    private JpaTeachersRepository teachersRepository;
    @InjectMocks
    private GetTeacherService getTeacherService;

    @Test
    public void testNoCourseFoundById() {

        Mockito.when(teachersRepository.findById(1L)).thenReturn(Optional.empty());

        GetTeacherResponse response = getTeacherService.getTeacherById(new GetTeacherRequest(1L));

        assertTrue(response.hasErrors());

        assertEquals("id", response.getErrors().get(0).getField());
        assertEquals("not found", response.getErrors().get(0).getMessage());
    }

    @Test
    public void testCourseFoundedById() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Name");
        teacher.setSecondName("Second Name");

        Mockito.when(teachersRepository.findById(1L)).thenReturn(Optional.of(teacher));

        GetTeacherResponse response = getTeacherService.getTeacherById(new GetTeacherRequest(1L));

        assertFalse(response.hasErrors());

        assertEquals("Name", response.getTeacher().getFirstName());
        assertEquals("Second Name", response.getTeacher().getSecondName());
    }
}