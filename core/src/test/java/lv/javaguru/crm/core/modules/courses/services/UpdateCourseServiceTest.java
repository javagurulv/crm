package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.requests.CourseFieldRequest;
import lv.javaguru.crm.core.modules.courses.requests.UpdateCourseRequest;
import lv.javaguru.crm.core.modules.courses.requests.VerifyCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.CourseFieldResponse;
import lv.javaguru.crm.core.modules.courses.responses.UpdateCourseResponse;
import lv.javaguru.crm.core.modules.courses.responses.VerifyCourseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCourseServiceTest {
    @Mock
    private VerifyCourseDatabaseService verifyCourseDatabaseService;
    @Mock
    private AddCourseService addCourseService;
    @InjectMocks
    private UpdateCourseService updateCourseService;

    @Test
    public void courseNotExistsInDataBase() {
        Mockito.doReturn(new VerifyCourseResponse(false))
                .when(verifyCourseDatabaseService).isCourse(Mockito.any(VerifyCourseRequest.class));

        UpdateCourseResponse response = updateCourseService
                .updateCourse(new UpdateCourseRequest(new Course()));

        assertNull(response.getUpdatedCourse());
        assertTrue(response.hasErrors());
        assertEquals("Course", response.getErrors().get(0).getField());
        assertEquals("object not exists", response.getErrors().get(0).getMessage());
    }

    @Test
    public void courseUpdated() {
        Mockito.doReturn(new VerifyCourseResponse(true))
                .when(verifyCourseDatabaseService).isCourse(Mockito.any(VerifyCourseRequest.class));

        List<CoreError> errors = new ArrayList<>();
        Mockito.doReturn(new CourseFieldResponse(errors))
                .when(addCourseService).addCourse(Mockito.any(CourseFieldRequest.class));

        UpdateCourseResponse response = updateCourseService
                .updateCourse(new UpdateCourseRequest(new Course()));

        assertFalse(response.hasErrors());
    }

    @Test
    public void courseFieldsContainsErrors() {
        Mockito.doReturn(new VerifyCourseResponse(true))
                .when(verifyCourseDatabaseService).isCourse(Mockito.any(VerifyCourseRequest.class));

        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("Course", "Field [Course title] may not be empty"));
        errors.add(new CoreError("Course", "Field [Course type] may not be empty"));
        Mockito.doReturn(new CourseFieldResponse(errors))
                .when(addCourseService).addCourse(Mockito.any(CourseFieldRequest.class));

        UpdateCourseResponse response = updateCourseService
                .updateCourse(new UpdateCourseRequest(new Course()));

        assertTrue(response.hasErrors());
        assertEquals("Course", response.getErrors().get(0).getField());
        assertEquals("Field [Course title] may not be empty", response.getErrors().get(0).getMessage());
        assertEquals("Course", response.getErrors().get(1).getField());
        assertEquals("Field [Course type] may not be empty", response.getErrors().get(1).getMessage());
    }
}