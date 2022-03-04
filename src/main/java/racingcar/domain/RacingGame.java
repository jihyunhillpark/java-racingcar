package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int tryNumber;

    public RacingGame(String carName, int tryNumber) {
        racingCars = setRacingCars(carName);
        this.tryNumber = tryNumber;
    }

    private List<RacingCar> setRacingCars(String carName) {
        return Arrays.stream(carName.split(","))
            .map(RacingCar::new)
            .collect(Collectors.toList());
    }

    public List<RacingCar> race(MoveStrategy moveStrategy) {
        List<RacingCar> raceHistory = new ArrayList<>();
        for (int i = 0; i < tryNumber; i++) {
            moveAll(raceHistory, moveStrategy);
        }
        return raceHistory;
    }

    private void moveAll(final List<RacingCar> raceHistory,
        MoveStrategy moveStrategy) {
        for (RacingCar car : racingCars) {
            raceHistory.add(car.move(moveStrategy));
        }
    }

    // TODO - 위너 구하는 로직 이동 생각
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
}

