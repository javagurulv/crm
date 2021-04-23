package lv.javaguru.crm.core.modules.teachers.validators;

import lv.javaguru.crm.core.core_error.CoreError;

public class EmailValidator {
    public CoreError validate(String email) {
        CoreError errors = null;

        boolean emailValidate = org.apache.commons.validator.routines.EmailValidator.getInstance().isValid(email);

        if (!(emailValidate)) {
            errors = new CoreError("Email input error", "email unsupported format");
        }
        return errors;
    }
}