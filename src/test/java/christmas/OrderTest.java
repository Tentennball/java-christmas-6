package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.service.OrderService;

public class OrderTest {
    private OrderService orderService = new OrderService();

    @DisplayName("메뉴판에 없는 메뉴 입력시 오류가 발생한다.")
    @Test
    void inputInvalidMenu() {
        assertThatThrownBy(() -> orderService.initMenu("가나다라-2,크리스마스파스타-5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴판에 중복된 메뉴 입력시 오류가 발생한다.")
    @Test
    void inputDuplicateMenu() {
        assertThatThrownBy(() -> orderService.initMenu("초코케이크-2,크리스마스파스타-5,초코케이크-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
