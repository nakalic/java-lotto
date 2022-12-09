package lotto.Domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    private void validateLotto(List<Integer> numbers) {
        checkCounts(numbers);
        checkNumberRange(numbers);
        checkEachMustBeDifferent(numbers);
    }

    private void checkCounts(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다.");
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        numbers.stream()
                .filter(num -> num < 1 || num > 45)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                });
    }

    private void checkEachMustBeDifferent(List<Integer> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 모두 달라야합니다.");
        }
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
