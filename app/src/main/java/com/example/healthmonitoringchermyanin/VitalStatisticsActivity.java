package com.example.healthmonitoringchermyanin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class VitalStatisticsActivity extends AppCompatActivity {
    EditText inputWeight;
    EditText inputSteps;
    ArrayList<VitalStatistics> valuesStatistics = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vital_statistics);
        inputWeight = findViewById(R.id.inputWeight);
        inputSteps = findViewById(R.id.inputSteps);
        initStatistics();
    }

    private void initStatistics() {
        Button btnSave3 = findViewById(R.id.btnSave3);

        btnSave3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку: Сохранить");

                String inputWeightValue = inputWeight.getText().toString();
                String inputStepsValue = inputSteps.getText().toString();;

                try {
                    double inputWeightValueDbl = Double.parseDouble(inputWeightValue);
                    int inputStepsValueInt = Integer.parseInt(inputStepsValue);
                    VitalStatistics vs = new VitalStatistics(inputWeightValueDbl, inputStepsValueInt);
                    valuesStatistics.add(vs);
                } catch (Exception ex) {
                    Toast.makeText(VitalStatisticsActivity.this, R.string.exception1, Toast.LENGTH_LONG).show();

                    Log.e(TAG, "Получено исключение", ex);
                }
            }
        });
    }
}