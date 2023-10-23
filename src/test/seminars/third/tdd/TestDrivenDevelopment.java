package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TestDrivenDevelopment {
    //3.5. Red-Green-Refactor
//    Примените подход TDD для создания нового класса MoodAnalyser, который оценивает настроение
//    выраженное во фразах.

    MoodAnalyser moodAnalyser;
    @BeforeEach
    void setUp () {
        moodAnalyser = new MoodAnalyser();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hi", "Hello", "OK"})
    void checkGoodMood (String input) {
        String actual = moodAnalyser.analyseMood(input);

        assertThat(actual).isEqualTo("Хорошо");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Bye", "Sad", "Bad"})
    void checkBadMood (String input) {
        String actual = moodAnalyser.analyseMood(input);
        assertThat(actual).isEqualTo("Плохо");
    }

    @ParameterizedTest
    @ValueSource(strings = {"..", "..", ".."})
    void checkUnknownMood (String input) {
        String actual = moodAnalyser.analyseMood(input);

        assertThat(actual).isEqualTo("Что???");
    }

}