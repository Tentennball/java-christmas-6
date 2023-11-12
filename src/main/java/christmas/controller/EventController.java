package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.EventService;

public class EventController {
    EventService eventService;

    public EventController() {
        eventService = new EventService();
    }

    public void runningEvent(Date date, Order order) {
        int reserveDate = date.getDate();
        int totalPrice = order.getTotalPrice();
        
    }
}
