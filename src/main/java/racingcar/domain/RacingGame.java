package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomUtil;

public class RacingGame {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;

    private final List<RacingCar> racingCars;
    private int tryNumber;

    public RacingGame(String carName, int tryNumber) {
        racingCars = setRacingCars(carName);
        this.tryNumber = tryNumber;
    }

    private List<RacingCar> setRacingCars(String carName) {
        return Arrays.stream(carName.split(","))
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void race() {
        for (RacingCar car : racingCars) {
            int value = RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END);
            car.move(value);
        }
        tryNumber--;
    }

    public List<String> getWinners() {
        int maxPosition = maxPosition();
        return getWinnerNames(maxPosition);
    }

    private int maxPosition() {
        return racingCars.stream()
            .mapToInt(RacingCar::getPosition)
            .max().orElseThrow(() -> new IllegalArgumentException("[ERROR] 최대 위치값을 찾는데 실패했습니다."));
    }

    private List<String> getWinnerNames(int maxPosition) {
        return racingCars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(RacingCar::getName)
            .collect(Collectors.toList());
    }

    public boolean isEnd() {
        return tryNumber == 0;
    }
}

