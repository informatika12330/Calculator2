import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //https://www.youtube.com/watch?v=QJHcGWbzk3U
        while (true) {
            System.out.print("input: ");
            String str1 = scanner.nextLine();
            if (str1.equals("exit")) {
                break;
            }
            try {
                System.out.println(calculate(str1));
            } catch (IllegalArgumentException e) { //https://www.youtube.com/watch?v=DElNhj71YCk; https://www.youtube.com/watch?v=9gw81XDJoKs обработка исключений
                System.err.println("Throws exception " + e.getMessage());
            }
        }
        scanner.close();
    }
    //Разделяем строку на части: число1, оператор, число2
    public static String calculate(String input) {
        String[] chisla = input.split(" ");
        if (chisla.length != 3) {
            throw new IllegalArgumentException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        // присваиваем намбер 1 число 1 а намбер 2 число 2 Проверяем, что числа находятся в допустимом диапазоне
        int number1 = Integer.parseInt(chisla[0]);
        int number2 = Integer.parseInt(chisla[2]);
        if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10) { //
            throw new IllegalArgumentException("");
        }

        char operator = chisla[1].charAt(0); //https://www.youtube.com/watch?v=ERTDiGH3XUA метод charAt
        switch (operator) {  //switch operator https://www.youtube.com/watch?v=QJHcGWbzk3U switch
            case '+':
                return Integer.toString(number1 + number2);
            case '-':
                return Integer.toString(number1 - number2);
            case '*':
                return Integer.toString(number1  *  number2);
            case '/':
                return Integer.toString((number1/ number2)); // перед переменной number1 в ютубе ставили (int) только разницы я не заметил
            default:
                throw new IllegalArgumentException("");
        }
    }
}