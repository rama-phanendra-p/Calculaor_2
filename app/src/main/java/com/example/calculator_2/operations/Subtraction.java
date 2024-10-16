package com.example.calculator_2.operations;

public class Subtraction implements CalculatorOperation {
    @Override
    public double operate(int num1, int num2) {
        return num1 - num2;
    }
}
