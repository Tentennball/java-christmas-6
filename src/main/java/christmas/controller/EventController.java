package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.EventService;

import java.util.List;
import java.util.ArrayList;

public class EventController {
    EventService eventService;

    public EventController() {
        eventService = new EventService();
    }

    public List<Object> runningEvent(Date date, Order order) {
        int reserveDate = date.getDate();
        int totalPrice = order.getTotalPrice();
        List<Object> eventType = new ArrayList<>();
        beginEvent(reserveDate, totalPrice, order, eventType);
        return eventType;
    }

    public String initBadge(Order order) {
        return activeBadge(order);
    }

    public List<Object> beginEvent(int reserveDate, int totalPrice, Order order, List<Object> eventType) {
        eventService.beginChristmasEvent(reserveDate, order, eventType);
        eventService.beginWeekEvent(reserveDate, order, eventType);
        eventService.beginSpecialEvent(reserveDate, order, eventType);
        eventService.beginPresentEvent(order, eventType);
        return eventType;
    }

    public String activeBadge(Order order) {
        return eventService.assignBadge(order);
    }

}
