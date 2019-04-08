package id.harisgempong.harisformvalidation.components;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

import id.harisgempong.harisformvalidation.R;
import id.harisgempong.harisformvalidation.adapter.RequestAdapter;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;
import id.harisgempong.harisformvalidation.model.Request;
import id.harisgempong.harisformvalidation.interfaces.OnValidateListener;

public class FormValidation {
    private final Context context;
    private final ArrayList<Request> requests;
    private final ArrayList<String> validationMessages;
    private boolean isFormatCorrect = true;
    private RulesText rulesText = null;
    private TextValidation textValidation = null;

    private Object backgroundColor = null, iconColor = null, textColor = null, backgroundRowColor = null, textRowColor = null;

    public FormValidation(Context context) {
        this.context = context;
        this.requests = new ArrayList<>();
        this.validationMessages = new ArrayList<>();
        this.rulesText = new RulesText(context);
    }

    public FormValidation(Context context, TextValidation textValidation) {
        this.context = context;
        this.requests = new ArrayList<>();
        this.validationMessages = new ArrayList<>();
        this.textValidation = textValidation;
    }

    public void setBackgroundColor(Object color) {
        this.backgroundColor = color;
    }

    public void setIconColor(Object color) {
        this.iconColor = color;
    }

    public void setTextColor(Object color) {
        this.textColor = color;
    }

    public void setBackgroundRowColor(Object color) {
        this.backgroundRowColor = color;
    }

    public void setTextRowColor(Object color) {
        this.textRowColor = color;
    }

    public void addRequest(Request request) {
        requests.add(request);
    }

    public void setOnValidateListener(OnValidateListener onValidateListener) {
        if (requests.size() == 0) {
            validationMessages.add("Anda belum membuat request validasi");
            onValidateListener.onValidate(false, validationMessages, this);
        } else {
            if (rulesText != null) {
                separateRequest(rulesText);
            } else {
                separateRequest(textValidation);
            }
            if (validationMessages.size() == 0) {
                validationMessages.add("Validasi Berhasil");
                onValidateListener.onValidate(true, validationMessages, this);
            } else {
                onValidateListener.onValidate(false, validationMessages, this);
            }
        }
    }

