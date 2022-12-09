package lotto.Domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    //매개변수로 Lotto, LottoNumber 받고 싶은데 getter 없이 어떻게 ?
    public WinningLotto(List<Integer> numbers, int number) {
        validateBonusNumber(numbers, number);
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(Integer.toString(number));
    }

    private void validateBonusNumber(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다.");
        }
    }
}
