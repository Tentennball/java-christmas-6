package christmas.service;

import christmas.domain.*;
import christmas.util.FormatUtil;
import christmas.validate.MenuValidate;
import java.util.Map;

public class OrderService {
    public Menu initMenu(String rawMenuInfo) {
        MenuValidate.validateInputFormat(rawMenuInfo);
        Map<String, Integer> menuInfo = FormatUtil.splitMenuNameAndCount(rawMenuInfo);
        return new Menu(menuInfo);
    }

    public Order initOrder() {
        return new Order();
    }

    public void initOrderCount(Map<String, Integer> orders, Order order) {
        for (String orderKey : orders.keySet()) {
            Object menuCategory = findCorrectKey(orderKey);
            updateOrderInfo(menuCategory, order, orderKey, orders.get(orderKey));
        }
        MenuValidate.validateOnlyBeverage(order.getBeverageOrderCount(), order.getTotalOrderCount());
    }

    public Object findCorrectKey(String orderKey) {
        MenuInfo menuInfo = initMenuInfo();
        Object menuCategory = menuInfo.findKey(orderKey);
        
        MenuValidate.validateValidMenu(menuCategory);

        return menuCategory;
    }

    public MenuInfo initMenuInfo() {
        AppetizerName appetizerNames = new AppetizerName();
        BeverageName beverageNames = new BeverageName();
        MainMenuName mainMenuNames = new MainMenuName();
        DessertName dessertNames = new DessertName();
        return new MenuInfo(appetizerNames, beverageNames, mainMenuNames, dessertNames);
    }

    public void updateOrderInfo(Object menuCategory, Order order, String orderKey, int orderCount) {
        if (menuCategory instanceof AppetizerName) {
            Appetizer appetizerMenuInfo = Appetizer.getOrderInfo(orderKey);
            updateOrder(appetizerMenuInfo.getPrice(), orderCount, order);
        }
        if (menuCategory instanceof BeverageName) {
            Beverage beverageMenuInfo = Beverage.getOrderInfo(orderKey);
            order.addBeverageOrderCount(orderCount);
            updateOrder(beverageMenuInfo.getPrice(), orderCount, order);
        }
        if (menuCategory instanceof MainMenuName) {
            MainMenu mainMenuMenuInfo = MainMenu.getOrderInfo(orderKey);
            order.addMainMenuOrderCount(orderCount);
            updateOrder(mainMenuMenuInfo.getPrice(), orderCount, order);
        }
        if (menuCategory instanceof DessertName) {
            Dessert dessertMenuInfo = Dessert.getOrderInfo(orderKey);
            order.addDessertOrderCount(orderCount);
            updateOrder(dessertMenuInfo.getPrice(), orderCount, order);
        }
    }

    public void updateOrder(int price, int orderCount, Order order) {
        order.addTotalOrderCount(orderCount);
        order.addTotalPrice(price * orderCount);
    }
}
