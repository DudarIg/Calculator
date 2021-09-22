package ru.dudar.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Calc calc = new Calc();

    private final static String keyCalc = "Calc";

    private TextView tabloTv;

    private Button digitOneButton;
    private Button digitTwoButton;
    private Button digitThreeButton;
    private Button plusOperationButton;
    private Button digitFourButton;
    private Button digitFiveButton;
    private Button digitSixButton;
    private Button minusOperationButton;
    private Button digitSevenButton;
    private Button digitEightButton;
    private Button digitNineButton;
    private Button digitZeroButton;
    private Button pointButton;
    private Button multOperationButton;
    private Button shareOperationButton;
    private Button resetOperationButton;
    private Button calcResultButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabloTv = findViewById(R.id.tablo_tv);

        digitOneButton = findViewById(R.id.digit_one_button);
        digitTwoButton = findViewById(R.id.digit_two_button);
        digitThreeButton = findViewById(R.id.digit_three_button);
        plusOperationButton = findViewById(R.id.plus_operation_button);
        digitFourButton = findViewById(R.id.digit_four_button);
        digitFiveButton = findViewById(R.id.digit_five_button);
        digitSixButton = findViewById(R.id.digit_six_button);
        minusOperationButton = findViewById(R.id.minus_operation_button);
        digitSevenButton = findViewById(R.id.digit_seven_button);
        digitEightButton = findViewById(R.id.digit_eight_button);
        digitNineButton = findViewById(R.id.digit_nine_button);
        digitZeroButton = findViewById(R.id.digit_zero_button);
        pointButton = findViewById(R.id.point_button);
        multOperationButton = findViewById(R.id.mult_operation_button);
        shareOperationButton = findViewById(R.id.share_operation_button);
        resetOperationButton = findViewById(R.id.reset_operation_button);
        calcResultButton = findViewById(R.id.calc_result_button);

        digitOneButton.setOnClickListener(this::saveDigitOneButton);
        digitTwoButton.setOnClickListener(this::saveDigitTwoButton);
        digitThreeButton.setOnClickListener(this::saveDigitThreeButton);

        digitFourButton.setOnClickListener(this::saveDigitFourButton);
        digitFiveButton.setOnClickListener(this::saveDigitFiveButton);
        digitSixButton.setOnClickListener(this::saveDigitSixButton);

        digitSevenButton.setOnClickListener(this::saveDigitSevenButton);
        digitEightButton.setOnClickListener(this::saveDigitEightButton);
        digitNineButton.setOnClickListener(this::saveDigitNineButton);
        digitZeroButton.setOnClickListener(this::saveDigitZeroButton);
        pointButton.setOnClickListener(this::savePointButton);

        resetOperationButton.setOnClickListener(this::saveResetOperationButton);
        plusOperationButton.setOnClickListener(this::savePlusOperationButton);
        minusOperationButton.setOnClickListener(this::saveMinusOperationButton);
        multOperationButton.setOnClickListener(this::saveMultOperationButton);
        shareOperationButton.setOnClickListener(this::saveShareOperationButton);

        calcResultButton.setOnClickListener(this::saveCalcResultButton);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(keyCalc, calc);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calc = (Calc) savedInstanceState.getSerializable(keyCalc);
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitOneButton(View view) {
        calc.addSign("1");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitTwoButton(View view) {
        calc.addSign("2");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitThreeButton(View view) {
        calc.addSign("3");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitFourButton(View view) {
        calc.addSign("4");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitFiveButton(View view) {
        calc.addSign("5");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitSixButton(View view) {
        calc.addSign("6");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitSevenButton(View view) {
        calc.addSign("7");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitEightButton(View view) {
        calc.addSign("8");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitNineButton(View view) {
        calc.addSign("9");
        tabloTv.setText(calc.getCalculat());
    }

    private void saveDigitZeroButton(View view) {
        calc.addSign("0");
        tabloTv.setText(calc.getCalculat());
    }

    private void savePointButton(View view) {
        if (calc.getCountPoint() == 0) {
            calc.addSign(".");
            calc.setCountPoint(1);
        }
        tabloTv.setText(calc.getCalculat());
    }

    private void saveResetOperationButton(View view) {
        calc.setIndexAction(0);
        calc.setCalculat("");
        calc.setCountPoint(0);
        tabloTv.setText(calc.getCalculat());
    }

    private void savePlusOperationButton(View view) {
        if (calc.getCalculat().length() > 0 && calc.getIndexAction() == 0) {
            saveSetCalc("+");
            calc.setAction(Operation.PLUS);
        }
        tabloTv.setText(calc.getCalculat());
    }

    private void saveMinusOperationButton(View view) {

        if (calc.getCalculat().length() > 0 && calc.getIndexAction() == 0) {
            saveSetCalc("-");
            calc.setAction(Operation.MINUS);
        }
        if (calc.getCalculat().length() == 0 && calc.getIndexAction() == 0) {
            calc.addSign("-");
        }
        tabloTv.setText(calc.getCalculat());
    }

    private void saveMultOperationButton(View view) {
        if (calc.getCalculat().length() > 0 && calc.getIndexAction() == 0) {
            saveSetCalc("*");
            calc.setAction(Operation.MULT);
        }
        tabloTv.setText(calc.getCalculat());
    }

    private void saveShareOperationButton(View view) {
        if (calc.getCalculat().length() > 0 && calc.getIndexAction() == 0) {
            saveSetCalc("÷");
            calc.setAction(Operation.SHARE);
        }
        tabloTv.setText(calc.getCalculat());
    }

    private void saveSetCalc(String operation) {
        calc.addSign(operation);
        calc.setIndexAction(calc.getCalculat().length() - 1);
        calc.setCountPoint(0);
    }

    private void saveCalcResultButton(View view) {
        tabloTv.setText(calc.runResult());
        calc.setIndexAction(0);
        calc.setCalculat("");
        calc.setCountPoint(0);
    }

}