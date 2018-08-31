package com.example.android.mvpdemo.Model;

import com.example.android.mvpdemo.Contracts.ObjectColor;

/**
 * Created by Asen.Pichurov on 30-Aug-18.
 */

public class BackgroundObjectColor implements ObjectColor {
    private String color;

    public BackgroundObjectColor() {
    }

    @Override
    public void setObjectColor(String color) {
        this.color = color;
    }

    @Override
    public String getObjectColor() {
        return this.color;
    }
}
