package id.harisgempong.harisformvalidation.interfaces;

public interface TextValidation {
    String maxError(String name, String value);
    String minError(String name, String value);
    String greaterError(String name, String value);
    String lessError(String name, String value);
    String positiveError(String name);
    String negativeError(String name);
    String emailError(String input);
    String maxLengthError(String name, String value);
    String minLengthError(String name, String value);
    String stringError(String name);
    String alphaError(String name);
    String numericError(String name);
    String alphaNumError(String name);
    String booleanError(String name);
    String trooError(String name);
    String folsError(String name);
    String errorNumberFormat(String name);
    String errorRequired(String name);
    String tokenError(String name);
    String urlError(String name);
    String hexError(String name);
    String lowercaseError(String name);
    String uppercaseError(String name);
    String dateError(String name);
    String valueRequiredError();
    String dateValueError();
    String betweenError(String name, String value1, String value2);
}
