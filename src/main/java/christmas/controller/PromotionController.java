package christmas.controller;

import christmas.constant.EventConstant;
import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.view.OutputView;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

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
        printPreviewMessage();
        printMenu(menu.getMenuInfo());

        Order order = inputOrder();

        orderController.generateOrderCount(menu.getMenuInfo(), order);
        List<Object> executedEvent = new ArrayList<>();
        if (isOpenEvent(order.getTotalPrice())) {
            executedEvent = eventController.runningEvent(date, order);
        }

        String badgeName = eventController.initBadge(order);

        printBill(order, executedEvent, badgeName);
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
        return totalPrice >= EventConstant.BEGIN_EVENT_PRICE;
    }

    public void printPreviewMessage() {
        OutputView.printPreviewEventTitle();
    }

    public void printMenu(Map<String, Integer> menuInfo) {
        OutputView.printOrderMenu(menuInfo);
    }

    public void printBill(Order order, List<Object> executedEvent, String badgeName) {
        OutputView.printTotalPrice(order.getTotalPrice());
        OutputView.printEventHistory(executedEvent, order);
        OutputView.printTotalPriceContainDiscount(executedEvent, order);
        OutputView.printBadgeName(badgeName);
    }
}
