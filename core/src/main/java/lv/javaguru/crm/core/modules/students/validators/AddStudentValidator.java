package lv.javaguru.crm.core.modules.students.validators;

import java.util.regex.Pattern;

public class AddStudentValidator {

    private static final Pattern PATTERN_EMAIL = Pattern.compile("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_PHONE_LV = Pattern.compile("^\\++\\d{8,11}$");
    private static final Pattern PATTERN_PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");

}
