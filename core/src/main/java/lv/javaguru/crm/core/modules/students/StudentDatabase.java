package lv.javaguru.crm.core.modules.students;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentDatabase extends JpaRepository<Student, Long> {

    // List<Student> findAll()
    List<Student> getCustomers();

    // deleted
    boolean addStudent(Student student);

    // void deleteById(Long id)
    boolean deleteStudentById(Long id);

    Optional<Student> findById(Long id);

    List<Student> searchAllByName(String name);

    List<Student> findStudentBySurname(String surname);

    List<Student> findStudentByPhone(String phoneNumber);

    List<Student> findStudentByEmail(String email);

    //
    List<Student> findStudentByAllCriterias(String searchRequest);

    //@Query ("UPDATE Student s set s. ?? =: new??? WHERE s.id = :id")
    // void updateStudent(@Param("id") Long id, @Param("new??") String new???);
    boolean updateStudent(Long id);
}
