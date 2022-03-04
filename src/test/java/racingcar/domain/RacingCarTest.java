package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class RacingCarTest {

    @Test
    @DisplayName("자동차 이름의 길이가 5 보다 크면 IllegalArgumentException 이 발생한다")
    void When_CarNameLengthIsMoreThan5_Expect_IllegalArgumentException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCar("gdgdgdgdgdg"));
    }

    @ValueSource(strings = {"testN", "jason", "pobi", "j"})
    @ParameterizedTest
    @DisplayName("4이상의 숫자가 나왔을 때 자동차는 1씩 전진한다")
    void When_NumberIs4OrMore_Expect_MoveForward(String name) {
        RacingCar car = new RacingCar(name);
        car.move(()->true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ValueSource(strings = {"testN", "jason", "pobi", "j"})
    @ParameterizedTest
    @DisplayName("4미만의 숫자가 나왔을 때 자동차는 움직이지 않는다.")
    void When_NumberIsLowerThan4_Expect_Stop(String name) {
        RacingCar car = new RacingCar(name);
        car.move(() -> false);
        assertThat(car.getPosition()).isZero();
    }

}
