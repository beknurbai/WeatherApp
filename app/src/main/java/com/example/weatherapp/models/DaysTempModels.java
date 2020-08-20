package com.example.weatherapp.models;

public class DaysTempModels {
    int ImageTempState;
    String textDaysOfWeek;
    String tempUp;

    public DaysTempModels(int imageTempState, String textDaysOfWeek, String tempUp, String tempDown) {
        ImageTempState = imageTempState;
        this.textDaysOfWeek = textDaysOfWeek;
        this.tempUp = tempUp;
        this.tempDown = tempDown;
    }

    public int getImageTempState() {
        return ImageTempState;
    }

    public void setImageTempState(int imageTempState) {
        ImageTempState = imageTempState;
    }

    public String getTextDaysOfWeek() {
        return textDaysOfWeek;
    }

    public void setTextDaysOfWeek(String textDaysOfWeek) {
        this.textDaysOfWeek = textDaysOfWeek;
    }

    public String getTempUp() {
        return tempUp;
    }

    public void setTempUp(String tempUp) {
        this.tempUp = tempUp;
    }

    public String getTempDown() {
        return tempDown;
    }

    public void setTempDown(String tempDown) {
        this.tempDown = tempDown;
    }

    String tempDown;
}
