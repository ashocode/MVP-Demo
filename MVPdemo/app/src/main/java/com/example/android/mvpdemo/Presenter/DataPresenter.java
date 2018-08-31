package com.example.android.mvpdemo.Presenter;

import android.view.View;

import com.example.android.mvpdemo.Contracts.ActivityView;
import com.example.android.mvpdemo.Contracts.ObjectColor;
import com.example.android.mvpdemo.Contracts.Presenter;
import com.example.android.mvpdemo.Model.BackgroundObjectColor;

/**
 * Created by Asen.Pichurov on 30-Aug-18.
 */

public class DataPresenter implements Presenter {
    private ActivityView view;
    private ObjectColor model;

    public DataPresenter(ActivityView v) {
        this.view = v;
        initPresenter();
    }

    private void initPresenter() {
        this.model = new BackgroundObjectColor();
        this.view.initView();
    }

    @Override
    public void onClick(View view) {
        String color = model.getObjectColor();
        this.view.setViewData(color);
    }

    @Override
    public void updateObjectColor(String color) {
        this.model.setObjectColor(color);
    }
}
