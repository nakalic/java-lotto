package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMaker {
    public List<Integer> makeLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
