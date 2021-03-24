package lv.javaguru.crm.core.modules.courses.services;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import lv.javaguru.crm.core.modules.courses.persistence.JpaCourseRepository;
import lv.javaguru.crm.core.modules.courses.responses.GetAllCoursesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetAllCoursesService {
    @Autowired
    private JpaCourseRepository courseRepository;

    public GetAllCoursesResponse execute() {
        List<Course> courseList = courseRepository.findAll();
        return new GetAllCoursesResponse(courseList);
    }
}