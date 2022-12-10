package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseAmount;
import lotto.domain.Reward;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistic;

public class HitService {
    public WinningStatistic calculateHit(LottoTicket lottoTicket, WinningLotto winningLotto) {
        Map<Reward, Integer> enumMap = new EnumMap<>(Reward.class);

        //일단 구현하고 Stream 을 생각해보자
        for (int i = 0; i < lottoTicket.getLottos().size(); i++) {
            int hit = 0;
            int bonusHit = 0;
            for (int num : lottoTicket.getLottos().get(i).getNumbers()) {
                if (winningLotto.getWinningNumbers().getNumbers().contains(num)) {
                    hit += 1;
                    continue;
                }
                if (winningLotto.getBonusNumber() == num) {
                    bonusHit += 1;
                }
            }
            checkLottoHit(enumMap, hit, bonusHit);
        }
        return new WinningStatistic(enumMap);
    }

    public double calculateYield(WinningStatistic winningStatistic, PurchaseAmount purchaseAmount) {
        int sum = winningStatistic.getStatistic().entrySet()
                .stream()
                .mapToInt(reward -> reward.getKey().getReward() * reward.getValue())
                .sum();

        //소수 첫째자리 반올림
        return Math.round(sum * 1000 / purchaseAmount.getMoney()) / 10.0;
    }

    private void checkLottoHit(Map<Reward, Integer> map, int hit, int bonusHit) {
        if (hit == 6) {
            map.put(Reward.FIRST, 1);
        }
        if (hit == 5 && bonusHit == 1) {
            map.put(Reward.SECOND, 1);
        }
        if (hit == 5) {
            map.put(Reward.THIRD, 1);
        }
        if (hit == 4) {
            map.put(Reward.FOURTH, 1);
        }
        if (hit == 3) {
            map.put(Reward.FIFTH, 1);
        }
    }
}
