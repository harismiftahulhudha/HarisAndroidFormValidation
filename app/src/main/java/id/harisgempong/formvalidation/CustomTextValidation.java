package id.harisgempong.formvalidation;

import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class CustomTextValidation implements TextValidation {
    @Override
    public String success(String name) {
        return null;
    }

    @Override
    public String maxError(String name, String value) {
        return null;
    }

    @Override
    public String minError(String name, String value) {
        return null;
    }

    @Override
    public String emailError(String input) {
        return null;
    }

    @Override
    public String maxLengthError(String name, String value) {
        return null;
    }

    @Override
    public String minLengthError(String name, String value) {
        return null;
    }

    @Override
    public String alphaError(String name) {
        return null;
    }

    @Override
    public String numericError(String name) {
        return null;
    }

    @Override
    public String alphaNumError(String name) {
        return null;
    }

    @Override
    public String booleanError(String name) {
        return null;
    }

    @Override
    public String errorNumberFormat(String name) {
        return null;
    }

    @Override
    public String errorRequired(String name) {
        return null;
    }

    @Override
    public String defaultValidation(String key) {
        return null;
    }
}
