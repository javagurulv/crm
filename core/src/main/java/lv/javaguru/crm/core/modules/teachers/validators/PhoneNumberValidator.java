package lv.javaguru.crm.core.modules.teachers.validators;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import lv.javaguru.crm.core.core_error.CoreError;

public class PhoneNumberValidator {
    public CoreError validate(String phoneNumber, String region) {
        CoreError errors = null;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        boolean phoneNumberValidate = false;

        try {
            Phonenumber.PhoneNumber thePhoneNumber = phoneUtil.parse(phoneNumber, region);
            phoneNumberValidate = phoneUtil.isValidNumber(thePhoneNumber);
        } catch (NumberParseException e) {
            errors = new CoreError("Phone number input error", "phone number input error");
        }

        if (!(phoneNumberValidate)) {
            errors = new CoreError("Phone number input error", "phone number unsupported format");
        }
        return errors;
    }
}
