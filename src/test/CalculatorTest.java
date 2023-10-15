import org.junit.jupiter.api.Test;
import seminars.first.HW.Calculator.Calculator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 6, '+')).isEqualTo(8);

    }

    @Test
    void substractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(6, 2, '-')).isEqualTo(4);

    }

    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(6, 2, '*')).isEqualTo(12);
    }

    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(6, 2, '/')).isEqualTo(3);
    }

    @Test
    void expectedIllegalStateExceptionOnInValidOperatorSymbol() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculation(8, 4, '_'))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void calculatingDiscountExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculatingDiscount(100, 50)).isEqualTo(50);
    }

    @Test
    void expectedArithmeticExceptionOnInValidDiscount() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.calculatingDiscount(100, 110))
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void squareRootExtractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.squareRootExtraction(16)).isEqualTo(4);
    }

    @Test
    void squareRootExtractionExceptionOnInValidNumber() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> calculator.squareRootExtraction(-5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getOperandCompletesCorrectlyWithNumbers () {
        String testedValue = "9";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in;
        System.setIn(in);

        Calculator.getOperand();

        System.out.println(testedValue);
        System.setIn(inputStream);
    }

    @Test
    void getOperandCompletesCorrectlyWithNotNumbers () {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));

        assertThatThrownBy(() -> Calculator.getOperand()).isInstanceOf(IllegalStateException.class).
                hasMessage("Ошибка ввода данных!");

        System.setIn(inputStream);
        System.setOut(null);
    }

}