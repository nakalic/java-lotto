package lotto.domain;

public class PurchaseAmount {
    private int money;

    public PurchaseAmount(String input) {
        validatePurchaseAmount(input);
        this.money = Integer.parseInt(input);
    }

    private void validatePurchaseAmount(String input) {
        checkNumber(input);
        checkOverThan1000(input);
        checkMultiplesOf1000(input);
    }

    private void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자여야 합니다.");
        }
    }

    private void checkOverThan1000(String input) {
        if (Integer.parseInt(input) < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000보다 커야 합니다.");
        }
    }

    private void checkMultiplesOf1000(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000의 배수여야 합니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "PurchaseAmount{" +
                "money=" + money +
                '}';
    }
}
