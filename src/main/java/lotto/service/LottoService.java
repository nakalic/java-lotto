package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoService {
    //메서드 명이 너무 길진 않나?
    public List<Lotto> publishNumbersByPurchaseAmount(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseAmount.getMoney() / 1000; i++) {
            lottos.add(publishLotto());
        }

        return lottos;
    }

    private Lotto publishLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
