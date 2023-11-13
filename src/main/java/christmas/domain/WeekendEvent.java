package christmas.domain;

import christmas.constant.EventConstant;
import christmas.util.MathUtil;

import java.util.List;
import java.util.Arrays;

public class WeekendEvent extends Event {
    private boolean isEnabled;
    private int reserveDay;
    private int mainMenuOrderCount;
    private List<Integer> weekDays = Arrays.asList(EventConstant.FRIDAY, EventConstant.SATURDAY);

    public WeekendEvent(int reserveDate, int mainMenuOrderCount) {
        this.reserveDay = MathUtil.calculateDayOfWeek(reserveDate);
        this.mainMenuOrderCount = mainMenuOrderCount;
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
        return EventConstant.WEEK_EVENT_DISCOUNT_PRICE * mainMenuOrderCount;
    }

    @Override
    public Boolean getIsEnabled(){
        return isEnabled;
    }
}
