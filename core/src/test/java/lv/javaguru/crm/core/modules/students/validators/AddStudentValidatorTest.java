package lv.javaguru.crm.core.modules.students.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.domain.Student;
import lv.javaguru.crm.core.modules.students.request.AddStudentRequest;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class AddStudentValidatorTest {

    AddStudentValidator addStudentValidator = new AddStudentValidator();

    @Test
    public void noNameAddedToStudentRequestTest() {

        Student firstStudent = new Student();
        firstStudent.setName("");
        firstStudent.setSurname("Brutan");
        firstStudent.setEmail("jaroslav.brutan@gmail.com");
        firstStudent.setPhoneNumber("26926929");

        AddStudentRequest request1 = new AddStudentRequest(firstStudent);
        CoreError expectedError = new CoreError("name", "This field can't be empty");
        List<CoreError> errors = addStudentValidator.validate(request1);

        assertTrue(errors.size() == 1);
        assertTrue(errors.contains(expectedError));
        }

    @Test
    public void noSurnameAddedToStudentRequestTest() {

        Student firstStudent = new Student();
        firstStudent.setName("Jaroslav");
        firstStudent.setSurname("");
        firstStudent.setEmail("jaroslav.brutan@gmail.com");
        firstStudent.setPhoneNumber("26926929");

        AddStudentRequest request1 = new AddStudentRequest(firstStudent);
        CoreError expectedError = new CoreError("name", "This field can't be empty");
        List<CoreError> errors = addStudentValidator.validate(request1);

        assertTrue(errors.size() == 1);
        assertTrue(errors.contains(expectedError));
    }
    }
