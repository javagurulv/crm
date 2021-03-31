package lv.javaguru.crm.core.modules.students.matchers;

import lv.javaguru.crm.core.modules.students.domain.Student;
import org.mockito.ArgumentMatcher;

public class StudentMatcher implements ArgumentMatcher<Student> {

        private final String name;
        private final String surname;
        private final String phoneNumber;
        private final String email;

        public StudentMatcher(String name, String surname, String phoneNumber, String email) {
            this.name = name;
            this.surname = surname;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        @Override
        public boolean matches(Student student) {
            return student.getName().equals(name) &&
                    student.getSurname().equals(surname) &&
                    student.getPhoneNumber().equals(phoneNumber) &&
                    student.getEmail() == email;
        }
    }

