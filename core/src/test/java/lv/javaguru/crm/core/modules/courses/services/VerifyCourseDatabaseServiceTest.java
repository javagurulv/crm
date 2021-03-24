package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.requests.VerifyCourseRequest;
import lv.javaguru.crm.core.modules.courses.responses.VerifyCourseResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class VerifyCourseDatabaseServiceTest {
    @Mock
    private JpaCourseRepository courseRepository;
    @InjectMocks
    private VerifyCourseDatabaseService verifyCourseDatabaseService;

    @Test
    public void courseEqualNull() {
        VerifyCourseResponse response = verifyCourseDatabaseService.isCourseExists(new VerifyCourseRequest(null));
        assertFalse(response.isCourseExists());
    }

    @Test
    public void courseNotExists() {
        Course course = new Course();
        course.setId(10L);

        Mockito.when(courseRepository.existsById(10L)).thenReturn(false);
        VerifyCourseResponse response = verifyCourseDatabaseService.isCourseExists(new VerifyCourseRequest(course));
        assertFalse(response.isCourseExists());
    }

    @Test
    public void courseExists() {
        Course course = new Course();
        course.setId(1L);

        Mockito.when(courseRepository.existsById(1L)).thenReturn(true);
        VerifyCourseResponse response = verifyCourseDatabaseService.isCourseExists(new VerifyCourseRequest(course));
        assertTrue(response.isCourseExists());
    }
}