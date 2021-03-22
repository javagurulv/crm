package lv.javaguru.crm.core.modules.courses.validators;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.domain.DayOfWeek;
import lv.javaguru.crm.core.modules.courses.requests.AddCourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.responses.AddCourseFieldResponse;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class CourseClassFieldsValidatorTest {
    private final CourseClassFieldsValidator validator = new CourseClassFieldsValidator();

    @Test
    public void test_AllFieldsErrors() throws NoSuchFieldException, IllegalAccessException {
        AddCourseFieldResponse response = validator.validate(new AddCourseFieldRequest(new Course()));

        assertTrue(response.hasErrors());
        assertEquals(7, response.getErrors().size());
    }

    @Test
    public void test_NoFieldsErrors() throws ParseException, NoSuchFieldException, IllegalAccessException {
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

        AddCourseFieldResponse response = validator.validate(new AddCourseFieldRequest(course));

        assertFalse(response.hasErrors());
        assertEquals(0, response.getErrors().size());
    }

    @Test
    public void test_NameEmptyFieldsErrors() throws ParseException, NoSuchFieldException, IllegalAccessException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm");

        Course course = new Course();
        course.setName("");
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

        AddCourseFieldResponse response = validator.validate(new AddCourseFieldRequest(course));

        assertTrue(response.hasErrors());
        assertEquals(1, response.getErrors().size());
        assertEquals("name",response.getErrors().get(0).getField());
        assertEquals("must not be empty",response.getErrors().get(0).getMessage());
    }

    @Test
    public void test_NameNullFieldsErrors() throws ParseException, NoSuchFieldException, IllegalAccessException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm");

        Course course = new Course();
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

        AddCourseFieldResponse response = validator.validate(new AddCourseFieldRequest(course));

        assertTrue(response.hasErrors());
        assertEquals(1, response.getErrors().size());
        assertEquals("name",response.getErrors().get(0).getField());
        assertEquals("must not be null",response.getErrors().get(0).getMessage());
    }

    @Test
    public void test_EndDateNullFieldsErrors() throws ParseException, NoSuchFieldException, IllegalAccessException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm");

        Course course = new Course();
        course.setName("name");
        course.setCourseType("JAVA_1");
        Date startDate = dateFormatter.parse("22/03/2021");
        course.setStartDate(startDate);
        course.setDayOfWeek(DayOfWeek.Tuesday.toString());
        Date startTime = timeFormatter.parse("19:00");
        course.setStartTime(startTime);
        Date endTime = timeFormatter.parse("22:00");
        course.setEndTime(endTime);

        AddCourseFieldResponse response = validator.validate(new AddCourseFieldRequest(course));

        assertTrue(response.hasErrors());
        assertEquals(1, response.getErrors().size());
        assertEquals("endDate",response.getErrors().get(0).getField());
        assertEquals("must not be null",response.getErrors().get(0).getMessage());
    }
}