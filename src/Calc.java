
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {
    static int number1, number2;
    static char operation;
    static int result;

    static int oper=0;
    static public String Calculation (String str) throws Exception {
        oper=0;
        char[] under_char = new char[10];

        for (int i = 0; i < str.length(); i++) {
            under_char[i] = str.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
                oper++;
            }
            if (under_char[i] == '-') {
                operation = '-';
                oper++;
            }
            if (under_char[i] == '*') {
                operation = '*';
                oper++;
            }
            if (under_char[i] == '/') {
                operation = '/';
                oper++;
            }
        }
        if (oper>=2)
        {
            System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");

        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(string03);
        if (number1 < 0 && number2 > 0 || number1 > 0 && number2 < 0) {
            System.out.println("используются одновременно разные системы счисления.");

            throw new Exception("используются одновременно разные системы счисления.");
        }
        if (Integer.parseInt(stable00 )<1  || Integer.parseInt(string03) < 1 || Integer.parseInt(stable00) > 10 || Integer.parseInt(string03) > 10) {
            System.out.println("Входные данные должны быть в диапазоне от 1 до 10");
            throw new Exception("Входные данные должны быть в диапазоне от 1 до 10");
        }
        if (number1 < 0 && number2 < 0  ) {
            result = 0;
        } else {
            result = calculated(number1, number2, operation);
            String resultRoman = convertNumToRoman(result);
            return resultRoman;

        }
        number1 = Integer.parseInt(stable00);
        number2 = Integer.parseInt(string03);
        result = calculated(number1, number2, operation);
        System.out.println(number1 + " " + operation + " " + number2 + " = " + result);
        return Integer.toString(result);
    }

    private static String convertNumToRoman (int numArabian) throws Exception {
        try {


            String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
            };
            final String s = roman[numArabian];
            return s;
        }
        catch (Exception e)
        {
            System.out.println("В римской системе нет отрицательных чисел");
            throw new Exception("В римской системе нет отрицательных чисел");
        }

    }


    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            System.out.println("Неверный формат данных");
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    break;
                }
                break;
            default:
                System.out.println("Не верный знак операции");
                throw new IllegalArgumentException("Не верный знак операции");
        }

        return result;

    }
}
