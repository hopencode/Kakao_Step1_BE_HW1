package com.example.calculator;

import java.util.ArrayList;


public class Calculator {

    private ArrayList<Integer> results;

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public ArrayList<Integer> getter(){
        ArrayList<Integer> copy_results = new ArrayList<>(this.results);

        return copy_results;
    }

    public void setter(ArrayList<Integer> update_result){
        this.results = new ArrayList<>(update_result);
    }

    public int calculate(int num1, int num2, char operator){
        int result;

        if (operator == '+'){
            result = num1 + num2;
        }
        else if (operator == '-'){
            result = num1 - num2;
        }
        else if (operator == '*'){
            result = num1 * num2;
        }
        else{
            result = num1 / num2;
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