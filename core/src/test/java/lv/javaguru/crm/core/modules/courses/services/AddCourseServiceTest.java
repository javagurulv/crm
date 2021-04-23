package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.domain.DayOfWeek;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.CourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.responses.CourseFieldResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddCourseServiceTest {
    @Mock
    private JpaCourseRepository courseRepository;
    @InjectMocks
    private AddCourseService addCourseService;

    @Test
    public void test_Errors_NoSave() {
        CourseFieldResponse serviceResponse = addCourseService
                .addCourse(new CourseFieldRequest(new Course()));

        Mockito.verify(courseRepository, Mockito.times(0)).save(new Course());

        assertTrue(serviceResponse.hasErrors());
    }

    @Test
    public void test_NoErrors_Save() {
        Course course = new Course();
        course.setTitle("Name");
        course.setCourseType("JAVA_1");
        course.setStartDate("22/03/2021");
        course.setEndDate("22/08/2021");
        course.setDayOfWeek(DayOfWeek.Tuesday);
        course.setStartTime("19:00");
        course.setEndTime("22:00");

        CourseFieldResponse serviceResponse = addCourseService
                .addCourse(new CourseFieldRequest(course));

        Mockito.verify(courseRepository, Mockito.times(1)).save(course);

        assertFalse(serviceResponse.hasErrors());
    }

    @Test
    public void test_CourseTypeEmptyError_NoSave() {
        Course course = new Course();
        course.setTitle("Name");
        course.setCourseType("");
        course.setStartDate("22/03/2021");
        course.setEndDate("22/08/2021");
        course.setDayOfWeek(DayOfWeek.Tuesday);
        course.setStartTime("19:00");
        course.setEndTime("22:00");

        CourseFieldResponse serviceResponse = addCourseService
                .addCourse(new CourseFieldRequest(course));

        Mockito.verify(courseRepository, Mockito.times(0)).save(course);

        assertTrue(serviceResponse.hasErrors());
        assertEquals("Course", serviceResponse.getErrors().get(0).getField());
        assertEquals("Field [Course type] may not be empty", serviceResponse.getErrors().get(0).getMessage());
    }

    @Test
    public void test_CourseTypeNullError_NoSave() {
        Course course = new Course();
        course.setTitle("Name");
        course.setStartDate("22/03/2021");
        course.setEndDate("22/08/2021");
        course.setDayOfWeek(DayOfWeek.Tuesday);
        course.setStartTime("19:00");
        course.setEndTime("22:00");

        CourseFieldResponse serviceResponse = addCourseService
                .addCourse(new CourseFieldRequest(course));

        Mockito.verify(courseRepository, Mockito.times(0)).save(course);

        assertTrue(serviceResponse.hasErrors());
        assertEquals("Course", serviceResponse.getErrors().get(0).getField());
        assertEquals("Field [Course type] may not be empty", serviceResponse.getErrors().get(0).getMessage());
    }
}