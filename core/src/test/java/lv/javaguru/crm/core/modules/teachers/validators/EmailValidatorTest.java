package lv.javaguru.crm.core.modules.teachers.validators;

import lv.javaguru.crm.core.core_error.CoreError;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {
    private final EmailValidator emailValidator = new EmailValidator();

    @Test
    public void shouldReturnNoErrors() {
        CoreError errors = emailValidator.validate("alex@alex.lv");
        assertNull(errors);
    }

    @Test
    public void shouldReturnErrors_1() {
        CoreError errors = emailValidator.validate("alex@alex");
        assertEquals("Email input error", errors.getField());
        assertEquals("email unsupported format", errors.getMessage());
    }

    @Test
    public void shouldReturnErrors_2() {
        CoreError errors = emailValidator.validate("@alex");
        assertEquals("Email input error", errors.getField());
        assertEquals("email unsupported format", errors.getMessage());
    }

    @Test
    public void shouldReturnErrors_3() {
        CoreError errors = emailValidator.validate("alex@");
        assertEquals("Email input error", errors.getField());
        assertEquals("email unsupported format", errors.getMessage());
    }

    @Test
    public void shouldReturnErrors_4() {
        CoreError errors = emailValidator.validate("email");
        assertEquals("Email input error", errors.getField());
        assertEquals("email unsupported format", errors.getMessage());
    }
}