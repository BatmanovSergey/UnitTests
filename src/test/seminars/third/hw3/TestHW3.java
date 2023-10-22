package seminars.third.hw3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.third.hw.MainHW;
import static org.junit.jupiter.api.Assertions.*;

public class TestHW3 {
    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 12})
    void evenOddNumberEvenIntegerTest (int input) {
        boolean check = mainHW.evenOddNumber(input);
        assertTrue(check);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 9, 11})
    void evenOddNumberOddIntegerTest (int input) {
        boolean check = mainHW.evenOddNumber(input);
        assertFalse(check);
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 35, 80, 99})
    void checkingNumberInIntervalTest (int input) {
        boolean check = mainHW.numberInInterval(input);
        assertTrue(check);
    }

    @ParameterizedTest
    @ValueSource(ints = {24, 25, 100, 101})
    void checkingNumberNotInIntervalTest (int input) {
        boolean check = mainHW.numberInInterval(input);
        assertFalse(check);
    }
}
