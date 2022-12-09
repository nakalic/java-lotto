package lotto.controller;

import lotto.Domain.Lotto;
import lotto.Domain.LottoNumber;
import lotto.Domain.LottoTickets;
import lotto.Domain.Money;
import lotto.Domain.WinningLotto;
import lotto.Service.LottoMaker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    LottoMaker lottoMaker = new LottoMaker();
    LottoTickets lottoTickets;
    Money money; // 생성과 초기화를 다르게 해주는게 이상함
    WinningLotto winningLotto;

    public void run() {
        getMoney();
        buyLottoTickets();
        getWinningLotto(getWinningNumber(), getBonusNumber());
        System.out.println(winningLotto);
    }

    private void getWinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        winningLotto = new WinningLotto(winningNumber.getNumbers(), bonusNumber.getNumber());
    }

    private LottoNumber getBonusNumber() {
        outputView.printBonusNumber();
        return new LottoNumber(inputView.read());
    }

    private Lotto getWinningNumber() {
        outputView.printWinningNumber();
        return lottoMaker.makeWinningLotto(inputView.read());
    }

    private void buyLottoTickets() {
        outputView.printAmount(money);
        lottoTickets = new LottoTickets(lottoMaker.makeManyLotto(8));
        outputView.printPublishedLottoTickets(lottoTickets);
    }

    private void getMoney() {
        outputView.printStart();
        money = new Money(inputView.read());
    }

}
