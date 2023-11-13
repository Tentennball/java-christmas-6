package christmas.domain;

import christmas.constant.EventConstant;
import christmas.util.MathUtil;

public class SpecialEvent extends Event {
    private boolean isEnabled;
    private int reserveDate;
    private int reserveDay;

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
        return EventConstant.SPECIAL_EVENT_DISCOUNT_PRICE;
    }

    @Override
    public Boolean getIsEnabled(){
        return isEnabled;
    }
}
