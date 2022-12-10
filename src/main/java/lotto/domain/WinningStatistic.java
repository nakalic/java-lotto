package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class WinningStatistic {
    //final 사용 ?
    private Map<Reward, Integer> statistic = new EnumMap<>(Reward.class);

    public WinningStatistic(Map<Reward,Integer> enumMap) {
        statistic.put(Reward.SECOND, 0);
        statistic.put(Reward.THIRD, 0);
        statistic.put(Reward.FOURTH, 0);
        statistic.put(Reward.FIFTH, 0);
        statistic.put(Reward.FIRST, 0);
        this.statistic.putAll(enumMap);
    }

    public Map<Reward, Integer> getStatistic() {
        return statistic;
    }

    @Override
    public String toString() {
        return "WinningStatistic{" +
                "statistic=" + statistic +
                '}';
    }
}
