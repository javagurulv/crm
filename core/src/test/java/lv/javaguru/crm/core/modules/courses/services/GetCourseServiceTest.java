package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.GetCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.GetCourseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GetCourseServiceTest {
    @Mock
    private JpaCourseRepository courseRepository;
    @InjectMocks
    private GetCourseService getCourseService;

    @Test
    public void testNoCourseFoundById() {

        Mockito.when(courseRepository.findById(1L)).thenReturn(Optional.empty());

        GetCourseResponse response = getCourseService.getCourseById(new GetCourseRequest(1L));

        assertTrue(response.hasErrors());

        assertEquals("id", response.getErrors().get(0).getField());
        assertEquals("not found", response.getErrors().get(0).getMessage());
    }

    @Test
    public void testCourseFoundedById() {
        Course course = new Course();
        course.setTitle("Course");
        course.setCourseType("Java 1");

        Mockito.when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        GetCourseResponse response = getCourseService.getCourseById(new GetCourseRequest(1L));

        assertFalse(response.hasErrors());

        assertEquals("Course", response.getCourse().getTitle());
        assertEquals("Java 1", response.getCourse().getCourseType());
    }
}