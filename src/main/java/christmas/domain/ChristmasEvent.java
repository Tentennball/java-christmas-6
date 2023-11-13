package christmas.domain;

import christmas.constant.EventConstant;

public class ChristmasEvent extends Event {
    private int reservationDate;

    public ChristmasEvent(int reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public Boolean validateEnableEvent() {
        return (reservationDate <= 25);
    }

    @Override
    public int calculateDiscountPrice() {
        return EventConstant.MAX_CHRISTMAS_EVENT_DISCOUNT_PRICE
                - (reservationDate - 1) * EventConstant.DISCOUNT_PER_DAY;
    }
}
