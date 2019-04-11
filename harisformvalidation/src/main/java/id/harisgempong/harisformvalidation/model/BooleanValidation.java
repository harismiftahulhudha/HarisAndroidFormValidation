package id.harisgempong.harisformvalidation.model;

import id.harisgempong.harisformvalidation.components.ValidationHelper;
import id.harisgempong.harisformvalidation.components.NewFormValidation;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class BooleanValidation extends ValidationHelper {

    private NewRequest request;
    private boolean isBlocked = false;
    private final String name;

    public enum BooleanEnum {
        ERROR_BOOLEAN,
        ERROR_TRUE,
        ERROR_FALSE
    }

    BooleanValidation(NewRequest request, TextValidation textValidation) {
        super(request, textValidation);
        if (request.getInput() instanceof Boolean) {
            this.request = request;
            this.name = request.getName();
        } else if (request.getInput() instanceof String){
            this.request = request;
            this.name = request.getName();
            if (request.getFilteredInput().isEmpty() || request.getInput().toString().equals("")) {
                NewFormValidation.addErrors(getTextValidation().errorRequired(request.getName()));
                isBlocked = true;
            }
        } else {
            NewFormValidation.addErrors(getTextValidation().errorRequired(request.getName()));
            isBlocked = true;
            this.name = "";
        }
    }

    BooleanValidation bool() {
        if (!isBlocked) {
            if (!(request.getInput() instanceof Boolean)) {
                isBlocked = true;
                getErrorBoolean(BooleanEnum.ERROR_BOOLEAN, name);
            }
        }
        return this;
    }
    public BooleanValidation troo() {
        if (!isBlocked) {
            if ((request.getInput() instanceof  Boolean) && !(Boolean)request.getInput()) {
                isBlocked = true;
                getErrorBoolean(BooleanEnum.ERROR_TRUE, name);
            }
        }
        return this;
    }
    public BooleanValidation fols() {
        if (!isBlocked) {
            if ((request.getInput() instanceof  Boolean) && (Boolean)request.getInput()) {
                isBlocked = true;
                getErrorBoolean(BooleanEnum.ERROR_FALSE, name);
            }
        }
        return this;
    }
}