    public void showError() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.layout_show_dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        } else {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        dialog.setCancelable(true);
        dialog.show();

        CardView cardView = dialog.findViewById(R.id.cardView);
        ImageView icon = dialog.findViewById(R.id.icon);
        TextView text = dialog.findViewById(R.id.text);

        setColor(cardView, icon, text);

        if (validationMessages.size() > 4) {
            cardView.setLayoutParams(new CardView.LayoutParams(CardView.LayoutParams.WRAP_CONTENT, 800));
        }

        RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);
        RequestAdapter adapter = new RequestAdapter(context, validationMessages)
                .setBackgroundRowColor(backgroundRowColor)
                .setTextRowColor(textRowColor);
        recyclerView.setAdapter(adapter);
    }

    private void setColor(CardView cardView, ImageView icon, TextView text) {
        if (backgroundColor == null) {
            cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefaultBackground));
        } else {
            if (backgroundColor instanceof String) {
                try {
                    String color = "#" + backgroundColor.toString();
                    cardView.setCardBackgroundColor(Color.parseColor(color));
                } catch (IllegalArgumentException e) {
                    cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefaultBackground));
                }
            } else if (backgroundColor instanceof Integer) {
                cardView.setCardBackgroundColor(context.getResources().getColor((Integer) backgroundColor));
            } else {
                cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorDefaultBackground));
            }
        }

        if (iconColor == null) {
            Drawable failIcon = DrawableCompat.wrap(context.getResources().getDrawable(R.drawable.icon_fail));
            DrawableCompat.setTint(failIcon, context.getResources().getColor(R.color.colorDefaultRed));
            icon.setImageDrawable(failIcon);
        } else {
            Drawable failIcon = DrawableCompat.wrap(context.getResources().getDrawable(R.drawable.icon_fail));
            if (iconColor instanceof String) {
                String color = "#" + iconColor.toString();
                DrawableCompat.setTint(failIcon, Color.parseColor(color));
                icon.setImageDrawable(failIcon);
            } else if (iconColor instanceof Integer) {
                DrawableCompat.setTint(failIcon, context.getResources().getColor((Integer) iconColor));
                icon.setImageDrawable(failIcon);
            } else {
                DrawableCompat.setTint(failIcon, context.getResources().getColor(R.color.colorDefaultRed));
                icon.setImageDrawable(failIcon);
            }
        }

        if (textColor == null) {
            text.setTextColor(context.getResources().getColor(R.color.colorDefaultRed));
        } else {
            if (textColor instanceof String) {
                String color = "#" + textColor.toString();
                text.setTextColor(Color.parseColor(color));
            } else if (textColor instanceof Integer) {
                text.setTextColor(context.getResources().getColor((Integer) textColor));
            } else {
                text.setTextColor(context.getResources().getColor(R.color.colorDefaultRed));
            }
        }
    }

    private void separateRequest(TextValidation textValidation) {
        for (Request request : requests) {
            if (request.isRequired() && request.getInput().toString().replaceAll("\\s+", " ").trim().isEmpty()) {
                validationMessages.add(textValidation.errorRequired(request.getName()));
            } else {
                separateRules(request);
            }
        }
    }

    private void separateRules(Request request) {
        String[] rules = request.getRules().split(Pattern.quote("|"));
        for (String rule : rules) {
            if (isFormatCorrect) {
                extractRule(request.getName(), rule, request.getInput());
                System.out.println("extract: correct " + rule);
            } else {
                System.out.println("extract: incorrect " + rule);
                break;
            }
        }
        isFormatCorrect = true;
    }

    private void extractRule(String name, String rule, Object input) {
        String key = "";
        String value = "";
        String[] extract = rule.split(Pattern.quote(":"));
        for (int i = 0; i < extract.length; i++) {
            if (i == 0) {
                key = extract[i];
            } else {
                value = extract[i];
            }
        }
        if (rulesText != null) {
            collectValidationMessages(name, key, value, input.toString(), rulesText);
        } else {
            collectValidationMessages(name, key, value, input.toString(), textValidation);
        }
    }

    private void collectValidationMessages(String name, String key, String value, String input, TextValidation textValidation) {
        boolean isSuccessful = false;
        String validate;
        switch (key.toLowerCase()) {
            case "max":
                try {
                    if (Double.valueOf(input) > Double.valueOf(value)) {
                        validate = textValidation.maxError(name, value);
                        isSuccessful = false;
                    } else {
                        validate = textValidation.success(name);
                        isSuccessful = true;
                    }
                } catch (NumberFormatException e) {
                    validate = textValidation.errorNumberFormat(input);
                    isSuccessful = false;
                    isFormatCorrect = false;
                }
                break;
            case "min":
                try {
                    if (Double.valueOf(input) < Double.valueOf(value)) {
                        validate = textValidation.minError(name, value);
                        isSuccessful = false;
                    } else {
                        validate = textValidation.success(name);
                        isSuccessful = true;
                    }
                } catch (NumberFormatException e) {
                    validate = textValidation.errorNumberFormat(input);
                    isSuccessful = false;
                    isFormatCorrect = false;
                }
                break;
            case "email":
                String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                Pattern pattern = Pattern.compile(EMAIL_PATTERN);
                if (!pattern.matcher(input).matches()) {
                    validate = textValidation.emailError(input);
                    isSuccessful = false;
                } else {
                    validate = textValidation.success(name);
                    isSuccessful = true;
                }
                break;
            case "maxlength":
                if (input.length() > Double.valueOf(value)) {
                    validate = textValidation.maxLengthError(name, value);
                    isSuccessful = false;
                } else {
                    validate = textValidation.success(name);
                    isSuccessful = true;
                }
                break;
            case "minlength":
                if (input.length() < Double.valueOf(value)) {
                    validate = textValidation.minLengthError(name, value);
                    isSuccessful = false;
                } else {
                    validate = textValidation.success(name);
                    isSuccessful = true;
                }
                break;
            case "alpha":
                if (!input.matches("[a-zA-Z]+")) {
                    validate = textValidation.alphaError(name);
                    isSuccessful = false;
                } else {
                    validate = textValidation.success(name);
                    isSuccessful = true;
                }
                break;
            case "numeric":
                Pattern PATTERN_NUMERIC = Pattern.compile("^(-?0|-?[1-9]\\d*)(\\.\\d+)?(E\\d+)?[a-zA-Z0-9]+$");
                if (!PATTERN_NUMERIC.matcher(input).matches()) {
                    validate = textValidation.numericError(name);
                    isSuccessful = false;
                } else {
                    validate = textValidation.success(name);
                    isSuccessful = true;
                }
                break;
            case "alpha_num":
                if (!input.matches("^[a-zA-Z0-9]+$")) {
                    validate = textValidation.alphaNumError(name);
                    isSuccessful = false;
                } else {
                    validate = textValidation.success(name);
                    isSuccessful = true;
                }
                break;
            case "boolean":
                if (input.equals("true") || input.equals("false")) {
                    validate = textValidation.success(name);
                    isSuccessful = true;
                } else {
                    validate = textValidation.booleanError(name);
                    isSuccessful = false;
                }
                break;
            default:
                validate = textValidation.defaultValidation(key);
                isFormatCorrect = false;
                break;
        }
        if (!isSuccessful) {
            validationMessages.add(validate);
        }
    }
}
