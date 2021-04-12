package lv.javaguru.crm.core.modules.students.validators;

import lv.javaguru.crm.core.modules.core_error.CoreError;
import lv.javaguru.crm.core.modules.students.request.AddStudentRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddStudentValidator {

   /* private static final Pattern PATTERN_EMAIL = Pattern.compile("^([a-z0-9_\\.-]+)@([a-z0-9_\\.-]+)\\.([a-z\\.]{2,6})$", Pattern.CASE_INSENSITIVE);
    private static final Pattern PATTERN_PHONE_LV = Pattern.compile("^\\++\\d{8,11}$");
    private static final Pattern PATTERN_PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
*/
    public List<CoreError> validate (AddStudentRequest request) {
        List<CoreError> errors = new ArrayList<>();

        errors.addAll(nameValidationErrors(request.getStudent().getName()));
        errors.addAll(surnameValidationErrors(request.getStudent().getSurname()));
        errors.addAll(phoneValidationErrors(request.getStudent().getPhoneNumber()));
        errors.addAll(emailValidationErrors(request.getStudent().getEmail()));

        return errors;
    }

    private List<CoreError> nameValidationErrors(String name){
        List<CoreError> errors = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            errors.add(new CoreError("name", "This field can't be empty"));
        }
        if (!containsOnlyLetters(name)){
            errors.add(new CoreError("name", "Not valid input for name"));
        }
        return errors;
    }

    private List<CoreError> surnameValidationErrors(String name){
        List<CoreError> errors = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            errors.add(new CoreError("surname", "This field can't be empty"));
        }
        if (!containsOnlyLetters(name)){
            errors.add(new CoreError("surname", "Not valid input for surname"));
        }
        return errors;
    }

    private List<CoreError> phoneValidationErrors(String phoneNumber) {
        List<CoreError> errors = new ArrayList<>();
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            errors.add(new CoreError("phone number", "This field can't be empty"));
        }
        if (!numberContainsOnlyDigits(phoneNumber) || ((phoneNumber.length() != 8) && (phoneNumber.length() != 11))){
            errors.add(new CoreError("phone number", "Not valid input for phone number, should contain only 8 or 11 digits"));
        }
        return errors;
    }

    private List<CoreError> emailValidationErrors (String email) {
        List <CoreError> errors = new ArrayList<>();
        if (email == null || email.isEmpty()) {
            errors.add(new CoreError("email", "E-mail can't be empty"));
        } else
        if (notValidEmailFormat(email)) {
            errors.add(new CoreError("email", "Not valid e-mail format"));
        }
        return errors;
    }

    private boolean numberContainsOnlyDigits(String input){
        String regex = "[0-9]+";

        Pattern pattern = Pattern.compile(regex);
        if (input == null){
            return false;
        }
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private boolean notValidEmailFormat(String email) {
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        if (email == null){
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean containsOnlyLetters(String input){
        String regex = "[a-zA-Z]+";

        Pattern pattern = Pattern.compile(regex);
        if (input == null){
            return false;
        }
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
