import com.example.calculator.Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CalculateLv2 {

    private static int getValidatedInteger(Scanner scanner, String prompt) {
        int num = -1;
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine();
                if (input.equals("exit")){
                    return -1;
                }
                num = Integer.parseInt(input);
                if (num < 0) {
                    System.out.println("0 이상의 정수만 입력 가능합니다. 다시 입력하세요.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("정수를 입력해야 합니다. 다시 입력하세요.");
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String input;
        int num1, num2, result = 0;
        char operator;

        ArrayList<Integer> results;

        HashSet<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        while(true) {
            num1 = getValidatedInteger(scanner, "첫 번째 숫자를 입력하세요 (0 이상의 정수): ");
            if (num1 == -1){
                break;
            }

            num2 = getValidatedInteger(scanner, "두 번째 숫자를 입력하세요 (0 이상의 정수): ");
            if (num2 == -1){
                break;
            }

            System.out.print("사칙연산 기호를 입력하세요: ");
            input = scanner.nextLine();
            if (input.length() == 0) {
                System.out.println("입력이 없습니다. 다시 시도하세요.");
                continue;
            }
            operator = input.charAt(0);
            if (!operators.contains(operator)){
                System.out.println("올바른 사칙연산 기호가 아닙니다.");
                continue;
            }
            if(operator == '/' && num2 == 0){
                System.out.println("Divide 0 error");
                continue;
            }

            result = calculator.calculate(num1, num2, operator);

            results = calculator.getter();
            results.add(result);
            calculator.setter(results);

            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);



            System.out.println("=== 계산 기록 ===");
            for (int n : calculator.getter()) {
                System.out.print(n + ", ");
            }
            System.out.println();
            System.out.println("===============");


            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            input = scanner.nextLine();
            if(input.equals("exit")){
                break;
            }
        }
        calculator.removeResult();
        System.out.println("=== 계산 기록 ===");
        for (int n : calculator.getter()) {
            System.out.print(n + ", ");
        }
        System.out.println();
        System.out.println("===============");


    }
}
