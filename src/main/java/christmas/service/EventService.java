package christmas.service;

import christmas.domain.ChristmasEvent;
import christmas.domain.Order;
import christmas.domain.PresentEvent;
import christmas.domain.SpecialEvent;
import christmas.domain.WeekdayEvent;
import christmas.domain.WeekendEvent;

public class EventService {

    public void beginChristmasEvent(int reserveDate, Order order) {
        ChristmasEvent christmasEvent = initChristmasEvent(reserveDate);
        if (christmasEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(christmasEvent.calculateDiscountPrice());
        }
    }

    public void beginWeekEvent(int reserveDate, Order order) {
        WeekdayEvent weekdayEvent = initWeekdayEvent(reserveDate, order.getDessertOrderCount());
        if (weekdayEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(weekdayEvent.calculateDiscountPrice());
        }
        WeekendEvent weekendEvent = initWeekendEvent(reserveDate, order.getMainMenuOrderCount());
        if (weekendEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(weekendEvent.calculateDiscountPrice());
        }
    }

    public void beginSpecialEvent(int reserveDate, Order order) {
        SpecialEvent specialEvent = initSpecialEvent(order.getTotalPrice());
        if (specialEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(specialEvent.calculateDiscountPrice());
        }
    }

    public void beginPresentEvent(Order order) {
        PresentEvent presentEvent = initPresentEvent(order.getTotalPrice());
        if (presentEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(presentEvent.calculateDiscountPrice());
        }
    }

    private ChristmasEvent initChristmasEvent(int reserveDate) {
        return new ChristmasEvent(reserveDate);
    }

    private WeekdayEvent initWeekdayEvent(int reserveDate, int dessertOrderCount) {
        return new WeekdayEvent(reserveDate, dessertOrderCount);
    }

    private WeekendEvent initWeekendEvent(int reserveDate, int mainMenuOrderCount) {
        return new WeekendEvent(reserveDate, mainMenuOrderCount);
    }

    private SpecialEvent initSpecialEvent(int totalPrice) {
        return new SpecialEvent(totalPrice);
    }

    private PresentEvent initPresentEvent(int totalPrice) {
        return new PresentEvent(totalPrice);
    }
}
