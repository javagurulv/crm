package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.responses.GetAllTeachersResponse;
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
public class GetAllTeachersServiceTest {
    @Mock
    private JpaTeachersRepository teachersRepository;
    @InjectMocks
    private GetAllTeachersService getAllTeachersService;

    @Test
    public void test_No_Records() {
        Mockito.when(teachersRepository.findAll()).thenReturn(new ArrayList<>());
        GetAllTeachersResponse response = getAllTeachersService.execute();

        Mockito.verify(teachersRepository, Mockito.times(1)).findAll();
        assertEquals(0,response.getCourseList().size());
    }

    @Test
    public void test_Return_Record() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Name");
        teacher.setSecondName("Second Name");

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher);

        Mockito.when(teachersRepository.findAll()).thenReturn(teacherList);
        GetAllTeachersResponse response = getAllTeachersService.execute();

        Mockito.verify(teachersRepository, Mockito.times(1)).findAll();
        assertEquals(1,response.getCourseList().size());
    }
}