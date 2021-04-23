package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.responses.GetAllCoursesResponse;
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
public class GetAllCoursesServiceTest {
    @Mock
    private JpaCourseRepository courseRepository;
    @InjectMocks
    private GetAllCoursesService getAllCoursesService;

    @Test
    public void test_No_Records() {
        Mockito.when(courseRepository.findAll()).thenReturn(new ArrayList<>());
        GetAllCoursesResponse response = getAllCoursesService.execute();

        Mockito.verify(courseRepository, Mockito.times(1)).findAll();
        assertEquals(0, response.getCourseList().size());
    }

    @Test
    public void test_Return_Record() {
        Course course = new Course();
        course.setTitle("Java");
        course.setCourseType("Java 1");

        List<Course> courseList = new ArrayList<>();
        courseList.add(course);

        Mockito.when(courseRepository.findAll()).thenReturn(courseList);
        GetAllCoursesResponse response = getAllCoursesService.execute();

        Mockito.verify(courseRepository, Mockito.times(1)).findAll();
        assertEquals(1, response.getCourseList().size());
    }
}