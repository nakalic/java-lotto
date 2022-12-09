package lotto.Domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> publishedLotto) {
        lottoTickets = new ArrayList<>();
        this.lottoTickets.addAll(publishedLotto);
    }

    @Override
    public String toString() {
        //이런건 어떻게 오버라이딩? 스트림으로 바꿀 수 있나 ?
        StringBuilder string = new StringBuilder();
        for (Lotto c : lottoTickets) {
            string.append(c.toString());
            string.append("\n");
        }

        return string.toString();
    }
}
