package id.harisgempong.harisformvalidation.model;

import java.util.regex.Pattern;

import id.harisgempong.harisformvalidation.components.ValidationHelper;
import id.harisgempong.harisformvalidation.components.NewFormValidation;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class NumberValidation extends ValidationHelper {

    private NewRequest request;
    private boolean isBlocked = false;
    private final String input, name;

    public enum NumberEnum {
        ERROR_NUMBER,
        ERROR_MIN,
        ERROR_MAX,
        ERROR_GREATER,
        ERROR_LESS,
        ERROR_POSITIVE,
        ERROR_NEGATIVE
    }

    NumberValidation(NewRequest request, TextValidation textValidation) {
        super(request, textValidation);
        if (request.getInput() instanceof String || request.getInput() instanceof Integer || request.getInput() instanceof Double || request.getInput() instanceof Float) {
            this.request = request;
            this.input = request.getInput().toString();
            this.name = request.getName();
            if (request.getFilteredInput().isEmpty()) {
                NewFormValidation.addErrors(getTextValidation().errorRequired(request.getName()));
                isBlocked = true;
            }
        } else {
            this.request = request;
            this.input = "";
            this.name = "";
            NewFormValidation.addErrors(getTextValidation().errorRequired(request.getName()));
            isBlocked = true;
        }
    }

    NumberValidation number() {
        if (!isBlocked) {
            Pattern PATTERN_NUMERIC = Pattern.compile("^(-?0|-?[1-9]\\d*)(\\.\\d+)?(E\\d+)?[a-zA-Z0-9]+$");
            if (!PATTERN_NUMERIC.matcher(request.getInput().toString()).matches()) {
                isBlocked = true;
                getErrorNumberValidation(NumberEnum.ERROR_NUMBER, request.getName());
            }
        }
        return this;
    }
    public NumberValidation max(double value) {
        if (!isBlocked) {
            if (Double.valueOf(input) >= value) {
                isBlocked = true;
                getErrorNumberValidation(NumberEnum.ERROR_MAX, value, name);
            }
        }
        return this;
    }
    public NumberValidation min(double value) {
        if (!isBlocked) {
            if (Double.valueOf(input) <= value) {
                isBlocked = true;
                getErrorNumberValidation(NumberEnum.ERROR_MIN, value, name);
            }
        }
        return this;
    }
    public NumberValidation greater(double value) {
        if (!isBlocked) {
            if (Double.valueOf(input) > value) {
                isBlocked = true;
                getErrorNumberValidation(NumberEnum.ERROR_GREATER, value, name);
            }
        }
        return this;
    }
    public NumberValidation less(double value) {
        if (!isBlocked) {
            if (Double.valueOf(input) < value) {
                isBlocked = true;
                getErrorNumberValidation(NumberEnum.ERROR_LESS, value, name);
            }
        }
        return this;
    }
    public NumberValidation positive() {
        if (!isBlocked) {
            if (Double.valueOf(input) < 0.0) {
                isBlocked = true;
                getErrorNumberValidation(NumberEnum.ERROR_POSITIVE, name);
            }
        }
        return this;
    }
    public NumberValidation negative() {
        if (!isBlocked) {
            if (Double.valueOf(input) > 0.0) {
                isBlocked = true;
                getErrorNumberValidation(NumberEnum.ERROR_NEGATIVE, name);
            }
        }
        return this;
    }
}
