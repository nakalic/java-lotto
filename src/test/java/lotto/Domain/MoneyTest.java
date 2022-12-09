package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("구입 금액은 숫자여야 한다.")
    @Test
    void createNotNumber() {
        assertThatThrownBy(() -> new Money("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액은 1,000 이상이어야 한다.")
    @Test
    void createNotBiggerThan1000() {
        assertThatThrownBy(() -> new Money("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액은 1,000으로 나누어 떨어져야 한다.")
    @Test
    void createNotMultipleOf1000() {
        assertThatThrownBy(() -> new Money("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
