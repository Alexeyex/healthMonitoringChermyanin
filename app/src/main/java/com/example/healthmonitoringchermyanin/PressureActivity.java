package com.example.healthmonitoringchermyanin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;

public class PressureActivity extends AppCompatActivity {
    EditText inputUpPressure;
    EditText inputLowPressure;
    EditText inputPulse;
    EditText editTextDate;
    CheckBox checkBoxTachyhardia;
    ArrayList<Pressure> valuesPressure = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        inputUpPressure = findViewById(R.id.inputUpPressure);
        inputLowPressure = findViewById(R.id.inputLowPressure);
        inputPulse = findViewById(R.id.inputPulse);
        editTextDate = findViewById(R.id.editTextDate);
        checkBoxTachyhardia = findViewById(R.id.checkBoxTachyhardia);
        initPressure();
    }

    private void initPressure() {
        Button btnSave2 = findViewById(R.id.btnSave2);

        btnSave2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку: Сохранить");

                String inputUpPressureValue = inputUpPressure.getText().toString();
                String inputLowPressureValue = inputLowPressure.getText().toString();
                String inputPulseValue = inputPulse.getText().toString();
                //String editTextDateValue = editTextDate.getText().toString();
                LocalDate editTextDateValue = LocalDate.now();
                editTextDate.setText(editTextDateValue.toString());
                String checkBoxTachyhardiaValue = checkBoxTachyhardia.getText().toString();


                try {
                    int inputUpPressureValueInt = Integer.parseInt(inputUpPressureValue);
                    int inputLowPressureValueInt = Integer.parseInt(inputLowPressureValue);
                    int inputPulseValueInt = Integer.parseInt(inputPulseValue);
                    Pressure pressure = new Pressure(inputUpPressureValueInt, inputLowPressureValueInt,
                            inputPulseValueInt, Boolean.parseBoolean(checkBoxTachyhardiaValue), editTextDateValue);
                    valuesPressure.add(pressure);
                } catch (Exception ex) {
                    Toast.makeText(PressureActivity.this, R.string.exception1, Toast.LENGTH_LONG).show();

                    Log.e(TAG, "Получено исключение", ex);
                }

            }
        });
    }
}