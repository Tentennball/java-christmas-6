package christmas.controller;

import christmas.service.DateService;
import christmas.service.MenuService;
import christmas.service.EventService;


public class PromotionController {
    DateService dateService;
    MenuService menuService;
    EventService eventService;

    public PromotionController(){
        dateService = new DateService();
        menuService = new MenuService();
        eventService = new EventService();
    }

    public void run(){
        inputDate();
        inputMenu();
        applyEvent();
    }
    private void inputDate() {

    }

    private void inputMenu() {

    }

    private void applyEvent() {

    }


}
