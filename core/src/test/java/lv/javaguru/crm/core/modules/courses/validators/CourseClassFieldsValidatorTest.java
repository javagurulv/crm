package lv.javaguru.crm.core.modules.courses.validators;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.domain.DayOfWeek;
import lv.javaguru.crm.core.modules.courses.requests.CourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.responses.CourseFieldResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseClassFieldsValidatorTest {
    private final CourseClassFieldsValidator validator = new CourseClassFieldsValidator();

    @Test
    public void test_CourseClass_AllFieldsErrors() {
        CourseFieldResponse response = validator.validate(new CourseFieldRequest(new Course()));

        assertTrue(response.hasErrors());
        assertEquals(7, response.getErrors().size());
    }

    @Test
    public void test_NoFieldsErrors() {
        Course course = new Course();
        course.setTitle("Name");
        course.setCourseType("JAVA_1");
        course.setStartDate("22/03/2021");
        course.setEndDate("22/08/2021");
        course.setDayOfWeek(DayOfWeek.Tuesday);
        course.setStartTime("19:00");
        course.setEndTime("22:00");

        CourseFieldResponse response = validator.validate(new CourseFieldRequest(course));

        assertFalse(response.hasErrors());
        assertEquals(0, response.getErrors().size());
    }

    @Test
    public void test_NameEmptyFieldsErrors() {
        Course course = new Course();
        course.setTitle("");
        course.setCourseType("JAVA_1");
        course.setStartDate("22/03/2021");
        course.setEndDate("22/08/2021");
        course.setDayOfWeek(DayOfWeek.Tuesday);
        course.setStartTime("19:00");
        course.setEndTime("22:00");

        CourseFieldResponse response = validator.validate(new CourseFieldRequest(course));

        assertTrue(response.hasErrors());
        assertEquals(1, response.getErrors().size());
        assertEquals("Course", response.getErrors().get(0).getField());
        assertEquals("Field [Course title] may not be empty", response.getErrors().get(0).getMessage());
    }


    @Test
    public void test_EndDateNullFieldsErrors() {
        Course course = new Course();
        course.setTitle("Name");
        course.setCourseType("JAVA_1");
        course.setStartDate("22/03/2021");
        course.setDayOfWeek(DayOfWeek.Tuesday);
        course.setStartTime("19:00");
        course.setEndTime("22:00");

        CourseFieldResponse response = validator.validate(new CourseFieldRequest(course));

        assertTrue(response.hasErrors());
        assertEquals(1, response.getErrors().size());
        assertEquals("Course", response.getErrors().get(0).getField());
        assertEquals("Field [Course end date] may not be empty", response.getErrors().get(0).getMessage());
    }
}