package christmas.controller;

import java.util.Map;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.DateService;
import christmas.service.OrderService;
import christmas.view.ErrorView;
import christmas.view.InputView;

public class OrderController {
    DateService dateService;
    OrderService orderService;

    public OrderController() {
        dateService = new DateService();
        orderService = new OrderService();
    }

    public Date generateDate() {
        try {
            String reservationDate = InputView.readReservationDateDecision();
            return dateService.reserveDate(reservationDate);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return generateDate();
        }
    }

    public Menu generateMenu() {
        String menuInfo = InputView.readOrderRequest();
        return orderService.initMenu(menuInfo);
    }

    public Order generateOrder() {
        return orderService.initOrder();
    }

    public void generateOrderCount(Map<String, Integer> menuInfo, Order order) {
        orderService.initOrderCount(menuInfo, order);
    }
}
