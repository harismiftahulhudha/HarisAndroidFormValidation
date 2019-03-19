package id.harisgempong.harisformvalidation.interfaces;

import java.util.ArrayList;

import id.harisgempong.harisformvalidation.components.FormValidation;

public interface OnValidateListener {
    void onValidate(boolean isSuccessful, ArrayList<String> validationMessages, FormValidation fr);
}
