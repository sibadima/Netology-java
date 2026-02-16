package main.java.ru.netology.core.homework01.task01;

public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);

        if (b == 0) {
            System.out.println("Делить на 0 нельзя. Ошибка!");
        } else {
            int c = calc.devide.apply(a, b);
            calc.println.accept(c);
        }
        // int c = calc.devide.apply(a, b); - ошибка, делить на 0 нельзя.


    }
}
