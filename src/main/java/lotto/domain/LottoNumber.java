package lotto.domain;

public class LottoNumber {
    private final int number;

    public LottoNumber(String input) {
        validateLottoNumber(input);
        this.number = Integer.parseInt(input);
    }

    private void validateLottoNumber(String input) {
        checkIsNumber(input);
        checkNumberRange(input);
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

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
