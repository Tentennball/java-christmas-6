package christmas.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuInfo {
    Map<Object, List<String>> menuInfo = new HashMap<>();

    public MenuInfo(AppetizerName appetizerNames, BeverageName beverageNames, MainMenuName mainMenuNames,
            DessertName dessertNames) {
        menuInfo.put(new BeverageName(), beverageNames.getBeverageNames());
        menuInfo.put(new MainMenuName(), mainMenuNames.getMainMenuNames());
        menuInfo.put(new DessertName(), dessertNames.getDessertNames());
        menuInfo.put(new AppetizerName(), appetizerNames.getAppetizerNames());
    }

    public Map<Object, List<String>> getMenuInfo() {
        return menuInfo;
    }

    public Object findKey(String orderKey) {
        for (Map.Entry<Object, List<String>> entry : menuInfo.entrySet()) {
            Object key = entry.getKey();
            List<String> values = entry.getValue();
            if(isFindName(values, orderKey)){
                return key;
            }
        }
        return null; 
    }

    public Boolean isFindName(List<String> values, String orderKey){
        for (String value : values) {
            if(value.equals(orderKey)){
                return true;
            }
        }
        return false;
    }
}
