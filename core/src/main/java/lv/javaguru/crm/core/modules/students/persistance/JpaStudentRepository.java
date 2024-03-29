package lv.javaguru.crm.core.modules.students.persistance;

import lv.javaguru.crm.core.modules.students.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaStudentRepository extends JpaRepository<Student, Long> {

    void deleteById(Long id);

    List <Student> findAll();

    //@Query ....... like ("UPDATE Student s set s. ?? =: new??? WHERE s.id = :id")
    List <Student> findAll(String searchRequest);   // Iterable<T> findAll(Predicate); criteriaBuilder.or()

    Optional<Student> findById(Long id);

    List<Student> findAllStudentsByName(String name);

    List<Student> findAllStudentBySurname(String surname);

    List<Student> findAllStudentByPhone(String phoneNumber);

    List<Student> findAllStudentByEmail(String email);

    boolean exists(Student student);

    //@Query ("UPDATE Student s set s. ?? =: new??? WHERE s.id = :id")
    // void updateStudent(@Param("id") Long id, @Param("new??") String new???);
    boolean updateStudent(Long id);

}
