package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("구입금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByString() {
        assertThatThrownBy(() -> new PurchaseAmount("aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1,000보다 작다면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByLessThan1000() {
        assertThatThrownBy(() -> new PurchaseAmount("999"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1,000의 배수가 아니라면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByNotMultiplesOf1000() {
        assertThatThrownBy(() -> new PurchaseAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 더 좋은 테스트 코드가 있을까?
    // 단순히 예외만 발생하지 않으면 되는 걸까?
    @DisplayName("조건을 모두 만족하는 경우에는 예외가 발생하지 않는다.")
    @Test
    void createPurchaseAmountByNormalInput() {
        assertThatCode(() -> new PurchaseAmount("1000"))
                .doesNotThrowAnyException();
    }
}
