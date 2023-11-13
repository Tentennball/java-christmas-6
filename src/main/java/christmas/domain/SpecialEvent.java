package christmas.domain;

import christmas.constant.EventConstant;
import christmas.util.MathUtil;

public class SpecialEvent extends Event {
    private boolean isEnabled;
    private int reserveDate;
    private int reserveDay;
    private static int discountPrice;

    public SpecialEvent(int reserveDate) {
        this.reserveDate = reserveDate;
        this.reserveDay = MathUtil.calculateDayOfWeek(reserveDate);
    }

    @Override
    public Boolean validateEnableEvent() {
        if (reserveDay % 7 == EventConstant.SUNDAY || reserveDate == EventConstant.CHRISTMAS_DAY){
            isEnabled = true;
            return true;
        }
        isEnabled = false;
        return false;
    }

    @Override
    public int calculateDiscountPrice() {
        discountPrice = EventConstant.SPECIAL_EVENT_DISCOUNT_PRICE;
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
