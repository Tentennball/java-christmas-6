package christmas.view;

import java.util.Map;

import christmas.domain.Beverage;
import christmas.domain.ChristmasEvent;
import christmas.domain.Order;
import christmas.domain.PresentEvent;
import christmas.domain.SpecialEvent;
import christmas.domain.WeekdayEvent;
import christmas.domain.WeekendEvent;

import java.util.List;

public class OutputView {
    private static final String WELCOME = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String PREVIEW_EVENT_TITLE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU_TITLE = "<주문 메뉴>";
    private static final String ORDER_MENU_FORMAT = "%s %d개\n";
    private static final String TOTAL_PRICE_TITLE = "<할인 전 총주문 금액>";
    private static final String PRESENT_MENU = "<증정 메뉴>";
    private static final String PRESENT_CHAMPAGNE = "샴페인 1개";
    private static final String EVENT_HISTORY_TITLE = "<혜택 내역>";
    private static final String CHRISTMAS_EVENT_TITLE = "크리스마스 디데이 할인: ";
    private static final String WEEKDAY_EVENT_TITLE = "평일 할인: ";
    private static final String WEEKEND_EVENT_TITLE = "주말 할인: ";
    private static final String SPECIAL_EVENT_TITLE = "특별 할인: ";
    private static final String PRESENT_EVENT_TITLE = "증정 이벤트: ";
    private static final String TOTAL_DISCOUNT_PRICE_TITLE = "<총혜택 금액>";
    private static final String PRICE_MINUS_FORMAT = "-%,d원\n";
    private static final String PRICE_FORMAT = "%,d원\n";
    private static final String TOTAL_PRICE_CONTAIN_DISCOUNT = "<할인 후 예상 결제 금액>";
    private static final String BADGE_NAME_TITLE = "<12월 이벤트 배지>";
    private static final String NONE = "없음";

    public static void printWelcomeGreeting() {
        System.out.println(WELCOME);
    }

    public static void printPreviewEventTitle() {
        System.out.println(PREVIEW_EVENT_TITLE);
        System.out.println();
    }

    public static void printOrderMenu(Map<String, Integer> menuInfo) {
        System.out.println(ORDER_MENU_TITLE);
        for (Map.Entry<String, Integer> entry : menuInfo.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf(ORDER_MENU_FORMAT, key, value);
        }
        System.out.println();
    }

    public static void printTotalPrice(int totalPrice) {
        System.out.println(TOTAL_PRICE_TITLE);
        System.out.printf(PRICE_FORMAT, totalPrice);
        System.out.println();
    }

    public static void printEventHistory(List<Object> executedEvent, Order order) {
        printPresentMenu(executedEvent);
        printExecuteEvent(executedEvent);
        printDiscountPrice(order);
    }

    public static void printExecuteEvent(List<Object> executedEvent) {
        System.out.println(EVENT_HISTORY_TITLE);
        if (executedEvent.isEmpty()) {
            System.out.println(NONE);
            return;
        }
        printChristmasEvent(executedEvent);
        printWeekdayEvent(executedEvent);
        printWeekendEvent(executedEvent);
        printSpecialEvent(executedEvent);
        printPresentEvent(executedEvent);
    }

    public static void printPresentMenu(List<Object> executedEvent) {
        System.out.println(PRESENT_MENU);
        for (Object eventType : executedEvent) {
            if (eventType instanceof PresentEvent) {
                System.out.println(PRESENT_CHAMPAGNE);
                System.out.println();
                return;
            }
        }
        System.out.println(NONE);
        System.out.println();
    }

    public static void printChristmasEvent(List<Object> executedEvent) {
        System.out.print(CHRISTMAS_EVENT_TITLE);
        for (Object eventType : executedEvent) {
            if (eventType instanceof ChristmasEvent) {
                ChristmasEvent event = (ChristmasEvent) eventType;
                System.out.printf(PRICE_MINUS_FORMAT, event.getDiscountPrice());
                return;
            }
        }
    }

    public static void printWeekdayEvent(List<Object> executedEvent) {
        System.out.print(WEEKDAY_EVENT_TITLE);
        for (Object eventType : executedEvent) {
            if (eventType instanceof WeekdayEvent) {
                WeekdayEvent event = (WeekdayEvent) eventType;
                System.out.printf(PRICE_MINUS_FORMAT, event.getDiscountPrice());
                return;
            }
        }
    }

    public static void printWeekendEvent(List<Object> executedEvent) {
        System.out.print(WEEKEND_EVENT_TITLE);
        for (Object eventType : executedEvent) {
            if (eventType instanceof WeekendEvent) {
                WeekendEvent event = (WeekendEvent) eventType;
                System.out.printf(PRICE_MINUS_FORMAT, event.getDiscountPrice());
                return;
            }
        }
    }

    public static void printSpecialEvent(List<Object> executedEvent) {
        System.out.print(SPECIAL_EVENT_TITLE);
        for (Object eventType : executedEvent) {
            if (eventType instanceof SpecialEvent) {
                SpecialEvent event = (SpecialEvent) eventType;
                System.out.printf(PRICE_MINUS_FORMAT, event.getDiscountPrice());
                return;
            }
        }
    }

    public static void printPresentEvent(List<Object> executedEvent) {
        System.out.print(PRESENT_EVENT_TITLE);
        for (Object eventType : executedEvent) {
            if (eventType instanceof PresentEvent) {
                PresentEvent event = (PresentEvent) eventType;
                System.out.printf(PRICE_MINUS_FORMAT, event.getDiscountPrice());
                return;
            }
        }
    }

    public static void printDiscountPrice(Order order) {
        System.out.println();
        System.out.println(TOTAL_DISCOUNT_PRICE_TITLE);
        int totalDisCountPrice = order.getTotalDiscountPrice();
        if (totalDisCountPrice == 0) {
            System.out.printf(PRICE_FORMAT, order.getTotalDiscountPrice());
            System.out.println();
            return;
        }
        System.out.printf(PRICE_MINUS_FORMAT, order.getTotalDiscountPrice());
        System.out.println();
    }

    public static void printTotalPriceContainDiscount(List<Object> executedEvent, Order order) {
        System.out.println(TOTAL_PRICE_CONTAIN_DISCOUNT);
        for (Object eventType : executedEvent) {
            if (eventType instanceof PresentEvent) {
                System.out.printf(PRICE_FORMAT,
                        order.getTotalPrice() - order.getTotalDiscountPrice() + Beverage.CHAMPAGNE.getPrice());
                System.out.println();
                return;
            }
        }
        System.out.printf(PRICE_FORMAT, order.getTotalPrice() - order.getTotalDiscountPrice());
        System.out.println();
    }

    public static void printBadgeName(String badgeName) {
        System.out.println(BADGE_NAME_TITLE);
        System.out.println(badgeName);
    }
}
