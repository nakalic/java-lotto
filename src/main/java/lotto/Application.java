package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }
}

// 예외 처리 어디서 할 지?
// 오름차순 정렬 stream -> ClassCastException comparable 해결