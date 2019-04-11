package id.harisgempong.harisformvalidation.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import id.harisgempong.harisformvalidation.components.ValidationHelper;
import id.harisgempong.harisformvalidation.components.NewFormValidation;
import id.harisgempong.harisformvalidation.interfaces.TextValidation;

public class DateValidation extends ValidationHelper {
    private NewRequest request;
    private boolean isBlocked = false;
    private final String input, name;

    public enum DateEnum {
        ERROR_DATE,
        ERROR_VALUE_REQUIRED,
        ERROR_DATE_VALUE,
        ERROR_MAX,
        ERROR_MIN,
        ERROR_GREATER,
        ERROR_LESS,
        ERROR_BETWEEN
    }

    DateValidation(NewRequest request, TextValidation textValidation) {
        super(request, textValidation);
        if (request.getInput() instanceof String) {
            if (request.getFilteredInput().isEmpty()) {
                NewFormValidation.addErrors(getTextValidation().errorRequired(request.getName()));
                isBlocked = true;
            }
            this.request = request;
            this.input = request.getInput().toString();
            this.name = request.getName();
        } else {
            NewFormValidation.addErrors(getTextValidation().errorRequired(request.getName()));
            isBlocked = true;
            this.input = "";
            this.name = "";
        }
    }

    DateValidation date() {
        if (!isBlocked) {
            if (!isDate(input)) {
                isBlocked = true;
                getErrorDate(DateEnum.ERROR_DATE, input, name);
            }
        }
        return this;
    }
    public DateValidation max(String value) {
        if (!isBlocked) {
            if (isRequiredDate(value)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                try {
                    Date dateInput = simpleDateFormat.parse(input);
                    Date dateVal = simpleDateFormat.parse(value);
                    if (dateInput.getTime() >= dateVal.getTime()) {
                        isBlocked = true;
                        getErrorDate(DateEnum.ERROR_MAX, value, name);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
    public DateValidation min(String value) {
        if (!isBlocked) {
            if (isRequiredDate(value)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                try {
                    Date dateInput = simpleDateFormat.parse(input);
                    Date dateVal = simpleDateFormat.parse(value);
                    if (dateInput.getTime() <= dateVal.getTime()) {
                        isBlocked = true;
                        getErrorDate(DateEnum.ERROR_MIN, value, name);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
    public DateValidation greater(String value) {
        if (!isBlocked) {
            if (isRequiredDate(value)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                try {
                    Date dateInput = simpleDateFormat.parse(input);
                    Date dateVal = simpleDateFormat.parse(value);
                    if (dateInput.getTime() > dateVal.getTime()) {
                        isBlocked = true;
                        getErrorDate(DateEnum.ERROR_GREATER, value, name);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
    public DateValidation less(String value) {
        if (!isBlocked) {
            if (isRequiredDate(value)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                try {
                    Date dateInput = simpleDateFormat.parse(input);
                    Date dateVal = simpleDateFormat.parse(value);
                    if (dateInput.getTime() < dateVal.getTime()) {
                        isBlocked = true;
                        getErrorDate(DateEnum.ERROR_LESS, value, name);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }
    public DateValidation between(String value1, String value2) {
        if (!isBlocked) {
            if (isRequiredDate(value1)) {
                if (isRequiredDate(value2)) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    try {
                        Date dateInput = simpleDateFormat.parse(input);
                        Date dateVal1 = simpleDateFormat.parse(value1);
                        Date dateVal2 = simpleDateFormat.parse(value2);
                        if (!(dateInput.getTime() >= dateVal1.getTime() && dateInput.getTime() <= dateVal2.getTime())) {
                            isBlocked = true;
                            getErrorDate(DateEnum.ERROR_BETWEEN, value1, value2, name);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return this;
    }

    private boolean isRequiredDate(String value) {
        boolean bool;
        if (value != null) {
            if (request.getFilteredInput(value).isEmpty()) {
                isBlocked = true;
                getErrorDate(DateEnum.ERROR_VALUE_REQUIRED, value, name);
                bool = false;
            } else {
                if (!isDate(value)) {
                    isBlocked = true;
                    getErrorDate(DateEnum.ERROR_DATE_VALUE, value, name);
                    bool = false;
                } else {
                    bool = true;
                }
            }
        } else {
            isBlocked = true;
            getErrorDate(DateEnum.ERROR_VALUE_REQUIRED, "", name);
            bool = false;
        }
        return bool;
    }
    private boolean isDate(final String date) {
        final String DATE_PATTERN = "((19|20)\\d\\d)[/.-](0?[1-9]|1[012])[/.-](0?[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(date);

        if (matcher.matches()) {
            matcher.reset();

            if (matcher.find()) {
                String day = matcher.group(1);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(3));

                if (day.equals("31") &&
                        (month.equals("4") || month.equals("6") || month.equals("9") ||
                                month.equals("11") || month.equals("04") || month.equals("06") ||
                                month.equals("09"))) {
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                } else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if (year % 4 == 0) {
                        return !day.equals("30") && !day.equals("31");
                    } else {
                        return !day.equals("29") && !day.equals("30") && !day.equals("31");
                    }
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
