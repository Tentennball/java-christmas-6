package christmas.domain;

import christmas.constant.EventConstant;
import christmas.util.MathUtil;

import java.util.List;
import java.util.Arrays;

public class WeekdayEvent extends Event {
    private boolean isEnabled;
    private int reserveDay;
    private int dessertOrderCount;
    private List<Integer> weekDays = Arrays.asList(EventConstant.THURSDAY, EventConstant.MONDAY, EventConstant.TUESDAY,
            EventConstant.WEDNESDAY, EventConstant.SUNDAY);

    public WeekdayEvent(int reserveDate, int dessertOrderCount) {
        this.reserveDay = MathUtil.calculateDayOfWeek(reserveDate);
        this.dessertOrderCount = dessertOrderCount;
    }

    @Override
    public Boolean validateEnableEvent() {
        if (weekDays.contains(reserveDay)) {
            isEnabled = true;
            return true;
        }
        isEnabled = false;
        return false;
    }

    @Override
    public int calculateDiscountPrice() {
        return EventConstant.WEEK_EVENT_DISCOUNT_PRICE * dessertOrderCount;
    }

    @Override    
    public Boolean getIsEnabled(){
        return isEnabled;
    }
}
