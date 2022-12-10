package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class LottoService {
    private PurchaseAmount purchaseAmount;
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    // 생성자때문에 어쩔 수 없이 생성
    private String winning;
    private String bonus;

    public void makePurchaseAmount(String input) {
        purchaseAmount = new PurchaseAmount(input);
    }

    public void makeLottoTicket() {
        lottoTicket = new LottoTicket(publishNumbersByPurchaseAmount(purchaseAmount));
    }

    public void makeWinningNumber(String input) {
        this.winning = input;
    }

    public void makeBonusNumber(String input) {
        this.bonus = input;
    }

    public void makeWinningLotto() {
        winningLotto = new WinningLotto(winning, bonus);
    }

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

    public PurchaseAmount getPurchaseAmount() {
        return purchaseAmount;
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

}
