package lotto.Service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Domain.Lotto;

public class LottoMaker {

    //매개변수 Money 타입으로 바꾸는데 getter가 없어서 어떻게 하지 ?
    public List<Lotto> makeManyLotto(int amount) {
        List<Lotto> manyLotto = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            manyLotto.add(new Lotto(makeLotto()));
        }
        return manyLotto;
    }

    public Lotto makeWinningLotto(String input) {
        return new Lotto(Stream.of(Console.readLine().split("\\s*,\\s*"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));
    }

    public List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
