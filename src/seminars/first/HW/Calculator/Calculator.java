package seminars.first.HW.Calculator;

import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperation();
        int result = calculation(firstOperand, secondOperand, operator);
        System.out.printf("Результат вычисления = %d", result);
    }


    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public static int getOperand() {
        System.out.println("Введите число:");
        int operand;

        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте ещё раз");
            if (scanner.hasNextInt()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Ошибка ввода данных!");
            }
        }
        return operand;
    }


    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        if (discountAmount == 0) return purchaseAmount;
        else if (discountAmount == 100) return 0;
        else if (discountAmount < 0 || discountAmount > 100)
            throw new ArithmeticException("Неверное значение скидки");
        else
            return purchaseAmount - (purchaseAmount * discountAmount) / 100;
        // Метод должен возвращать сумму покупки со скидкой
    }
}