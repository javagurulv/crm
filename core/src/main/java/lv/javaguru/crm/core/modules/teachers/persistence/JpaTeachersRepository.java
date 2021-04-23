package lv.javaguru.crm.core.modules.teachers.persistence;

import lv.javaguru.crm.core.modules.teachers.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTeachersRepository extends JpaRepository<Teacher, Long> {

    void deleteTeacherById(Long id);

}