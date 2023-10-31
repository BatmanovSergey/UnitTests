package seminars.six;

import java.util.List;

public class CompareList {
    AverageList averageList = new AverageList();

    public void compareOurLists(List<Integer> list1, List<Integer> list2) {
        double a1 = averageList.averageValue(list1);
        double a2 = averageList.averageValue(list2);
        if (a1 > a2) System.out.print("Первый список имеет большее среднее значение");
        else if (a1 < a2) System.out.print("Второй список имеет большее среднее значение");
        else System.out.print("Средние значения равны");
    }
}
