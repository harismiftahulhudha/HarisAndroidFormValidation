package id.harisgempong.harisformvalidation.model;

public class Request {
    private final String name;
    private final Object input;
    private final String rules;
    private final boolean required;

    public Request(String name, Object input, String rules, boolean required) {
        this.name = name;
        this.input = input;
        this.rules = rules;
        this.required = required;
    }

    public String getName() {
        return name;
    }

    public Object getInput() {
        return input;
    }

    public String getRules() {
        return rules;
    }

    public boolean isRequired() {
        return required;
    }
}
