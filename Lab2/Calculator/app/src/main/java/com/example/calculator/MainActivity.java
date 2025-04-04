package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private TextView tvExpression;
    private String currentNumber = "0";
    private String leftNumber = "";
    private String operator = "";
    private boolean isOperatorClicked = false;
    private boolean isResultDisplayed = false;
    private String currentExpression = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
        tvExpression = findViewById(R.id.tvExpression);

        tvResult.setText(currentNumber);
        tvExpression.setText("");

        setNumberButtonClickListeners();
        setOperatorButtonClickListeners();
        setFunctionButtonClickListeners();
    }

    private void setNumberButtonClickListeners() {
        int[] numberButtonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
                R.id.btn4, R.id.btn5, R.id.btn6,
                R.id.btn7, R.id.btn8, R.id.btn9, R.id.btnDot
        };

        for (int id : numberButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clickedButton = (Button) v;
                    String buttonText = clickedButton.getText().toString();

                    if (isResultDisplayed) {
                        currentNumber = "0";
                        currentExpression = "";
                        tvExpression.setText("");
                        isResultDisplayed = false;
                    }

                    if (isOperatorClicked) {
                        isOperatorClicked = false;
                        currentNumber = "";
                    }

                    if (currentNumber.equals("0") && !buttonText.equals(".")) {
                        currentNumber = buttonText;
                    } else {
                        if (buttonText.equals(".") && currentNumber.contains(".")) {
                            return;
                        }
                        currentNumber += buttonText;
                    }

                    tvResult.setText(currentNumber);
                }
            });
        }
    }

    private void setOperatorButtonClickListeners() {
        int[] operatorButtonIds = {
                R.id.btnAdd, R.id.btnSubtract,
                R.id.btnMultiply, R.id.btnDivide
        };

        for (int id : operatorButtonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button clickedButton = (Button) v;
                    String buttonText = clickedButton.getText().toString();

                    if (!leftNumber.isEmpty() && !isOperatorClicked && !currentNumber.isEmpty()) {
                        double result = calculateResult();
                        String resultStr = formatResult(result);

                        currentExpression = leftNumber + " " + operator + " " + currentNumber + " = " + resultStr;
                        tvExpression.setText(currentExpression);

                        tvResult.setText(resultStr);
                        leftNumber = resultStr;
                        currentExpression = resultStr;
                        isResultDisplayed = true;
                    } else if (currentNumber.isEmpty() && !leftNumber.isEmpty()) {
                        operator = buttonText;
                        currentExpression = leftNumber + " " + operator;
                        tvExpression.setText(currentExpression);
                        return;
                    } else {
                        leftNumber = currentNumber;
                    }

                    operator = buttonText;
                    isOperatorClicked = true;
                    currentExpression = leftNumber + " " + operator;
                    tvExpression.setText(currentExpression);
                }
            });
        }

        Button btnPercent = findViewById(R.id.btnPercent);
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNumber.isEmpty() || currentNumber.equals("0")) {
                    return;
                }

                double value = Double.parseDouble(currentNumber);

                if (leftNumber.isEmpty() || operator.isEmpty()) {
                    value = value / 100;
                    currentNumber = formatResult(value);
                    tvResult.setText(currentNumber);
                } else {
                    double leftVal = Double.parseDouble(leftNumber);

                    switch (operator) {
                        case "+":
                        case "-":
                            value = leftVal * value / 100;
                            break;
                        case "x":
                        case "×":
                        case "/":
                        case "÷":
                            value = value / 100;
                            break;
                    }

                    currentNumber = formatResult(value);
                    tvResult.setText(currentNumber);
                }
            }
        });
    }

    private void setFunctionButtonClickListeners() {
        // Equal button
        Button btnEquals = findViewById(R.id.btnEquals);
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!leftNumber.isEmpty() && !currentNumber.isEmpty() && !operator.isEmpty()) {
                    double result = calculateResult();
                    String resultStr = formatResult(result);
                    currentExpression = leftNumber + " " + operator + " " + currentNumber + " = " + resultStr;
                    tvExpression.setText(currentExpression);

                    tvResult.setText(resultStr);
                    currentNumber = resultStr;
                    leftNumber = "";
                    operator = "";
                    isResultDisplayed = true;
                }
            }
        });

        // Delete button
        Button btnDel = findViewById(R.id.btnDel);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isResultDisplayed) {
                    currentNumber = "0";
                    tvResult.setText(currentNumber);
                    tvExpression.setText("");
                    currentExpression = "";
                    isResultDisplayed = false;
                } else if (currentNumber.length() > 1) {
                    currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                    tvResult.setText(currentNumber);
                } else {
                    currentNumber = "0";
                    tvResult.setText(currentNumber);
                }
            }
        });

        btnDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentNumber = "0";
                leftNumber = "";
                operator = "";
                isOperatorClicked = false;
                isResultDisplayed = false;
                currentExpression = "";
                tvResult.setText(currentNumber);
                tvExpression.setText("");
                return true;
            }
        });
    }

    private double calculateResult() {
        double leftVal = Double.parseDouble(leftNumber);
        double rightVal = Double.parseDouble(currentNumber);
        double result = 0;

        switch (operator) {
            case "+":
                result = leftVal + rightVal;
                break;
            case "-":
                result = leftVal - rightVal;
                break;
            case "x":
            case "×":
                result = leftVal * rightVal;
                break;
            case "/":
            case "÷":
                if (rightVal != 0) {
                    result = leftVal / rightVal;
                } else {

                    return Double.NaN; // Not a Number
                }
                break;
        }

        return result;
    }

    private String formatResult(double result) {
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            return "Math Error";
        }

        try {

            BigDecimal bd = new BigDecimal(result);
            bd = bd.setScale(10, RoundingMode.HALF_UP);
            if (bd.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                return String.valueOf(bd.toBigInteger());
            } else {
                DecimalFormat df = new DecimalFormat("#.##########");
                df.setRoundingMode(RoundingMode.HALF_UP);
                return df.format(bd.doubleValue());
            }
        } catch (NumberFormatException e) {
            return "Math Error";
        }
    }
}
