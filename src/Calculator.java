import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class Calculator {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду");
            final String str = scanner.nextLine();
            if ("EXIT".equalsIgnoreCase(str)) {
                return;
            }
            selector(str);
        }
    }

    public static void selector(String str){
        Operator oper = new Operator();
        String firstNumber = Arrays.stream(str.split("\\s+")).limit(1).collect(Collectors.joining());
        String operator =  Arrays.stream(str.split("\\s+")).skip(1).limit(1).collect(Collectors.joining());
        String secondNumber = Arrays.stream(str.split("\\s+")).skip(2).limit(1).collect(Collectors.joining());
        List<String> check = Arrays.stream(str.split("\\s+")).collect(Collectors.toList());
        if(check.size() > 3){
            System.out.println("Формат математической операции не удовлетворяет заданию - " +
                    "два операнда и один оператор (+, -, /, *).");
            return;
        }
        if(oper.toCheck(operator)){
            try {
                Integer a = Integer.valueOf(firstNumber);
                Integer b = Integer.valueOf(secondNumber);
                calculateNumbers(a, operator, b);
            } catch (NumberFormatException e) {
                RomeNumber romeNumber = new RomeNumber();
                Integer a = romeNumber.getNumber(firstNumber);
                Integer b = romeNumber.getNumber(secondNumber);
                if (a > 0 | b > 0){
                    calculateRomeNumbers(a,operator,b);
                }
            }
        }
        if(!oper.toCheck(operator)){
            try {
                throw new Exception ("Строка не является математической операцией удовлетворяющей заданию - " +
                        "два операнда и один оператор (+, -, /, *).");
            } catch (Exception e) {
                System.out.println(e.getMessage()); //Можно писать просто через принт.
            }
        }
    }

    private static void calculateNumbers(Integer a, String operator, Integer b) {
        if (operator.equals("+")){
            System.out.println(a + b);
        }
        if (operator.equals("-")){
            System.out.println(a - b);
        }
        if (operator.equals("*")){
            System.out.println(a * b);
        }
        if (operator.equals("/")) {
            try {
                System.out.println(a / b);
            }catch (ArithmeticException e){
                System.out.println("Нельзя делить на 0! Иначе появится черная дыра!");
            }
        }
    }

    private static void calculateRomeNumbers(Integer a, String operator, Integer b) {
        if (operator.equals("+")){
            int i = a + b;
            convertRomeNumber(i);
        }
        if (operator.equals("-")){
            int i = a - b;
            convertRomeNumber(i);
        }
        if (operator.equals("*")){
            int i = a * b;
            convertRomeNumber(i);
        }
        if (operator.equals("/")) {
            if (b == 0){
                System.out.println("Нельзя делить на 0!");
                return;
            }
            int i = a / b;
            convertRomeNumber(i);
        }
    }

    private static void convertRomeNumber(int i) {
    RomeNumber romeNumber = new RomeNumber();
    romeNumber.getArabicNumber(i);
    }
}
