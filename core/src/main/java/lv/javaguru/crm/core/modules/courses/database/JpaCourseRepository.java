package lv.javaguru.crm.core.modules.courses.database;

import lv.javaguru.crm.core.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCourseRepository extends JpaRepository<Course, Long> {

}
