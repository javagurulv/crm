package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.DeleteCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.DeleteCourseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCourseServiceTest {
    @Mock
    private JpaCourseRepository courseRepository;
    @InjectMocks
    private final DeleteCourseService deleteService = new DeleteCourseService();

    @Test
    public void delete_Error_Id_Null() {
        DeleteCourseResponse response = deleteService.deleteCourse(new DeleteCourseRequest(null));

        assertTrue(response.hasErrors());
        assertEquals("Course Id", response.getErrors().get(0).getField());
        assertEquals("Should not be empty", response.getErrors().get(0).getMessage());
    }

    @Test
    public void delete_Success() {
        DeleteCourseResponse response = deleteService.deleteCourse(new DeleteCourseRequest(1L));

        Mockito.verify(courseRepository, Mockito.times(1)).deleteCourseById(1L);

        assertFalse(response.hasErrors());
    }
}