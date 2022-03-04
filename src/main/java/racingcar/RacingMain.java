package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        RacingGame racingGame = new RacingGame(carNames, tryNumber);
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        ResultView.printCars(racingGame.race(randomMoveStrategy));
        ResultView.printWinners(racingGame.getWinners());
    }
}
