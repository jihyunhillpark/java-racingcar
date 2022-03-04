package racingcar.view;

import java.util.Collections;
import java.util.List;
import racingcar.domain.RacingCar;

public class ResultView {

    private ResultView() {
    }

    public static void printCars(List<RacingCar> cars) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행결과\n");
        cars.forEach(car -> {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append(String.join("", Collections.nCopies(car.getPosition(), "-")));
            sb.append("\n");
        });
        System.out.println(sb);
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자: " + String.join(", ", winners));
    }

}
