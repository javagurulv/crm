package lv.javaguru.crm.core.modules.teachers.validators;

import lv.javaguru.crm.core.core_error.CoreError;
import org.junit.Test;

import static org.junit.Assert.*;

public class PhoneNumberValidatorTest {
    private final PhoneNumberValidator phoneValidator = new PhoneNumberValidator();

    @Test
    public void checkPhoneNumberFormat_1() {
        CoreError result = phoneValidator.validate("24897411", "LV");
        assertNull(result);
    }

    @Test
    public void checkPhoneNumberFormat_2() {
        CoreError result = phoneValidator.validate("+37124897411", "LV");
        assertNull(result);
    }

    @Test
    public void checkPhoneNumberFormat_3_UnsupportedFormat() {
        CoreError result = phoneValidator.validate("+37224897411", "LV");
        assertEquals("phone number unsupported format", result.getMessage());
    }

    @Test
    public void checkPhoneNumberFormat_4_UnsupportedFormat() {
        CoreError result = phoneValidator.validate("54897411", "LV");
        assertEquals("phone number unsupported format", result.getMessage());
    }

    @Test
    public void checkPhoneNumberFormat_5_UnsupportedFormat() {
        CoreError result = phoneValidator.validate("phone_number", "LV");
        assertEquals("phone number unsupported format", result.getMessage());
    }

    @Test
    public void checkPhoneNumberFormat_6_UnsupportedFormat() {
        CoreError result = phoneValidator.validate("5489741188", "LV");
        assertEquals("phone number unsupported format", result.getMessage());
    }

    @Test
    public void checkPhoneNumberFormat_7_UnsupportedFormat() {
        CoreError result = phoneValidator.validate("54897", "LV");
        assertEquals("phone number unsupported format", result.getMessage());
    }
}