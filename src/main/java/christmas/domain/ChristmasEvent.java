package christmas.domain;

import christmas.constant.EventConstant;

public class ChristmasEvent extends Event {
    private boolean isEnabled;
    private int reservationDate;

    public ChristmasEvent(int reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public Boolean validateEnableEvent() {
        if(reservationDate <= EventConstant.CHRISTMAS_DAY){
            isEnabled = true;
            return true;
        }
        isEnabled = false;
        return false;
    }

    @Override
    public int calculateDiscountPrice() {
        return EventConstant.MAX_CHRISTMAS_EVENT_DISCOUNT_PRICE
                - (reservationDate - 1) * EventConstant.DISCOUNT_PER_DAY;
    }

    @Override
    public Boolean getIsEnabled(){
        return isEnabled;
    }
}
