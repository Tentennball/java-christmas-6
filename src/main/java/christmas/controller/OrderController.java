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
            InputView.printReservationDateDecision();
            String reservationDate = Console.readLine();
            return dateService.reserveDate(reservationDate);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return generateDate();
        }
    }

    public Menu generateMenu() {
        try {
            InputView.printOrderRequest();
            String menuInfo = Console.readLine();
            return orderService.initMenu(menuInfo);

        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return generateMenu();
        }
    }

    public Order generateOrder() {
        return orderService.initOrder();
    }

    public void generateOrderCount(Map<String, Integer> menuInfo, Order order) {
        orderService.initOrderCount(menuInfo, order);
    }
}
