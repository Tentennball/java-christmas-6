package christmas.view;

public class InputView {
    private static final String RESERVATION_DATE_PROMPT = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_REQUEST = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public static void printReservationDateDecision() {
        System.out.println(RESERVATION_DATE_PROMPT);
    }

    public static void printOrderRequest() {
        System.out.println(ORDER_REQUEST);
    }
}
