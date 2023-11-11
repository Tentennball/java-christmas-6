package christmas.controller;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.domain.Date;
import christmas.service.DateService;
import christmas.service.MenuService;
import christmas.view.ErrorView;
import christmas.view.InputView;
import christmas.view.OutputView;


public class OrderController {
    DateService dateService;
    MenuService menuService;

    public OrderController() {
        dateService = new DateService();
        menuService = new MenuService();
    }

    public void run() {
        welcomeGreet();
        Date date = inputDate();
        Menu menu = inputMenu();
    }

    public void welcomeGreet() {
        OutputView.printWelcomeGreeting();
    }

    public Date inputDate() {
        try {
            InputView.printReservationDateDecision();
            String reservationDate = Console.readLine();
            return dateService.reserveDate(reservationDate);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return inputDate();
        }
    }

    public Menu inputMenu() {
        try {
            InputView.printOrderRequest();
            String menuInfo = Console.readLine();
            return menuService.initMenu(menuInfo);

        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return inputMenu();
        }
    }


}
