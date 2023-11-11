package christmas.domain;

import christmas.validate.DateValidate;

public class Date {
    private int date;

    public Date(String date) {
        dateValidate(date);
        this.date = Integer.parseInt(date);
    }

    private void dateValidate(String date){
        DateValidate.validateNumeric(date);
        DateValidate.validateDateSize(date);
    }
}
