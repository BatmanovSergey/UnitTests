package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class SomeServiceTest {
    // 3.1.**************************************************************************
    SomeService service;

    @BeforeEach
    void setUp() {
        service = new SomeService();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 12})
        // проверяется каждое значение по очереди
    void multipleThreeNotFiveReturnsFizz(int input) {
        String actual = service.fizzBuzz(input);
        assertThat(actual).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 25})
        // проверяется каждое значение по очереди
    void multipleFiveNotThreeReturnsBuzz(int input) {
        String actual = service.fizzBuzz(input);
        assertThat(actual).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60})
        // проверяется каждое значение по очереди
    void multipleFiveWithThreeReturnsFizzBuzz(int input) {
        String actual = service.fizzBuzz(input);
        assertThat(actual).isEqualTo("FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 31, 46, 61})
        // проверяется каждое значение по очереди
    void multipleNoFiveNoThreeReturnsValue(int input) {
        String actual = service.fizzBuzz(input);
        assertThat(actual).isEqualTo(String.valueOf(input));
    }

    // 3.2. ************************************************************
    @Test
    void checkNullableArray() {
        boolean actual = service.firstLast6(null);
        assertFalse(actual);
    }

    @Test
    void checkEmptyArray() {
        boolean actual = service.firstLast6(new int[]{});
        assertFalse(actual);
    }

    @Test
    void checkWithout6Array() {
        boolean actual = service.firstLast6(new int[]{0, 0, 0});
        assertFalse(actual);
    }

    @Test
    void checkFirst6Array() {
        boolean actual = service.firstLast6(new int[]{6, 0, 0});
        assertTrue(actual);
    }

    @Test
    void checkLast6Array() {
        boolean actual = service.firstLast6(new int[]{0, 0, 6});
        assertTrue(actual);
    }

    @Test
    void checkMiddle6Array() {
        boolean actual = service.firstLast6(new int[]{0, 6, 0});
        assertFalse(actual);
    }

    @Test
    void checkInFirstAndLast6Array() {
        boolean actual = service.firstLast6(new int[]{6, 0, 6});
        assertTrue(actual);
    }

    // 3.3.******************************************************************
    @ParameterizedTest
    @CsvSource(value = {"100, 50", "200, 30", "1000, 20"})
    // можно передавать сразу разные типы и более одного параметра за раз
    // для массивов value={},{},{},type = int[].class
    void checkCalculateDiscountPositive(double purchase, int discount) {
        double actual = service.calculatingDiscount(purchase, discount);
        assertThat(actual).isEqualTo(purchase - purchase * discount / 100);
    }

    @ParameterizedTest
    @CsvSource(value = {"-100, 50", "-200, 30", "-1000, 20"})
        // можно передавать сразу разные типы и более одного параметра за раз
        // для массивов value={},{},{},type = int[].class
    void checkCalculateDiscountWithNegPurchaseNegative(double purchase, int discount) {
        // вариант 1 assertJ
        assertThatThrownBy(() -> service.calculatingDiscount(purchase, discount)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("Сумма покупки не может быть меньше нуля");
        // вариант 2 Jupiter
        // Throwable лучше писать в джаве
        Exception exc = assertThrows(IllegalArgumentException.class,
                () -> service.calculatingDiscount(purchase, discount));
        assertThat(exc.getMessage()).isEqualTo("Сумма покупки не может быть меньше нуля");
    }

    @ParameterizedTest
    @CsvSource(value = {"100, -50", "200, -30", "1000, -20"})
        // можно передавать сразу разные типы и более одного параметра за раз
        // для массивов value={},{},{},type = int[].class
    void checkCalculateDiscountWithNegDiscountNegative(double purchase, int discount) {
        // вариант 1 assertJ
        assertThatThrownBy(() -> service.calculatingDiscount(purchase, discount)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("Скидка не может быть меньше нуля");
        // вариант 2 Jupiter
        Throwable exc = assertThrows(IllegalArgumentException.class,
                () -> service.calculatingDiscount(purchase, discount));
        assertThat(exc.getMessage()).isEqualTo("Скидка не может быть меньше нуля");
    }

    @ParameterizedTest
    @CsvSource(value = {"100, 150", "200, 130", "1000, 120"})
        // можно передавать сразу разные типы и более одного параметра за раз
        // для массивов value={},{},{},type = int[].class
    void checkCalculateDiscountWithBigDiscountNegative(double purchase, int discount) {
        // вариант 1 assertJ
        assertThatThrownBy(() -> service.calculatingDiscount(purchase, discount)).
                isInstanceOf(IllegalArgumentException.class).
                hasMessage("Скидка не может быть больше 100 %");
        // вариант 2 Jupiter
        // Throwable лучше писать в джаве
        Exception exc = assertThrows(IllegalArgumentException.class,
                () -> service.calculatingDiscount(purchase, discount));
        assertThat(exc.getMessage()).isEqualTo("Скидка не может быть больше 100 %");
    }

    //3.4. ************************************************************************
    @Test
    void checkSumThreeNumbersPositiveResult() {
        double actual = service.calculatingSumThreeNumbers(1, 2, 3);
        assertThat(actual).isEqualTo(6);
    }

    @Test
    void checkSumThreeNumbersNegativeResult() {
        assertThat(service.calculatingSumThreeNumbers(13, 2, 3)).
                isEqualTo(5);
        assertThat(service.calculatingSumThreeNumbers(1, 2, 13)).
                isEqualTo(3);
        assertThat(service.calculatingSumThreeNumbers(1, 13, 3)).
                isEqualTo(4);

        assertThat(service.calculatingSumThreeNumbers(13, 13, 3)).
                isEqualTo(3);
        assertThat(service.calculatingSumThreeNumbers(1, 13, 13)).
                isEqualTo(1);
        assertThat(service.calculatingSumThreeNumbers(13, 2, 13)).
                isEqualTo(2);

        assertThat(service.calculatingSumThreeNumbers(13, 13, 13)).
                isEqualTo(0);
    }
}