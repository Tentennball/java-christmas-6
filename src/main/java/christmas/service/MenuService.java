package christmas.service;

import christmas.domain.Date;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.util.FormatUtil;
import christmas.validate.MenuValidate;

import java.util.Map;

public class MenuService {
    public Menu initMenu(String rawMenuInfo) {
        MenuValidate.validateInputFormat(rawMenuInfo);
        Map<String, Integer> menuInfo= FormatUtil.splitMenuNameAndCount(rawMenuInfo);
        return new Menu(menuInfo);
    }

    public Order initOrder(Date date, Menu menu){
        return new Order(date, menu);
    }
}
