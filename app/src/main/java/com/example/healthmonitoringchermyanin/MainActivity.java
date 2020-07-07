package com.example.healthmonitoringchermyanin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText surnameUser;
    EditText nameUser;
    EditText patronymicUser;
    EditText ageUser;
    ArrayList<User> valuesMain = new ArrayList<>();
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surnameUser = findViewById(R.id.surnameUser);
        nameUser = findViewById(R.id.nameUser);
        patronymicUser = findViewById(R.id.patronymicUser);
        ageUser = findViewById(R.id.ageUser);
        initMain();
    }

    private void initMain() {
        Button btnSave1 = findViewById(R.id.btnSave1);
        Button btnPressureIndicators = findViewById(R.id.btnPressureIndicators);
        Button btnHealthIndicators = findViewById(R.id.btnHealthIndicators);

        btnSave1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку: Сохранить");

                String surnameUserValue = surnameUser.getText().toString();
                String nameUserValue = nameUser.getText().toString();
                String patronymicUserValue = patronymicUser.getText().toString();
                String ageUserValue = ageUser.getText().toString();

                try {
                    int ageUserValueInt = Integer.parseInt(ageUserValue);
                    User user = new User(surnameUserValue, nameUserValue, patronymicUserValue, ageUserValueInt);
                    valuesMain.add(user);
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, R.string.exception1, Toast.LENGTH_LONG).show();

                    Log.e(TAG, "Получено исключение", ex);
                }
            }
        });


        btnPressureIndicators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку: Записи показателей давления");
                Intent intent = new Intent(MainActivity.this, PressureActivity.class);
                startActivity(intent);
            }
        });

        btnHealthIndicators.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Пользователь нажал на кнопку: Записи жизненных показателей здоровья");
                Intent intent = new Intent(MainActivity.this, VitalStatisticsActivity.class);
                startActivity(intent);
            }
        });
    }
}