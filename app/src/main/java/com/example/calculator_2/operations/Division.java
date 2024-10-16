package com.example.calculator_2.operations;

public class Division implements CalculatorOperation {
    @Override
    public double operate(int num1, int num2) {
        if (num2 == 0) throw new ArithmeticException("Division by zero");
        return num1 / (double) num2;
    }
}
