package christmas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.HashMap;
import christmas.controller.OrderController;
import christmas.domain.Badge;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.service.OrderService;

public class OrderTest {

    @DisplayName("메뉴를 0개 주문시 오류가 발생한다.")
    @Test
    void orderCountIsZero() {
        Map<String, Integer> menuInfo = new HashMap<String, Integer>();
        menuInfo.put("해산물파스타", 0);
        assertThatThrownBy(() -> new Menu(menuInfo))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴를 올바르게 입력했다면 해당한 메뉴가 저장된다.")
    @Test
    void correctInitMenu() {
        OrderService orderService = new OrderService();
        Menu menu = orderService.initMenu("해산물파스타-2,샴페인-3");
        assertThat(menu.getMenuInfo()).containsEntry("해산물파스타", 2);
        assertThat(menu.getMenuInfo()).containsEntry("샴페인", 3);
    }

    @DisplayName("메뉴를 올바르게 입력했다면 메뉴가격이 올바르게 저장된다.")
    @Test
    void correctInitTotalPrice() {
        OrderController orderController = new OrderController();
        OrderService orderService = new OrderService();
        Order order = new Order();
        Menu menu = orderService.initMenu("해산물파스타-2,샴페인-3");
        orderController.generateOrderCount(menu.getMenuInfo(), order);
        assertEquals(order.getTotalPrice(), 145000);
    }

    @DisplayName("할인금액에 따라 올바른 배지가 할당된다.")
    @Test
    void correctInitBadge() {
        Badge badge = new Badge(12000);
        String badgeName = badge.getBadgeName();
        assertEquals(badgeName, "트리");
    }
}
