import java.util.Scanner;

public class Main {
    public static String calc(String input) {
        input = input.trim().replaceAll(" ", "");
        int num1;
        int num2;
        String op;
        String[] array = input.trim().split("");
        if (array.length > 5 | array.length < 3)
            throw new RuntimeException("Некорректный ввод данных. Введите числа от 1 до 10. используйте следующие операнды: *,/,-,+");
        if (array.length == 5) {
            try {
                num1 = Integer.parseInt(Integer.parseInt(array[0]) + array[1]);
                num2 = Integer.parseInt(Integer.parseInt(array[3]) + array[4]);
                op = array[2];
            } catch (Exception exception) {
                throw new RuntimeException("Некорректный ввод данных. Введите числа от 1 до 10. используйте следующие операнды: *,/,-,+");
            }
        } else if (array.length == 4) {
            try {
                num1 = Integer.parseInt(Integer.parseInt(array[0]) + array[1]);
                num2 = Integer.parseInt(array[3]);
                op = array[2];
            } catch (Exception exception) {
                try {
                    num1 = Integer.parseInt(array[0]);
                    num2 = Integer.parseInt(Integer.parseInt(array[2]) + array[3]);
                    op = array[1];
                } catch (Exception exc) {
                    throw new RuntimeException("Некорректный ввод данных. Введите числа от 1 до 10. используйте следующие операнды: *,/,-,+");
                }
            }
        } else {
            try {
                num1 = Integer.parseInt(array[0]);
                num2 = Integer.parseInt(array[2]);
                op = array[1];
            } catch (Exception exc) {
                throw new RuntimeException("Некорректный ввод данных. Введите числа от 1 до 10. используйте следующие операнды: *,/,-,+");
            }
        }
        int ans = 0;
        switch (op) {
            case "*" -> ans = num1 * num2;
            case "+" -> ans = num1 + num2;
            case "-" -> ans = num1 - num2;
            case "/" -> ans = num1 / num2;
            default ->
                    throw new RuntimeException("Некорректный ввод данных. Введите числа от 1 до 10. используйте следующие операнды: *,/,-,+");
        }
        if ((num1 > 0 && num1 <= 10) &&
                (num2 > 0 && num2 <= 10)) {
            System.out.print("\nРезультат операции следующий:\n");
            System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);
        } else {
            throw new RuntimeException("Некорректный ввод данных. Введите числа от 1 до 10. используйте следующие операнды: *,/,-,+");
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {
        System.out.println("Введите математеское действие");
        String input = new Scanner(System.in).nextLine();
        calc(input);
    }
}
