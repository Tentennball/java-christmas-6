package christmas.domain;

import christmas.constant.EventConstant;

public class ChristmasEvent extends Event {
    private boolean isEnabled;
    private int reservationDate;
    private static int discountPrice;
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
        discountPrice = EventConstant.MAX_CHRISTMAS_EVENT_DISCOUNT_PRICE
                - (reservationDate - 1) * EventConstant.DISCOUNT_PER_DAY;
        return discountPrice; 
    }

    @Override
    public Boolean getIsEnabled(){
        return isEnabled;
    }

    public static int getDiscountPrice(){
        return discountPrice;
    }
}
