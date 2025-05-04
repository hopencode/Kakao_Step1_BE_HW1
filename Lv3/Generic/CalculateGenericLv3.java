import com.example.calculator.ArithmeticCalculator;
import com.example.calculator.OperatorType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class CalculateGenericLv3 {

    private static Number getValidatedNum(Scanner scanner, String prompt) {
        Number num = -1;
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.equals("exit")){
                return -1;
            }
            try {
                num = Integer.parseInt(input);
                if (num.intValue() < 0) {
                    System.out.println("0 이상의 실수만 입력 가능합니다. 다시 입력하세요.");
                    continue;
                }
                break;
            } catch (NumberFormatException e1) {
                try {
                    num = Double.parseDouble(input); // 실패하면 실수 시도
                    if (num.doubleValue() < 0) {
                        System.out.println("0 이상의 실수만 입력 가능합니다. 다시 입력하세요.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e2) {
                    System.out.println("실수를 입력해야 합니다. 다시 입력하세요.");
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        Scanner scanner = new Scanner(System.in);
        Number num1, num2, result = 0;
        String input;
        char operator;

        ArrayList<Number> results;

        HashSet<Character> operators = new HashSet<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');

        while(true) {
            num1 = getValidatedNum(scanner, "첫 번째 숫자를 입력하세요 (0 이상의 정수): ");
            if (num1.doubleValue() < 0){
                break;
            }

            num2 = getValidatedNum(scanner, "두 번째 숫자를 입력하세요 (0 이상의 정수): ");
            if (num2.doubleValue() < 0){
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
            if(operator == '/' && num2.doubleValue() == 0.0){
                System.out.println("Divide 0 error");
                continue;
            }

            OperatorType operator_enum = OperatorType.fromChar(operator);
            if (num1 instanceof Integer && num2 instanceof Integer){
                result = calculator.calculate(num1.intValue(), num2.intValue(), operator_enum);

                results = calculator.getter();
                results.add(result);
                calculator.setter(results);
            }
            else{
                result = calculator.calculate(num1.doubleValue(), num2.doubleValue(), operator_enum);

                results = calculator.getter();
                results.add(result);
                calculator.setter(results);
            }

            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);



            System.out.println("=== 계산 기록 ===");
            for (Object n : calculator.getter()) {
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
        for (Object n : calculator.getter()) {
            System.out.print(n + ", ");
        }
        System.out.println();
        System.out.println("===============");


    }
}