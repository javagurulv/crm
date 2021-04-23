package lv.javaguru.crm.core.modules.teachers.service;

import lv.javaguru.crm.core.core_error.CoreError;
import lv.javaguru.crm.core.modules.teachers.persistence.JpaTeachersRepository;
import lv.javaguru.crm.core.modules.teachers.requests.TeacherFieldRequest;
import lv.javaguru.crm.core.modules.teachers.responses.TeacherFieldResponse;
import lv.javaguru.crm.core.modules.teachers.validators.EmailValidator;
import lv.javaguru.crm.core.modules.teachers.validators.PhoneNumberValidator;
import lv.javaguru.crm.core.modules.teachers.validators.TeacherClassFieldsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddTeacherService {
    @Autowired
    private JpaTeachersRepository teachersRepository;
    private TeacherFieldResponse teacherClassErrors;

    public TeacherFieldResponse addTeacher(TeacherFieldRequest request) {

        teacherClassErrors = new TeacherClassFieldsValidator().validate(
                new TeacherFieldRequest(request.getTeacher()));

        teacherEmailValidate(request.getTeacher().getEmail());

        teacherPhoneNumberValidate(request.getTeacher().getPhone());

        if (teacherClassErrors.getErrors().isEmpty()) {
            teachersRepository.save(request.getTeacher());
        }
        return teacherClassErrors;
    }

    private void teacherEmailValidate(String email) {
        EmailValidator emailValidator = new EmailValidator();
        CoreError emailError = emailValidator.validate(email);
        if (emailError != null) {
            teacherClassErrors.getErrors().add(emailError);
        }
    }

    private void teacherPhoneNumberValidate(String phoneNumber) {
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        CoreError phoneNumberError = phoneNumberValidator.validate(phoneNumber, "LV");
        if (phoneNumberError != null) {
            teacherClassErrors.getErrors().add(phoneNumberError);
        }
    }
}