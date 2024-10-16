package com.example.calculator_2.operations;

public class Power implements CalculatorOperation {
    @Override
    public double operate(int num1, int num2) {
        return Math.pow(num1, num2);
    }
}
