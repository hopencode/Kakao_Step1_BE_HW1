package com.example.calculator;

import com.example.calculator.OperatorType;

import java.util.ArrayList;


public class ArithmeticCalculator {

    private ArrayList<Integer> results;

    public ArithmeticCalculator() {
        this.results = new ArrayList<>();
    }

    public ArrayList<Integer> getter(){
        ArrayList<Integer> copy_results = new ArrayList<>(this.results);

        return copy_results;
    }

    public void setter(ArrayList<Integer> update_result){
        this.results = new ArrayList<>(update_result);
    }


    public int calculate(int num1, int num2, OperatorType operator) {
        Integer result = null;

        switch (operator) {
            case ADD:
                result = num1 + num2;
                break;
            case SUBTRACT:
                result = num1 - num2;
                break;
            case MULTIPLY:
                result = num1 * num2;
                break;
            case DIVIDE:
                result = num1 / num2;
                break;
        }

        return result;
    }


    public void removeResult() {
        if (!this.results.isEmpty()){
            this.results.remove(0);
            System.out.println("가장 오래된 계산 결과 기록 제거");
        }
        else {
            System.out.println("저장되어있는 연산 결과가 없습니다.");
        }
    }

}
