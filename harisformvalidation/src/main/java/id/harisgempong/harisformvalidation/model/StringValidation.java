package id.harisgempong.harisformvalidation.model;

import java.util.regex.Pattern;

import id.harisgempong.harisformvalidation.components.ValidationHelper;
import id.harisgempong.harisformvalidation.components.FormValidation;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class StringValidation extends ValidationHelper {

    private Request request;
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
        ERROR_UPPERCASE,
        ERROR_INDO_NUMBER,
        ERROR_COMPARE
    }

    StringValidation(Request request, TextValidation textValidation) {
        super(request, textValidation);
        if (request.getInput() instanceof String) {
            this.request = request;
            this.input = request.getInput().toString();
            this.name = request.getName();
            if (request.getFilteredInput().isEmpty()) {
                FormValidation.addErrors(getTextValidation().errorRequired(request.getName()));
                isBlocked = true;
            }
        } else {
            this.request = request;
            this.input = "";
            this.name = "";
            FormValidation.addErrors(getTextValidation().errorRequired(request.getName()));
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
    public StringValidation maxlength(int value) {
        if (!isBlocked) {
            if (input.length() > value) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_MAX_LENGTH, value, name);
            }
        }
        return this;
    }
    public StringValidation minlength(int value) {
        if (!isBlocked) {
            if (input.length() < value) {
                isBlocked = true;
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
                isBlocked = true;
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
    public StringValidation uppercase() {
        if (!isBlocked) {
            if (!input.equals(input.toUpperCase())) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_UPPERCASE, input, name);
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
    public StringValidation compare(String value) {
        if (!isBlocked) {
            if (!input.equals(value)) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_COMPARE, value, name);
            }
        }
        return this;
    }
    public StringValidation indoNumber() {
        if (!isBlocked) {
            String number;
            String replace_slash = input.replace("-", "");
            String replace_plus = replace_slash.replace("+62", "62");
            String spasi = replace_plus.replace("62 ", "");
            if (spasi.length() > 2) {
                String cek3 = spasi.charAt(0) + "" + spasi.charAt(1) + spasi.charAt(2) + "";
                String cek2 = spasi.charAt(0) + "" + spasi.charAt(1);
                if (cek3.equals("628")) {
                    number = "8" + spasi.substring(3);
                } else if (cek2.equals("08")) {
                    number = "8" + spasi.substring(2);
                } else if (cek2.equals("62")) {
                    number = spasi.substring(2);
                } else {
                    number = spasi;
                }
            } else {
                number = spasi;
            }
            String finalNumber = "62" + number;
            if (!input.equals(finalNumber)) {
                isBlocked = true;
                getErrorString(StringEnum.ERROR_INDO_NUMBER, input, name);
            }
        }
        return this;
    }
}
