package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
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
    @Mock
    private JpaCourseRepository courseRepository;
    @InjectMocks
    private UpdateCourseService updateCourseService;

    @Test
    public void courseNotExistsInDataBase() throws NoSuchFieldException, IllegalAccessException {
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
    public void courseUpdated() throws NoSuchFieldException, IllegalAccessException {
        Mockito.doReturn(new VerifyCourseResponse(true))
                .when(verifyCourseDatabaseService).isCourse(Mockito.any(VerifyCourseRequest.class));

        List<CoreError> errors = new ArrayList<>();
        Mockito.doReturn(new CourseFieldResponse(errors))
                .when(addCourseService).addCourse(Mockito.any(CourseFieldRequest.class));

        UpdateCourseResponse response = updateCourseService
                .updateCourse(new UpdateCourseRequest(new Course()));

        assertFalse(response.hasErrors());
        Mockito.verify(courseRepository,Mockito.times(1)).save(new Course());
    }

    @Test
    public void courseFieldsContainsErrors() throws NoSuchFieldException, IllegalAccessException {
        Mockito.doReturn(new VerifyCourseResponse(true))
                .when(verifyCourseDatabaseService).isCourse(Mockito.any(VerifyCourseRequest.class));

        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("name","must not be null"));
        errors.add(new CoreError("courseType","must not be null"));
        Mockito.doReturn(new CourseFieldResponse(errors))
                .when(addCourseService).addCourse(Mockito.any(CourseFieldRequest.class));

        UpdateCourseResponse response = updateCourseService
                .updateCourse(new UpdateCourseRequest(new Course()));

        assertTrue(response.hasErrors());
        assertEquals("name",response.getErrors().get(0).getField());
        assertEquals("must not be null",response.getErrors().get(0).getMessage());
        assertEquals("courseType",response.getErrors().get(1).getField());
        assertEquals("must not be null",response.getErrors().get(1).getMessage());
        Mockito.verify(courseRepository,Mockito.times(0)).save(new Course());
    }
}