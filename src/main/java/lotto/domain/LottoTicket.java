package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    // 생성자 좀 더 공부할 것
    // 따로 생성자 안만들어줬는데 되네?
    public LottoTicket(List<Lotto> publishNumbers) {
        lottos = publishNumbers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "lottos=" + lottos +
                '}';
    }
}
