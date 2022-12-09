package lotto.Domain;

public class Money {

    private int money;

    public Money(String input) {
        validateMoney(input);
        this.money = Integer.parseInt(input);
    }

    private void validateMoney(String input) {
        isNumber(input);
        isOverThan1000(input);
        isMultiplesOf1000(input);
    }

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private void isOverThan1000(String input) {
        if (Integer.parseInt(input) < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000 이상이어야 합니다.");
        }
    }

    private void isMultiplesOf1000(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }

    //어떻게 오버라이딩 할지 고민
    @Override
    public String toString() {
        return Integer.toString(this.money / 1000);
    }
}
