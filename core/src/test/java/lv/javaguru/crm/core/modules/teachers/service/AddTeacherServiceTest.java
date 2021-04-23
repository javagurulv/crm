package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.TeacherFieldRequest;
import lv.javaguru.crm.core.modules.teachers.responses.TeacherFieldResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddTeacherServiceTest {
    @Mock
    private JpaTeachersRepository teachersRepository;
    @InjectMocks
    private AddTeacherService addTeacherService;

    @Test
    public void test_AllErrors_NoSave() {
        TeacherFieldResponse serviceResponse = addTeacherService
                .addTeacher(new TeacherFieldRequest(new Teacher()));

        Mockito.verify(teachersRepository, Mockito.times(0)).save(new Teacher());

        assertTrue(serviceResponse.hasErrors());
    }

    @Test
    public void test_last_name_Error() {
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirstName("Name");
        teacher.setPhone("29123456");
        teacher.setEmail("a@a.lv");

        TeacherFieldResponse serviceResponse = addTeacherService
                .addTeacher(new TeacherFieldRequest(teacher));
        Mockito.verify(teachersRepository, Mockito.times(0)).save(teacher);

        assertTrue(serviceResponse.hasErrors());
        assertEquals("Field [Teacher second_name] may not be empty",
                serviceResponse.getErrors().get(0).getMessage());
    }

    @Test
    public void test_last_name_Empty_Error() {
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirstName("Name");
        teacher.setSecondName("");
        teacher.setPhone("29123456");
        teacher.setEmail("a@a.lv");

        TeacherFieldResponse serviceResponse = addTeacherService
                .addTeacher(new TeacherFieldRequest(teacher));
        Mockito.verify(teachersRepository, Mockito.times(0)).save(teacher);

        assertTrue(serviceResponse.hasErrors());
        assertEquals("Field [Teacher second_name] may not be empty",
                serviceResponse.getErrors().get(0).getMessage());
    }

    @Test
    public void test_email_Error() {
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirstName("Name");
        teacher.setSecondName("Second Name");
        teacher.setPhone("29123456");
        teacher.setEmail("@a.lv");

        TeacherFieldResponse serviceResponse = addTeacherService
                .addTeacher(new TeacherFieldRequest(teacher));
        Mockito.verify(teachersRepository, Mockito.times(0)).save(teacher);

        assertTrue(serviceResponse.hasErrors());
        assertEquals(1, serviceResponse.getErrors().size());
        assertEquals("email unsupported format",
                serviceResponse.getErrors().get(0).getMessage());
    }

    @Test
    public void test_phone_number_Error() {
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setFirstName("Name");
        teacher.setSecondName("Second Name");
        teacher.setPhone("2912345");
        teacher.setEmail("a@a.lv");

        TeacherFieldResponse serviceResponse = addTeacherService
                .addTeacher(new TeacherFieldRequest(teacher));
        Mockito.verify(teachersRepository, Mockito.times(0)).save(teacher);

        assertTrue(serviceResponse.hasErrors());
        assertEquals(1, serviceResponse.getErrors().size());
        assertEquals("phone number unsupported format",
                serviceResponse.getErrors().get(0).getMessage());
    }
}