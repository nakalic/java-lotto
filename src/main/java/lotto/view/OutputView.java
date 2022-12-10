package lotto.view;

import java.util.Map.Entry;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.Reward;
import lotto.domain.WinningStatistic;
import lotto.domain.Yield;

public class OutputView {
    public void printAskPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    //개행문자를 출력하는 기능을 메서드로 추출해야할까?
    public void printInformNumberOfPurchase(PurchaseAmount purchaseAmount) {
        System.out.printf("\n%d개를 구매했습니다.\n", purchaseAmount.getMoney() / 1000);

    }

    public void printAskWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void printAskWBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        lottoTicket.getLottos()
                .stream()
                .map(Lotto::getNumbers)
                //오름차순 정렬 하려면 comparable 오버라이딩 해야결
                .forEach(System.out::println);
    }

    public void printInformWinning() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printWinningStatistic(WinningStatistic winningStatistic) {
        //스트림 이용할 것
        for (Entry<Reward, Integer> entry : winningStatistic.getStatistic().entrySet()) {
            System.out.println(entry.getKey().getSentence() + " - " + entry.getValue() + "개");
        }
    }

    public void printYield(Yield yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.", yield.getYield());
    }
}
