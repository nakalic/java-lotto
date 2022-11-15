package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Domain.Lotto;
import lotto.Validator.LottoValidator;

public class InputView {

    public static String getInput() {
        String input = Console.readLine();
        return input;
    }

    public static int calculateAmount(String input) {
        int money = Integer.parseInt(input);

        return money / 1000;
    }

    public static Lotto getWinningNumber() {
        String inputNumber = Console.readLine();
        Lotto lotto = new Lotto(Stream.of(inputNumber.split("\\s*,\\s*"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));

        LottoValidator.validateWinningNumber(lotto);
        return lotto;
    }

    public static int getBonusNumber(Lotto winningNumber) {
        int BonusNumber = Integer.parseInt(Console.readLine());
        LottoValidator.validateBonusNumber(winningNumber, BonusNumber);

        return BonusNumber;
    }
}
