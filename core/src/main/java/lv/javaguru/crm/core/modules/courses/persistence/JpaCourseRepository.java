package lv.javaguru.crm.core.modules.courses.persistence;

import lv.javaguru.crm.core.modules.courses.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends JpaRepository<Course, Long> {

    Long deleteCourseById(Long id);

}