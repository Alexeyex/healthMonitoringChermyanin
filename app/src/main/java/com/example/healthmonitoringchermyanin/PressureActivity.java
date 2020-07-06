package com.example.healthmonitoringchermyanin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PressureActivity extends AppCompatActivity {
    EditText inputUpPressure;
    EditText inputLowPressure;
    EditText inputPulse;
    EditText editTextDate;
    EditText checkBoxTachyhardia;
    ArrayList<String> valuesPressure = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressure);
        inputUpPressure.findViewById(R.id.inputUpPressure);
        inputLowPressure.findViewById(R.id.inputLowPressure);
        inputPulse.findViewById(R.id.inputPulse);
        editTextDate.findViewById(R.id.editTextDate);
        checkBoxTachyhardia.findViewById(R.id.checkBoxTachyhardia);
        initPressure();
    }

    private void initPressure() {
        Button btnSave2 = findViewById(R.id.btnSave2);

        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку: Сохранить");

                String inputUpPressureValue = inputUpPressure.getText().toString();
                String inputLowPressureValue = inputLowPressure.getText().toString();
                String inputPulseValue = inputPulse.getText().toString();
                Date editTextDateValue = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
                String formattedDate = sdf.format(editTextDateValue);
                String checkBoxTachyhardiaValue = checkBoxTachyhardia.getText().toString();

                valuesPressure.add(inputUpPressureValue);
                valuesPressure.add(inputLowPressureValue);
                valuesPressure.add(inputPulseValue);
                valuesPressure.add(formattedDate);
                valuesPressure.add(checkBoxTachyhardiaValue);

                try {
                    int inputUpPressureValueInt = Integer.parseInt(inputUpPressureValue);
                    int inputLowPressureValueInt = Integer.parseInt(inputLowPressureValue);
                    int inputPulseValueInt = Integer.parseInt(inputPulseValue);
                    int formattedDateInt = Integer.parseInt(formattedDate);
                } catch (Exception ex) {
                    Toast.makeText(PressureActivity.this, R.string.exception1, Toast.LENGTH_LONG).show();

                    Log.e(TAG, "Получено исключение", ex);
                }
            }
        });
    }
}