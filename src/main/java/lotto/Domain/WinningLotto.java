package lotto.Domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers, int number) {
        validateBonusNumber(numbers, number);
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(number);
    }

    private void validateBonusNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다.");
        }
    }
}
