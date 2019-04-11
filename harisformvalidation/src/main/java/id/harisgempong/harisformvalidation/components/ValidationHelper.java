package id.harisgempong.harisformvalidation.components;

import id.harisgempong.harisformvalidation.interfaces.TextValidation;
import id.harisgempong.harisformvalidation.model.BooleanValidation;
import id.harisgempong.harisformvalidation.model.DateValidation;
import id.harisgempong.harisformvalidation.model.NewRequest;
import id.harisgempong.harisformvalidation.model.NumberValidation;
import id.harisgempong.harisformvalidation.model.StringValidation;

public class ValidationHelper {

    private final NewRequest request;
    private final TextValidation textValidation;
    protected ValidationHelper(NewRequest request, TextValidation textValidation) {
        this.request = request;
        this.textValidation = textValidation;
    }
    protected void getErrorNumberValidation(NumberValidation.NumberEnum numberEnum, String name) {
        switch (numberEnum) {
            case ERROR_NUMBER:
                addError(textValidation.numericError(name));
                break;
            case ERROR_POSITIVE:
                addError(textValidation.positiveError(name));
                break;
            case ERROR_NEGATIVE:
                addError(textValidation.negativeError(name));
                break;
        }
    }
    protected void getErrorNumberValidation(NumberValidation.NumberEnum numberEnum, double value, String name) {
        switch (numberEnum) {
            case ERROR_MAX:
                addError(textValidation.maxError(name, String.valueOf(value)));
                break;
            case ERROR_MIN:
                addError(textValidation.minError(name, String.valueOf(value)));
                break;
            case ERROR_GREATER:
                addError(textValidation.greaterError(name, String.valueOf(value)));
                break;
            case ERROR_LESS:
                addError(textValidation.lessError(name, String.valueOf(value)));
                break;
        }
    }

    protected void getErrorString(StringValidation.StringEnum textEnum, String input, String name) {
        switch (textEnum) {
            case ERROR_STRING:
                addError(textValidation.stringError(name));
                break;
            case ERROR_EMAIL:
                addError(textValidation.emailError(input));
                break;
            case ERROR_ALPHA:
                addError(textValidation.alphaError(name));
                break;
            case ERROR_ALPHA_NUM:
                addError(textValidation.alphaNumError(name));
                break;
            case ERROR_TOKEN:
                addError(textValidation.tokenError(name));
                break;
            case ERROR_URL:
                addError(textValidation.urlError(name));
                break;
            case ERROR_HEX:
                addError(textValidation.hexError(name));
                break;
            case ERROR_LOWERCASE:
                addError(textValidation.lowercaseError(name));
                break;
            case ERROR_UPPERCASE:
                addError(textValidation.uppercaseError(name));
                break;
        }
    }
    protected void getErrorString(StringValidation.StringEnum textEnum, int value, String name) {
        switch (textEnum) {
            case ERROR_MAX_LENGTH:
                addError(textValidation.maxLengthError(name, String.valueOf(value)));
                break;
            case ERROR_MIN_LENGTH:
                addError(textValidation.minLengthError(name, String.valueOf(value)));
                break;
        }
    }

    protected void getErrorBoolean(BooleanValidation.BooleanEnum booleanEnum, String name) {
        switch (booleanEnum) {
            case ERROR_BOOLEAN:
                addError(textValidation.booleanError(name));
                break;
            case ERROR_TRUE:
                addError(textValidation.trooError(name));
                break;
            case ERROR_FALSE:
                addError(textValidation.folsError(name));
                break;
        }
    }

    protected void getErrorDate(DateValidation.DateEnum dateEnum, String input, String name) {
        switch (dateEnum) {
            case ERROR_DATE:
                addError(textValidation.dateError(name));
                break;
            case ERROR_VALUE_REQUIRED:
                addError(textValidation.valueRequiredError());
                break;
            case ERROR_DATE_VALUE:
                addError(textValidation.dateValueError());
                break;
            case ERROR_MAX:
                addError(textValidation.maxError(name, input));
                break;
            case ERROR_MIN:
                addError(textValidation.minError(name, input));
                break;
            case ERROR_GREATER:
                addError(textValidation.greaterError(name, input));
                break;
            case ERROR_LESS:
                addError(textValidation.lessError(name, input));
                break;
        }
    }
    protected void getErrorDate(DateValidation.DateEnum dateEnum, String input1, String input2, String name) {
        switch (dateEnum) {
            case ERROR_BETWEEN:
                addError(textValidation.betweenError(name, input1, input2));
                break;
        }
    }

    private void addError(String error) {
        NewFormValidation.addErrors(error);
    }

    protected TextValidation getTextValidation() {
        return textValidation;
    }

    public NewRequest validate() {
        return request;
    }
}
