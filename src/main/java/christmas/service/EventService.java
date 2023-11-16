package christmas.service;

import christmas.domain.Badge;
import christmas.domain.ChristmasEvent;
import christmas.domain.Order;
import christmas.domain.PresentEvent;
import christmas.domain.SpecialEvent;
import christmas.domain.WeekdayEvent;
import christmas.domain.WeekendEvent;

import java.util.List;

public class EventService {

    public List<Object> beginChristmasEvent(int reserveDate, Order order, List<Object> eventType) {
        ChristmasEvent christmasEvent = initChristmasEvent(reserveDate);
        if (christmasEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(christmasEvent.calculateDiscountPrice());
            eventType.add(christmasEvent);
        }
        return eventType;
    }

    public List<Object> beginWeekEvent(int reserveDate, Order order, List<Object> eventType) {
        WeekdayEvent weekdayEvent = initWeekdayEvent(reserveDate, order.getDessertOrderCount());
        if (weekdayEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(weekdayEvent.calculateDiscountPrice());
            eventType.add(weekdayEvent);
            return eventType;
        }
        WeekendEvent weekendEvent = initWeekendEvent(reserveDate, order.getMainMenuOrderCount());
        if (weekendEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(weekendEvent.calculateDiscountPrice());
            eventType.add(weekendEvent);
        }
        return eventType;
    }

    public List<Object> beginSpecialEvent(int reserveDate, Order order, List<Object> eventType) {
        SpecialEvent specialEvent = initSpecialEvent(reserveDate);
        if (specialEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(specialEvent.calculateDiscountPrice());
            eventType.add(specialEvent);
        }
        return eventType;
    }

    public List<Object> beginPresentEvent(Order order, List<Object> eventType) {
        PresentEvent presentEvent = initPresentEvent(order.getTotalPrice());
        if (presentEvent.validateEnableEvent()) {
            order.addTotalDiscountPrice(presentEvent.calculateDiscountPrice());
            eventType.add(presentEvent);
        }
        return eventType;
    }

    public String assignBadge(Order order) {
        Badge badge = initBadge(order.getTotalDiscountPrice());
        String assignedBadgeName = badge.getBadgeName();
        return assignedBadgeName;
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

    private Badge initBadge(int totalDiscountPrice) {
        return new Badge(totalDiscountPrice);
    }
}
