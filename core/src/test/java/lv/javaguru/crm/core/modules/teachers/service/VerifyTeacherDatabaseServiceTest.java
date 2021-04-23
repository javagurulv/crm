package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.VerifyTeacherRequest;
import lv.javaguru.crm.core.modules.teachers.responses.VerifyTeacherResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class VerifyTeacherDatabaseServiceTest {
    @Mock
    private JpaTeachersRepository teachersRepository;
    @InjectMocks
    private VerifyTeacherDatabaseService verifyTeacherDatabaseService;

    @Test
    public void courseEqualNull() {
        VerifyTeacherResponse response = verifyTeacherDatabaseService.isTeacher(new VerifyTeacherRequest(null));
        assertFalse(response.isTeacherExists());
    }

    @Test
    public void courseNotExists() {
        Teacher teacher = new Teacher();
        teacher.setId(10L);

        Mockito.when(teachersRepository.existsById(10L)).thenReturn(false);
        VerifyTeacherResponse response = verifyTeacherDatabaseService.isTeacher(new VerifyTeacherRequest(teacher));
        assertFalse(response.isTeacherExists());
    }

    @Test
    public void courseExists() {
        Teacher teacher = new Teacher();
        teacher.setId(1L);

        Mockito.when(teachersRepository.existsById(1L)).thenReturn(true);
        VerifyTeacherResponse response = verifyTeacherDatabaseService.isTeacher(new VerifyTeacherRequest(teacher));
        assertTrue(response.isTeacherExists());
    }
}