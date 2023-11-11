package christmas.service;

import christmas.domain.*;
import christmas.util.FormatUtil;
import christmas.validate.MenuValidate;

import java.util.Map;

public class MenuService {
    public Menu initMenu(String rawMenuInfo) {
        MenuValidate.validateInputFormat(rawMenuInfo);
        Map<String, Integer> menuInfo = FormatUtil.splitMenuNameAndCount(rawMenuInfo);
        return new Menu(menuInfo);
    }

    public Order initOrder(Date date, Menu menu) {
        return new Order(date, menu);
    }

    public void initOrderCount(Map<String, Integer> orders, Order order) {
        for (String orderKey : orders.keySet()) {
            boolean findKey = findCorrectKey(orderKey, order, orders);
            MenuValidate.validateValidMenu(findKey);
        }
        MenuValidate.validateOnlyBeverage(Beverage.getOrderCount(), order.getTotalOrderCount());
    }

    public Boolean findCorrectKey(String orderKey, Order order, Map<String, Integer> orders) {
        for (Beverage beverageMenu : Beverage.values()) {
            if (orderKey.equals(beverageMenu.getName())) {
                int orderCount = orders.get(orderKey);
                Beverage.addOrderCount(orderCount);
                order.addTotalPrice(beverageMenu.getPrice() * orderCount);
                order.addTotalOrderCount(orderCount);
                return true;
            }
        }
        for (Appetizer appetizerMenu : Appetizer.values()) {
            if (orderKey.equals(appetizerMenu.getName())) {
                int orderCount = orders.get(orderKey);
                Appetizer.addOrderCount(orderCount);
                order.addTotalPrice(appetizerMenu.getPrice() * orderCount);
                order.addTotalOrderCount(orderCount);
                return true;
            }
        }
        for (MainMenu mainMenu : MainMenu.values()) {
            if (orderKey.equals(mainMenu.getName())) {
                int orderCount = orders.get(orderKey);
                MainMenu.addOrderCount(orderCount);
                order.addTotalPrice(mainMenu.getPrice() * orderCount);
                order.addTotalOrderCount(orderCount);
                return true;
            }
        }
        for (Dessert dessertMenu : Dessert.values()) {
            if (orderKey.equals(dessertMenu.getName())) {
                int orderCount = orders.get(orderKey);
                Dessert.addOrderCount(orderCount);
                order.addTotalPrice(dessertMenu.getPrice() * orderCount);
                order.addTotalOrderCount(orderCount);
                return true;
            }
        }
        return false;
    }
}
