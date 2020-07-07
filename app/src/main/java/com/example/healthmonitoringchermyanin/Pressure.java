package com.example.healthmonitoringchermyanin;

import java.time.LocalDate;

public class Pressure {
    private int inputUpPressureValue;
    private int inputLowPressureValue;
    private int inputPulseValue;
    private boolean checkBoxTachyhardiaValue;
    private LocalDate date;

    public Pressure(int inputUpPressureValue, int inputLowPressureValue, int inputPulseValue, boolean checkBoxTachyhardiaValue, LocalDate date) {
        this.inputUpPressureValue = inputUpPressureValue;
        this.inputLowPressureValue = inputLowPressureValue;
        this.inputPulseValue = inputPulseValue;
        this.checkBoxTachyhardiaValue = checkBoxTachyhardiaValue;
        this.date = date;
    }
}
