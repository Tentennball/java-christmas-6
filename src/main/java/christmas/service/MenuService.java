package christmas.service;

import christmas.domain.Menu;
import christmas.util.FormatUtil;
import validate.MenuValidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MenuService {
    public Menu initMenu(String rawMenuInfo) {
        MenuValidate.validateInputFormat(rawMenuInfo);
        Map<String, Integer> menuInfo= FormatUtil.splitMenuNameAndCount(rawMenuInfo);
        return new Menu(menuInfo);
    }
}
