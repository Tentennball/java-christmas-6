package christmas.service;

import christmas.domain.Date;

public class DateService {

    public Date reserveDate(String reservationDate) {
        Date date = generateDateFromReservationDate(reservationDate);
        return date;
    }

    private Date generateDateFromReservationDate(String reservationDate){
        return new Date(reservationDate);
    }
}
