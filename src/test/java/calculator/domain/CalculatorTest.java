package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("정상동작 테스트")
    void testRun() {
        List<String> formula = Arrays.asList("1", "+", "3", "-", "5");
        double result = Calculator.run(formula);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("더하기 테스트")
    void testPlus() {
        double result = Operation.PLUS.apply(3.0, 7.0);
        assertThat(result).isEqualTo(10.0);
    }

    @Test
    @DisplayName("빼기 테스트")
    void testMinus() {
        double result = Operation.MINUS.apply(7.0, 3.0);
        assertThat(result).isEqualTo(4.0);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void testMultiply() {
        double result = Operation.TIMES.apply(7, 3);
        assertThat(result).isEqualTo(21.0);
    }

    @Test
    @DisplayName("나누기 테스트")
    void testDivide() {
        double result = Operation.DIVIDE.apply(6.0, 3.0);
        assertThat(result).isEqualTo(2.0);
    }
}