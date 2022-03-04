package racingcar.domain;

public class RacingCar {

    private static final int DEFAULT_POSITION = 0;
    private static final int NAME_SIZE = 5;

    private final String name;
    private int position;

    public RacingCar(String name) {
        this(name, DEFAULT_POSITION);
    }

    private RacingCar(final String name, final int position) {
        validateNameSize(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateNameSize(String name) {
        if (name.length() > NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과했습니다!");
        }
    }

    public RacingCar move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMove()) {
            return new RacingCar(name, ++position);
        }
        return new RacingCar(name, position);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }
}

