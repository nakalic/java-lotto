package lotto.view;

import lotto.Domain.LottoTickets;
import lotto.Domain.Money;

public class OutputView {

    public void printStart() {
        System.out.println("구입금액을 입력 주세요.");
    }

    public void printAmount(Money money) {
        System.out.println(money + "개를 구매했습니다\n");
    }

    public void printPublishedLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
