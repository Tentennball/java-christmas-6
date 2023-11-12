package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.view.OutputView;

public class PromotionController {
    OrderController orderController;
    EventController eventController;

    public PromotionController() {
        orderController = new OrderController();
        eventController = new EventController();
    }

    public void run() {
        welcomeGreet();
        Date date = inputDate();
        Menu menu = inputMenu();
        Order order = inputOrder();
        orderController.generateOrderCount(menu.getMenuInfo(), order);
        if (isOpenEvent(order.getTotalPrice())) {
            eventController.runningEvent(date, order);
        }

    }

    public Date inputDate() {
        return orderController.generateDate();
    }

    public Menu inputMenu() {
        return orderController.generateMenu();
    }

    public Order inputOrder() {
        return orderController.generateOrder();
    }

    public void welcomeGreet() {
        OutputView.printWelcomeGreeting();
    }

    public Boolean isOpenEvent(int totalPrice) {
        return totalPrice >= 10000;
    }
}
