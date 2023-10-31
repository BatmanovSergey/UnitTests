package seminars.six;


import java.util.List;

public class AverageList {

    public double averageValue(List<Integer> list) {
        double sum = 0;
        for (int i: list) {
            sum += i;
        }
        return list.size() > 0 ? sum / list.size() : 0;
    }
}
