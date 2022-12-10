package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class OutputView {
    public void printLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottos().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }
}
