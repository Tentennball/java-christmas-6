package christmas.service;

import christmas.domain.ChristmasEvent;
import christmas.domain.Order;

public class EventService {

    public void beginChristmasEvent(int reserveDate, Order order) {
        ChristmasEvent christmasEvent = new ChristmasEvent(reserveDate);
        if(christmasEvent.validateEnableEvent()){
            order.addTotalDiscountPrice(christmasEvent.calculateDiscountPrice());
        }
    }

    public void beginWeekEvent(int reserveDate, Order order) {
        
    }

    public void beginSpecialEvent(int reserveDate, int totalPrice) {
    }

    public void beginPresentEvent(int totalDiscountPrice) {
    }
    
}
