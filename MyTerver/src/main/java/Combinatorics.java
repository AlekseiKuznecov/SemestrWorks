import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combinatorics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Чтобы посчитать перестановки, нажмите  цифру 1
                Чтобы посчитать сочетания, нажмите цифру 2
                Чтобы посчитать размещения, нажмите цифру 3""");
        int choice1 = scanner.nextInt();
        System.out.println("""
                Подсчет будет с повторениями или нет?
                Нажмите '1', если без повторений
                Нажмите '2', если с повторениями'""");
        int choice2 = scanner.nextInt();
        if (choice1 == 1 & choice2 == 1) { // Перестановка без повторений
            System.out.println("Введите количество элементов n: ");
            int n = scanner.nextInt();
            while (n < 0) {
                System.out.println("Количество элементов должно быть >= 0");
                System.out.println("Введите количество элементов n: ");
                n = scanner.nextInt();
            }
            System.out.println("Результат равен: ");
            System.out.println(BigIntegerMath.factorial(n));
        }
        if (choice1 == 1 & choice2 == 2) { // Перестановка с повторениями
            System.out.println("Введите количество элементов n: ");
            int amount = scanner.nextInt();
            while (amount < 0) {
                System.out.println("Количество элементов должно быть >= 0");
                System.out.println("Введите количество элементов n: ");
                amount = scanner.nextInt();
            }
            List<Integer> listOfK = new ArrayList<>();
            System.out.println("Введите элементы n: ");
            for (int i = 0; i < amount; i++) {
                int n = scanner.nextInt();
                while (n<0) {
                    System.out.println("Вы ввели отрицательное число n, заново введите n>=0");
                    n = scanner.nextInt();
                }
                listOfK.add(n);
            }
            int n = listOfK.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            BigInteger numerator = BigIntegerMath.factorial(n);
            BigInteger denominator = BigInteger.ONE;
            for (int i = 0; i < listOfK.size(); i++) {
                denominator = denominator.multiply(BigIntegerMath.factorial(listOfK.get(i)));
            }
            System.out.println("Результат равен: ");
            System.out.println(numerator.divide(denominator));
        }
        if (choice1 == 2 & choice2 == 1) { //Сочетание без повторений
            System.out.println("Введите количество элементов n: ");
            int n = scanner.nextInt();
            while (n < 0) {
                System.out.println("n должно быть >= 0");
                System.out.println("Введите количество элементов n: ");
                n = scanner.nextInt();
            }
            System.out.println("Введите количество элементов m: ");
            int m = scanner.nextInt();
            while (m < 0) {
                System.out.println("m должно быть >= 0");
                System.out.println("Введите количество элементов m: ");
                m = scanner.nextInt();
            }
            while (n-m < 0) {
                System.out.println("n должно быть >= m");
                System.out.println("Заново введите количество элементов n: ");
                n = scanner.nextInt();
                while (n < 0) {
                    System.out.println("n должно быть >= 0");
                    System.out.println("Введите количество элементов n: ");
                    n = scanner.nextInt();
                }
                System.out.println("Заново введите количество элементов m: ");
                m = scanner.nextInt();
                while (m < 0) {
                    System.out.println("m должно быть >= 0");
                    System.out.println("Введите количество элементов m: ");
                    m = scanner.nextInt();
                }
            }
            System.out.println("Результат равен: ");
            System.out.println(BigIntegerMath.factorial(n).divide(BigIntegerMath.factorial(n-m).multiply(BigIntegerMath.factorial(m))));
        }
        if (choice1 == 2 & choice2 == 2) { //Сочетание с повторениями
            System.out.println("Введите количество элементов n: ");
            int n = scanner.nextInt();
            while (n < 0) {
                System.out.println("n должно быть >= 0");
                System.out.println("Введите количество элементов n: ");
                n = scanner.nextInt();
            }
            System.out.println("Введите количество элементов m: ");
            int m = scanner.nextInt();
            while (m < 0) {
                System.out.println("m должно быть >= 0");
                System.out.println("Введите количество элементов m: ");
                m = scanner.nextInt();
            }
            System.out.println("Результат равен: ");
            System.out.println(BigIntegerMath.factorial(n+m-1).divide(BigIntegerMath.factorial(n+m-1-m).multiply(BigIntegerMath.factorial(m))));
        }
        if (choice1 == 3 & choice2 == 1) { //Размещение без повторений
            System.out.println("Введите количество элементов n: ");
            int n = scanner.nextInt();
            while (n < 0) {
                System.out.println("n должно быть >= 0");
                System.out.println("Введите количество элементов n: ");
                n = scanner.nextInt();
            }
            System.out.println("Введите количество элементов m: ");
            int m = scanner.nextInt();
            while (m < 0) {
                System.out.println("m должно быть >= 0");
                System.out.println("Введите количество элементов m: ");
                m = scanner.nextInt();
            }
            while (n-m < 0) {
                System.out.println("n должно быть >= m");
                System.out.println("Заново введите количество элементов n: ");
                n = scanner.nextInt();
                while (n < 0) {
                    System.out.println("n должно быть >= 0");
                    System.out.println("Введите количество элементов n: ");
                    n = scanner.nextInt();
                }
                System.out.println("Заново введите количество элементов m: ");
                m = scanner.nextInt();
                while (m < 0) {
                    System.out.println("m должно быть >= 0");
                    System.out.println("Введите количество элементов m: ");
                    m = scanner.nextInt();
                }
            }
            System.out.println("Результат равен: ");
            System.out.println(BigIntegerMath.factorial(n).divide(BigIntegerMath.factorial(n-m)));
        }
        if (choice1 == 3 & choice2 == 2) { //Размещение с повторениями
            System.out.println("Введите количество элементов n: ");
            BigInteger n = scanner.nextBigInteger();
            while (n.intValue() < 0) {
                System.out.println("n должно быть >= 0");
                System.out.println("Введите количество элементов n: ");
                n = scanner.nextBigInteger();
            }
            System.out.println("Введите количество элементов m: ");
            int m = scanner.nextInt();
            while (m < 0) {
                System.out.println("m должно быть >= 0");
                System.out.println("Введите количество элементов m: ");
                m = scanner.nextInt();
            }
            System.out.println("Результат равен: ");
            System.out.println(n.pow(m));
        }
    }
}
