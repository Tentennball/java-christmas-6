package christmas;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import christmas.domain.Date;

class DateTest {

    @DisplayName("예약 날짜의 범위를 벗어나면 오류가 발생한다.")
    @Test
    void createOutOfRangeDate() {
        assertThatThrownBy(() -> new Date("32"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Date("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}