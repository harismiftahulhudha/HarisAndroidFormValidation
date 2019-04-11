package id.harisgempong.harisformvalidation.components;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import id.harisgempong.harisformvalidation.R;
import id.harisgempong.harisformvalidation.interfaces.OnValidateListener;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;
import id.harisgempong.harisformvalidation.model.NewRequest;

public class NewFormValidation extends ViewComponent {
    private final Context context;
    private List<NewRequest> requests;
    static ArrayList<String> errors;
    @SuppressLint("StaticFieldLeak")
    public static RulesText rulesText = null;
    public static TextValidation textValidation;

    public NewFormValidation(Context context) {
        super(context);
        this.requests = new ArrayList<>();
        errors = new ArrayList<>();
        this.context = context;
        rulesText = new RulesText(context);
    }

    public NewFormValidation(Context context, TextValidation textValidation){
        super(context);
        this.requests = new ArrayList<>();
        errors = new ArrayList<>();
        this.context = context;
        NewFormValidation.textValidation = textValidation;
    }

    public void addRequest(NewRequest request) {
        requests.add(request);
    }

    public static void addErrors(String error) {
        errors.add(error);
    }
    public void setOnValidateListener(OnValidateListener onValidateListener) {
        if (requests.size() == 0) {
            errors.add(context.getString(R.string.errorRequest));
            onValidateListener.onValidate(false, errors, this);
        } else {
            if (errors.size() > 0) {
                onValidateListener.onValidate(false, errors, this);
            }
        }
    }
}
