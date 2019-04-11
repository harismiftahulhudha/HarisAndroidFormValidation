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
    public String maxError(String name, String value) {
        return context.getResources().getString(R.string.maxError, name, value);
    }

    @Override
    public String minError(String name, String value) {
        return context.getResources().getString(R.string.minError, name, value);
    }

    @Override
    public String greaterError(String name, String value) {
        return context.getResources().getString(R.string.greaterError, name, value);
    }

    @Override
    public String lessError(String name, String value) {
        return context.getResources().getString(R.string.lessError, name, value);
    }

    @Override
    public String positiveError(String name) {
        return context.getResources().getString(R.string.positiveError, name);
    }

    @Override
    public String negativeError(String name) {
        return context.getResources().getString(R.string.negativeError, name);
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
    public String stringError(String name) {
        return context.getResources().getString(R.string.stringError, name);
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
    public String trooError(String name) {
        return context.getResources().getString(R.string.trooError, name);
    }

    @Override
    public String folsError(String name) {
        return context.getResources().getString(R.string.folsError, name);
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
    public String tokenError(String name) {
        return context.getResources().getString(R.string.tokenError, name);
    }

    @Override
    public String urlError(String name) {
        return context.getResources().getString(R.string.urlError, name);
    }

    @Override
    public String hexError(String name) {
        return context.getResources().getString(R.string.hexError, name);
    }

    @Override
    public String lowercaseError(String name) {
        return context.getResources().getString(R.string.lowercaseError, name);
    }

    @Override
    public String uppercaseError(String name) {
        return context.getResources().getString(R.string.uppercaseError, name);
    }

    @Override
    public String dateError(String name) {
        return context.getResources().getString(R.string.dateError, name);
    }

    @Override
    public String valueRequiredError() {
        return context.getResources().getString(R.string.valueRequiredError);
    }

    @Override
    public String dateValueError() {
        return context.getResources().getString(R.string.dateValueError);
    }

    @Override
    public String betweenError(String name, String value1, String value2) {
        return context.getResources().getString(R.string.betweenError, name, value1, value2);
    }
}
