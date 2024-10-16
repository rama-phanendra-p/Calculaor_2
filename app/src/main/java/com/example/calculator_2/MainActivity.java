package com.example.calculator_2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.calculator_2.databinding.ActivityMainBinding;
import com.example.calculator_2.operations.Addition;
import com.example.calculator_2.operations.CalculatorOperation;
import com.example.calculator_2.operations.Division;
import com.example.calculator_2.operations.Modulus;
import com.example.calculator_2.operations.Multiplication;
import com.example.calculator_2.operations.Power;
import com.example.calculator_2.operations.Subtraction;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText e1, e2;
    private TextView t1;
    private int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);
        t1 = findViewById(R.id.result);
    }

    private boolean getNumbers() {
        String s1 = e1.getText().toString().trim();
        String s2 = e2.getText().toString().trim();

        if (s1.isEmpty() || s2.isEmpty()) {
            t1.setText("Please enter both numbers");
            return false;
        }

        try {
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        } catch (NumberFormatException e) {
            t1.setText("Invalid input. Enter valid numbers.");
            return false;
        }
        return true;
    }

    private void performOperation(CalculatorOperation operation) {
        if (getNumbers()) {
            try {
                double result = operation.operate(num1, num2);
                t1.setText(String.valueOf(result));
            } catch (ArithmeticException e) {
                t1.setText("Error: " + e.getMessage());
            }
        }
    }

    public void doAddition(View v) {
        performOperation(new Addition());
    }

    public void doSubtraction(View v) {
        performOperation(new Subtraction());
    }

    public void doMultiplication(View v) {
        performOperation(new Multiplication());
    }

    public void doDivision(View v) {
        performOperation(new Division());
    }

    public void doModulus(View v) {
        performOperation(new Modulus());
    }

    public void doPower(View v) {
        performOperation(new Power());
    }

    public void clearTextNum1(View v) {
        e1.getText().clear();
    }

    public void clearTextNum2(View v) {
        e2.getText().clear();
    }
}
