package com.example.calculator;

import com.example.calculator.OperatorType;

import java.util.ArrayList;


public class ArithmeticCalculator {

    private static ArrayList<Number> results = new ArrayList<>();

    public ArrayList<Number> getter(){
        ArrayList<Number> copy_results = new ArrayList<>(results);

        return copy_results;
    }

    public void setter(ArrayList<Number> update_result){
        results = new ArrayList<>(update_result);
    }


    public <T extends Number> T calculate(T num1, T num2, OperatorType operator) {
        double result = 0;

        switch (operator) {
            case ADD:
                result = num1.doubleValue() + num2.doubleValue();
                break;
            case SUBTRACT:
                result = num1.doubleValue() - num2.doubleValue();
                break;
            case MULTIPLY:
                result = num1.doubleValue() * num2.doubleValue();
                break;
            case DIVIDE:
                result = num1.doubleValue() / num2.doubleValue();
                break;
        }

        if (num1 instanceof Integer && num2 instanceof Integer) {
            return (T) Integer.valueOf((int) result);
        } else {
            result = Math.round(result * 100) / 100.0;
            return (T) Double.valueOf(result);
        }
    }


    public void removeResult() {
        if (!results.isEmpty()){
            results.remove(0);
            System.out.println("가장 오래된 계산 결과 기록 제거");
        }
        else {
            System.out.println("저장되어있는 연산 결과가 없습니다.");
        }
    }

}
