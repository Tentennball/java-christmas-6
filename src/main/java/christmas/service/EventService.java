package christmas.service;

import christmas.domain.ChristmasEvent;
import christmas.domain.Order;
import christmas.domain.PresentEvent;
import christmas.domain.SpecialEvent;
import christmas.domain.WeekdayEvent;
import christmas.domain.WeekendEvent;

public class EventService {

    public void beginChristmasEvent(int reserveDate, Order order) {
        ChristmasEvent christmasEvent = new ChristmasEvent(reserveDate);
        if(christmasEvent.validateEnableEvent()){
            order.addTotalDiscountPrice(christmasEvent.calculateDiscountPrice());
        }
    }

    public void beginWeekEvent(int reserveDate, Order order) {
        WeekdayEvent weekdayEvent = new WeekdayEvent(reserveDate, order.getDessertOrderCount());
        if(weekdayEvent.validateEnableEvent()){
            order.addTotalDiscountPrice(weekdayEvent.calculateDiscountPrice());
        }
        WeekendEvent weekendEvent = new WeekendEvent(reserveDate, order.getMainMenuOrderCount());
        if(weekendEvent.validateEnableEvent()){
            order.addTotalDiscountPrice(weekendEvent.calculateDiscountPrice());
        }
    }

    public void beginSpecialEvent(int reserveDate, Order order) {
        SpecialEvent specialEvent = new SpecialEvent(order.getTotalPrice());
        if(specialEvent.validateEnableEvent()){
            order.addTotalDiscountPrice(specialEvent.calculateDiscountPrice());
        }
    }

    public void beginPresentEvent(Order order) {
        PresentEvent presentEvent = new PresentEvent(order.getTotalPrice());
        if(presentEvent.validateEnableEvent()){
            order.addTotalDiscountPrice(presentEvent.calculateDiscountPrice());
        }
    }
    
}
