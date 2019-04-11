package id.harisgempong.harisformvalidation.model;

import id.harisgempong.harisformvalidation.components.NewFormValidation;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class NewRequest {
    private final String name;
    private final Object input;
    private TextValidation textValidation;

    public NewRequest(String name, Object input) {
        this.name = name;
        this.input = input;
        if (NewFormValidation.rulesText != null) {
            textValidation = NewFormValidation.rulesText;
        } else {
            textValidation = NewFormValidation.textValidation;
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
    protected Object getInput() {
        return input;
    }

    String getFilteredInput() {
        return getInput().toString().replaceAll("\\s+", " ").trim();
    }
    String getFilteredInput(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }
}
