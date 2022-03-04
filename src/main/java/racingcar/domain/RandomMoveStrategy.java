package racingcar.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int THRESHOLD = 4;
    private static final int BOUND = 10;
    private static final Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(BOUND) >= THRESHOLD;
    }
}
