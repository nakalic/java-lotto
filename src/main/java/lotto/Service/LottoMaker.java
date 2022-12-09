package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;

public class LottoMaker {

    public List<Lotto> makeManyLotto(int amount) {
        List<Lotto> manyLotto = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            manyLotto.add(new Lotto(makeLotto()));
        }
        return manyLotto;
    }

    public List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
