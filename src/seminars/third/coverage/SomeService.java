package seminars.third.coverage;

public class SomeService {

    /**
     * 3.1. Создайте набор тестов, полностью покрывающих все ветви кода функции fizzBuzz. Эта
     * функция принимает на вход число и возвращает "Fizz", если число делится на 3, "Buzz",
     * если число делится на 5, и "FizzBuzz", если число делится на 15. Если число не делится ни
     * на 3, ни на 5, ни на 15, функция возвращает входное число в виде строки.
     */
    public String fizzBuzz(int input) {
        if (input % 3 == 0 && input % 5 == 0) return "FizzBuzz";
        if (input % 3 == 0) return "Fizz";
        if (input % 5 == 0) return "Buzz";
        return String.valueOf(input);
    }

    /**
     * 3.2. Метод возвращает true для массивов, которые начинаются или заканчиваются 6,
     * и false - если 6 нет ни в начале ни в конце массива
     */
    public boolean firstLast6(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums[0] == 6 || nums[nums.length - 1] == 6) return true;
        return false;
    }


    /**
     * 3.3. Создайте тесты, обеспечивающие полное покрытие кода метода calculatingDiscount, который принимает сумму
     * покупки и размер скидки, затем вычисляет и возвращает сумму с учетом скидки. Метод должен обрабатывать
     * исключения, связанные с некорректным размером скидки или отрицательной суммой покупки.
     */
    public double calculatingDiscount(double purchase, int discount) {
        if (purchase < 0)
            throw new IllegalArgumentException("Сумма покупки не может быть меньше нуля");
        if (discount < 0)
            throw new IllegalArgumentException("Скидка не может быть меньше нуля");
        if (discount > 100)
            throw new IllegalArgumentException("Скидка не может быть больше 100 %");
        return purchase - purchase * discount / 100;
    }

    /**
     * 3.4. Метод принимает на вход 3 числа (int a, b, c). Нужно вернуть их сумму. Однако, если одно из значений равно 13,
     * то оно не учитывается в сумме. Так, например, если b равно 13, то считается сумма только a и c.
     */
    public double calculatingSumThreeNumbers(int first, int second, int third) {
        int result = 0;
        if (first != 13) result += first;
        if (second != 13) result += second;
        if (third != 13) result += third;

        return result;
    }


}