package id.harisgempong.harisformvalidation.model;

import id.harisgempong.harisformvalidation.components.FormValidation;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class Request {
    private final String name;
    private final Object input;
    private TextValidation textValidation;

    public Request(String name, Object input) {
        this.name = name;
        this.input = input;
        if (FormValidation.rulesText != null) {
            textValidation = FormValidation.rulesText;
        } else {
            textValidation = FormValidation.textValidation;
        }
    }

    public NumberValidation number() {
        return new NumberValidation(this, textValidation).number();
    }
    public StringValidation string() {
        return new StringValidation(this, textValidation).string();
    }
    public BooleanValidation bool() {
        return new BooleanValidation(this, textValidation).bool();
    }
    public DateValidation date() {
        return new DateValidation(this, textValidation).date();
    }

    protected String getName() {
        return name;
    }
    Object getInput() {
        return input;
    }

    String getFilteredInput() {
        return getInput().toString().replaceAll("\\s+", " ").trim();
    }
    String getFilteredInput(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }
}
