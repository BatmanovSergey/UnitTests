package seminars.third.tdd;

import java.util.Arrays;
public class MoodAnalyser {
    //3.5. Red-Green-Refactor
//    Примените подход TDD для создания нового класса MoodAnalyser, который оценивает настроение
//    выраженное во фразах.
    String [] good = new String[] {"Hi", "Hello", "OK"};
    String [] bad = new String[] {"Bye", "Sad", "Bad"};
    public String analyseMood(String message) {
        if (Arrays.asList(good).contains(message)) return "Хорошо";
        if (Arrays.asList(bad).contains(message)) return "Плохо";
        // если мы хотим воспользоваться методами для примитивных типов,
        // то используем вспомогательный класс Arrays.
        // если мы хотим воспользоваться методами для коллекций,
        // то используем вспомогательный класс Collections.
        return "Что???";
    }

}