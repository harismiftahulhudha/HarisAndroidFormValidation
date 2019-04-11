package id.harisgempong.harisformvalidation.model;

import java.util.regex.Pattern;

import id.harisgempong.harisformvalidation.components.ValidationHelper;
import id.harisgempong.harisformvalidation.components.NewFormValidation;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class StringValidation extends ValidationHelper {

    private NewRequest request;
    private boolean isBlocked = false;
    private final String input, name;

    public enum StringEnum {
        ERROR_STRING,
        ERROR_MIN_LENGTH,
        ERROR_MAX_LENGTH,
        ERROR_EMAIL,
        ERROR_ALPHA,
        ERROR_ALPHA_NUM,
        ERROR_TOKEN,
        ERROR_URL,
        ERROR_HEX,
        ERROR_LOWERCASE,
        ERROR_UPPERCASE
    }

    StringValidation(NewRequest request, TextValidation textValidation) {
        super(request, textValidation);
        if (request.getInput() instanceof String) {
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

    StringValidation string() {
        if (!isBlocked) {
            if (!(request.getInput() instanceof String)) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_STRING, input, name);
            }
        }
        return this;
    }
    public StringValidation maxLength(int value) {
        if (!isBlocked) {
            if (input.length() > value) {
                getErrorString(StringEnum.ERROR_MAX_LENGTH, value, name);
            }
        }
        return this;
    }
    public StringValidation minLength(int value) {
        if (!isBlocked) {
            if (input.length() < value) {
                getErrorString(StringEnum.ERROR_MIN_LENGTH, value, name);
            }
        }
        return this;
    }
    public StringValidation email() {
        if (!isBlocked) {
            String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            if (!pattern.matcher(input).matches()) {
                getErrorString(StringEnum.ERROR_EMAIL, input, name);
            }
        }
        return this;
    }
    public StringValidation alpha() {
        if (!isBlocked) {
            if (!input.matches("[a-zA-Z]+")) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_ALPHA, input, name);
            }
        }
        return this;
    }
    public StringValidation alphanum() {
        if (!isBlocked) {
            if (!input.matches("^[a-zA-Z0-9]+$")) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_ALPHA_NUM, input, name);
            }
        }
        return this;
    }
    public StringValidation token() {
        if (!isBlocked) {
            if (!input.matches("^[-a-zA-Z0-9._]+")) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_TOKEN, input, name);
            }
        }
        return this;
    }
    public StringValidation url() {
        if (!isBlocked) {
            String URL_PATTERN = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
            Pattern pattern = Pattern.compile(URL_PATTERN);
            if (!pattern.matcher(input).matches()) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_URL, input, name);
            }
        }
        return this;
    }
    public StringValidation hex() {
        if (!isBlocked) {
            String HEX_PATTERN = "^#([A-Fa-f0-9]{8}|[A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
            Pattern pattern = Pattern.compile(HEX_PATTERN);
            if (!pattern.matcher(input).matches()) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_HEX, input, name);
            }
        }
        return this;
    }
    public StringValidation lowercase() {
        if (!isBlocked) {
            if (!input.equals(input.toLowerCase())) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_LOWERCASE, input, name);
            }
        }
        return this;
    }
    public StringValidation uppercase() {
        if (!isBlocked) {
            if (!input.equals(input.toUpperCase())) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_UPPERCASE, input, name);
            }
        }
        return this;
    }
}
