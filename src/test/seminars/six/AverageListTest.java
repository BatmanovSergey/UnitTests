package seminars.six;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class AverageListTest {
    static CompareList ourlist;

    @BeforeAll
    static void setUp() {
        ourlist = new CompareList();
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testAverageValue(List<Integer> list1, double result) {
        AverageList averageList = new AverageList();
        double average = averageList.averageValue(list1);
        assertThat(average).isEqualTo(result);
    }

    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), 2),
                Arguments.of(Arrays.asList(-2, 4, -2), 0),
                Arguments.of(Arrays.asList(-3, -3, -3), -3),
                Arguments.of(Arrays.asList(2, 3), 2.5),
                Arguments.of(Arrays.asList(0, 0, 0), 0),
                Arguments.of(Arrays.asList(), 0)
        );
    }


    @Test
    public void testAverageList1BiggerAverageList2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        List<Integer> list1 = Arrays.asList(2, 3, 4);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        ourlist.compareOurLists(list1, list2);

        assertThat(out.toString()).isEqualTo("Первый список имеет большее среднее значение");

        System.setOut(null);
    }

    @Test
    public void testAverageList1LessAverageList2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 3, 4);

        ourlist.compareOurLists(list1, list2);

        assertThat(out.toString()).isEqualTo("Второй список имеет большее среднее значение");

        System.setOut(null);
    }

    @Test
    public void testAverageList1EqualAverageList2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        List<Integer> list1 = Arrays.asList(5, 5, 5);
        List<Integer> list2 = Arrays.asList(4, 8, 3);

        ourlist.compareOurLists(list1, list2);

        assertThat(out.toString()).isEqualTo("Средние значения равны");

        System.setOut(null);
    }
}
