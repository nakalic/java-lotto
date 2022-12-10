package lotto.controller;

import lotto.service.HitService;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    HitService hitService = new HitService();
    LottoService lottoService = new LottoService();

    public void run() {
        outputView.printAskPurchaseAmount();
        lottoService.makePurchaseAmount(inputView.readInput());

        outputView.printInformNumberOfPurchase(lottoService.getPurchaseAmount());
        lottoService.makeLottoTicket();
        outputView.printLottoTicket(lottoService.getLottoTicket());

        //WinningLotto 생성자는 WinningNumbers, BonusNumber 를 같이 입력 받아야 하는데 상태 유지를 어떻게?
        outputView.printAskWinningNumbers();
        lottoService.makeWinningNumber(inputView.readInput());
        outputView.printAskWBonusNumber();
        lottoService.makeBonusNumber(inputView.readInput());
        lottoService.makeWinningLotto();

        hitService.calculateHit(lottoService.getLottoTicket(), lottoService.getWinningLotto());
        hitService.calculateYield(hitService.getWinningStatistic(), lottoService.getPurchaseAmount());

        outputView.printInformWinning();
        outputView.printWinningStatistic(hitService.getWinningStatistic());
        outputView.printYield(hitService.getYield());

    }
}
