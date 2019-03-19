package id.harisgempong.harisformvalidation.components;

import android.content.Context;

import id.harisgempong.harisformvalidation.R;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class RulesText implements TextValidation {

    private final Context context;

    RulesText(Context context) {
        this.context = context;
    }

    @Override
    public String success(String name) {
        return context.getResources().getString(R.string.success, name);
    }

    @Override
    public String maxError(String name, String value) {
        return context.getResources().getString(R.string.maxError, name, value);
    }

    @Override
    public String minError(String name, String value) {
        return context.getResources().getString(R.string.minError, name, value);
    }

    @Override
    public String emailError(String input) {
        return context.getResources().getString(R.string.emailError, input);
    }

    @Override
    public String maxLengthError(String name, String value) {
        return context.getResources().getString(R.string.maxLengthError, name, value);
    }

    @Override
    public String minLengthError(String name, String value) {
        return context.getResources().getString(R.string.minLengthError, name, value);
    }

    @Override
    public String alphaError(String name) {
        return context.getResources().getString(R.string.alphaError, name);
    }

    @Override
    public String numericError(String name) {
        return context.getResources().getString(R.string.numericError, name);
    }

    @Override
    public String alphaNumError(String name) {
        return context.getResources().getString(R.string.alphaNumError, name);
    }

    @Override
    public String booleanError(String name) {
        return context.getResources().getString(R.string.booleanError, name);
    }

    @Override
    public String errorNumberFormat(String name) {
        return context.getResources().getString(R.string.errorNumberFormat, name);
    }

    @Override
    public String errorRequired(String name) {
        return context.getResources().getString(R.string.errorRequired, name);
    }

    @Override
    public String defaultValidation(String key) {
        return context.getResources().getString(R.string.defaultValidation, key);
    }
}
