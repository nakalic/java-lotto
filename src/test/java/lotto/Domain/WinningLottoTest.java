package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있다면 예외가 발생한다.")
    @Test
    void createWinningLottoByBonusNumberIncludedWinningNumbers() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}