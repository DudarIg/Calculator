package ru.dudar.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;

public class SetActivity extends AppCompatActivity {
    static final String SET_KEY_IN = "SET_KEY_IN";
    static final String SET_KEY_OUT = "SET_KEY_OUT";

    private RadioButton rb1, rb3, rb5;
    private RadioButton rbDen, rbNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initRB();
        loadIntent();

        findViewById(R.id.save_button).setOnClickListener(v -> {

            Settings setResultData = new Settings();

            if (rb1.isChecked()) {
                setResultData.precise = 1;
            }
            if (rb3.isChecked()) {
                setResultData.precise = 3;
            }
            if (rb5.isChecked()) {
                setResultData.precise = 5;
            }
            if (rbDen.isChecked()) {
                setResultData.colorScheme = 1;
            }
            if (rbNight.isChecked()) {
                setResultData.colorScheme = 2;
            }
            Intent dataResult = new Intent().putExtra(SET_KEY_OUT, setResultData);
            setResult(Activity.RESULT_OK, dataResult);
            finish();
        });

    }

    private void initRB() {
        rb1 = findViewById(R.id.rB_z1);
        rb3 = findViewById(R.id.rB_z3);
        rb5 = findViewById(R.id.rB_z5);
        rbDen = findViewById(R.id.rB_Den);
        rbNight = findViewById(R.id.rB_Night);
    }


    private void loadIntent() {
        Intent data = getIntent();
        Settings setData = (Settings) data.getSerializableExtra(SET_KEY_IN);
        saveRB(setData);
    }

    private void saveRB(Settings setData) {

        switch (setData.colorScheme) {
            case 1: {
                rbDen.setChecked(true);
                break;
            }
            case 2: {
                rbNight.setChecked(true);
                break;
            }
        }

        switch (setData.precise) {
            case 1: {
                rb1.setChecked(true);
                break;
            }
            case 3: {
                rb3.setChecked(true);
                break;
            }
            case 5: {
                rb5.setChecked(true);
                break;
            }
        }
    }
}