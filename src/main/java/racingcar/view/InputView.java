package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getCarNames() {
        String input = "";
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        try {
            input = scanner.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return input;
    }

    public static int getTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber = 0;
        try {
            tryNumber = scanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        return tryNumber;
    }
}
