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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AddCourseServiceTest {
    @Mock
    private JpaCourseRepository courseRepository;
    @InjectMocks
    private AddCourseService addCourseService;

    @Test
    public void test_Errors_NoSave() throws IllegalAccessException, NoSuchFieldException {
        CourseFieldResponse serviceResponse = addCourseService
                .addCourse(new CourseFieldRequest(new Course()));

        Mockito.verify(courseRepository, Mockito.times(0)).save(new Course());

        assertTrue(serviceResponse.hasErrors());
    }

    @Test
    public void test_NoErrors_Save() throws IllegalAccessException, NoSuchFieldException, ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm");

        Course course = new Course();
        course.setName("Name");
        course.setCourseType("JAVA_1");
        Date startDate = dateFormatter.parse("22/03/2021");
        course.setStartDate(startDate);
        Date endDate = dateFormatter.parse("22/08/2021");
        course.setEndDate(endDate);
        course.setDayOfWeek(DayOfWeek.Tuesday.toString());
        Date startTime = timeFormatter.parse("19:00");
        course.setStartTime(startTime);
        Date endTime = timeFormatter.parse("22:00");
        course.setEndTime(endTime);

        CourseFieldResponse serviceResponse = addCourseService
                .addCourse(new CourseFieldRequest(course));

        Mockito.verify(courseRepository, Mockito.times(1)).save(course);

        assertFalse(serviceResponse.hasErrors());
    }

    @Test
    public void test_CourseTypeEmptyError_NoSave() throws IllegalAccessException, NoSuchFieldException, ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm");

        Course course = new Course();
        course.setName("Name");
        course.setCourseType("");
        Date startDate = dateFormatter.parse("22/03/2021");
        course.setStartDate(startDate);
        Date endDate = dateFormatter.parse("22/08/2021");
        course.setEndDate(endDate);
        course.setDayOfWeek(DayOfWeek.Tuesday.toString());
        Date startTime = timeFormatter.parse("19:00");
        course.setStartTime(startTime);
        Date endTime = timeFormatter.parse("22:00");
        course.setEndTime(endTime);

        CourseFieldResponse serviceResponse = addCourseService
                .addCourse(new CourseFieldRequest(course));

        Mockito.verify(courseRepository, Mockito.times(0)).save(course);

        assertTrue(serviceResponse.hasErrors());
        assertEquals("courseType",serviceResponse.getErrors().get(0).getField());
        assertEquals("must not be empty",serviceResponse.getErrors().get(0).getMessage());
    }

    @Test
    public void test_CourseTypeNullError_NoSave() throws IllegalAccessException, NoSuchFieldException, ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm");

        Course course = new Course();
        course.setName("Name");
        Date startDate = dateFormatter.parse("22/03/2021");
        course.setStartDate(startDate);
        Date endDate = dateFormatter.parse("22/08/2021");
        course.setEndDate(endDate);
        course.setDayOfWeek(DayOfWeek.Tuesday.toString());
        Date startTime = timeFormatter.parse("19:00");
        course.setStartTime(startTime);
        Date endTime = timeFormatter.parse("22:00");
        course.setEndTime(endTime);

        CourseFieldResponse serviceResponse = addCourseService
                .addCourse(new CourseFieldRequest(course));

        Mockito.verify(courseRepository, Mockito.times(0)).save(course);

        assertTrue(serviceResponse.hasErrors());
        assertEquals("courseType",serviceResponse.getErrors().get(0).getField());
        assertEquals("must not be null",serviceResponse.getErrors().get(0).getMessage());
    }
}