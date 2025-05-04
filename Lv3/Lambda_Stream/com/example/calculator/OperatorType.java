package com.example.calculator;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char operator;

    OperatorType(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return this.operator;
    }

    public static OperatorType fromChar(char ch) {
        for (OperatorType op : values()) {
            if (op.operator == ch) {
                return op;
            }
        }
        return null;
    }
}

