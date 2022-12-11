package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {
    private final Lotto winningNumbers;
    //한번만 사용할건데 포장해야할까? 오버엔지니어링은 아닐까?
    private final int bonusNumber;

    // List<Integer> winningNumbers, int number 으로 받아야 하나?
    // 검증 책임은 누구한테 ? LottoService? WinningLotto?
    // LottoNumber 에서 숫자인걸 검증하는데 이럴 경우 winningNumbers 에 포함되어 있지 않은지 어떻게 검증하지?
    public WinningLotto(String winningNumbers, String number) {
        validate(winningNumbers, number);
        this.winningNumbers = new Lotto(extractNumbers(winningNumbers));
        this.bonusNumber = Integer.parseInt(number);
    }

    private void validate(String winningNumbers, String number) {
        checkIsNumber(number);
        checkNumberRange(number);
        bonusNumberNotIncludedWinningNumbers(extractNumbers(winningNumbers), Integer.parseInt(number));
    }

    private void bonusNumberNotIncludedWinningNumbers(List<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함되어 있지 않는 수여야 합니다.");
        }
    }

    private List<Integer> extractNumbers(String winningNumbers) {
        return Stream.of(winningNumbers.split("\\s*,\\s*"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

    }

    private void checkIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private void checkNumberRange(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "winningNumbers=" + winningNumbers +
                ", bonusNumber=" + bonusNumber +
                '}';
    }
}
