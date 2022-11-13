package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final Map<Reward, Integer> result = new LinkedHashMap<>() {{
        put(Reward.FIFTH, 0);
        put(Reward.FOURTH, 0);
        put(Reward.THIRD, 0);
        put(Reward.SECOND, 0);
        put(Reward.FIRST, 0);
    }};

    public List<Lotto> publishLotto(int count) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lotto;
    }

    public void calculateResult(List<Lotto> userLotto, Lotto winningNumber, int bonusNumber) {
        for (int i = 0; i < userLotto.size(); i++) {
            int bingo = userLotto.get(i)
                    .getNumbers()
                    .stream()
                    .filter(s -> winningNumber.isContain(s))
                    .mapToInt(n -> 1)
                    .sum();

            boolean bonus = userLotto.get(i).isContain(bonusNumber);

            if (3 <= bingo && bingo <= 6) {
                result.put((Reward.getRanKing(bingo, bonus)), result.get(Reward.getRanKing(bingo, bonus)) + 1);
            }
        }

    }
}