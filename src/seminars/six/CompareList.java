package seminars.six;

import java.util.List;

public class CompareList {
    AverageOfList average = new AverageOfList();

    public void compareOurLists(List<Integer> list1, List<Integer> list2) {
        double a1 = average.averageValue(list1);
        double a2 = average.averageValue(list2);
        if (a1 > a2) System.out.print("Первый список имеет большее среднее значение");
        else if (a1 < a2) System.out.print("Второй список имеет большее среднее значение");
        else System.out.print("Средние значения равны");
    }
}
