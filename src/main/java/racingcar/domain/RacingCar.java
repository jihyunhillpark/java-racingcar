package racingcar.domain;

import racingcar.util.RandomUtil;

public class RacingCar {

    private final String name;

    private int position = 0;

    private static final int RANDOM_START = 0;

    private static final int RANDOM_END = 9;

    private static final int THRESHOLD = 4;

    private static final int NAME_SIZE = 5;


    public RacingCar(String name) {
        isCorrectNameSize(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        int randomNum = RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END);
        if (THRESHOLD <= randomNum) {
            position++;
        }
    }

    private void isCorrectNameSize(String name) {
        if (NAME_SIZE < name.length()) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과했습니다!");
        }
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}