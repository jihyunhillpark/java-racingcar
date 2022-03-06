package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.ResultView;

class RacingGameTest {

    @DisplayName("움직이는 조건이 없이 정지만 하는 조건이 주어진다면 모든 race에서 움직이는 차는 없어야 한다.")
    @ValueSource(ints = {1, 2, 3, 4})
    @ParameterizedTest
    void when_moving_strategy_is_not_moving_Expect_all_cars_to_stop(int tryNumber) {
        RacingGame racingGame = new RacingGame("jason, pobi,js", tryNumber);
        racingGame.race(() -> false);
        ResultView.printWinners(racingGame.getWinners());
        assertThat(racingGame.getWinners()).extracting("name", "position")
            .contains(
                tuple("jason", 0),
                tuple("pobi", 0),
                tuple("js", 0)
            );
    }

    @DisplayName("경주마다 무조건 움직이는 조건이 주어진다면 모든 race에서 모든 차들은 움직인다.")
    @ValueSource(ints = {1, 2, 3, 4})
    @ParameterizedTest
    void when_moving_strategy_is_must_move_Expect_all_cars_to_move(int tryNumber) {
        RacingGame racingGame = new RacingGame("jason, pobi,js", tryNumber);
        racingGame.race(() -> true);
        ResultView.printWinners(racingGame.getWinners());
        assertThat(racingGame.getWinners()).extracting("name", "position")
            .contains(
                tuple("jason", tryNumber),
                tuple("pobi", tryNumber),
                tuple("js", tryNumber)
            );
    }
}