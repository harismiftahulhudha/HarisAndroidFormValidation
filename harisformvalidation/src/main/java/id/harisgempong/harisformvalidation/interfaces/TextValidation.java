package id.harisgempong.harisformvalidation.interfaces;

public interface TextValidation {
    String success(String name);
    String maxError(String name, String value);
    String minError(String name, String value);
    String emailError(String input);
    String maxLengthError(String name, String value);
    String minLengthError(String name, String value);
    String alphaError(String name);
    String numericError(String name);
    String alphaNumError(String name);
    String booleanError(String name);
    String errorNumberFormat(String name);
    String errorRequired(String name);
    String defaultValidation(String key);
}
