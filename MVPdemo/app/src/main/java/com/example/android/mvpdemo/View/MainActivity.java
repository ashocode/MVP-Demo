package com.example.android.mvpdemo.View;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.android.mvpdemo.Contracts.ActivityView;
import com.example.android.mvpdemo.Contracts.Presenter;
import com.example.android.mvpdemo.Presenter.DataPresenter;
import com.example.android.mvpdemo.R;

public class MainActivity extends AppCompatActivity implements ActivityView {
    private static final String KEY_RADIO_CURRENT_VALUE = "SavedStateOfRadioButtonSelection";
    private static final String KEY_COLOR_CURRENT_VALUE = "SavedStateOfColor";
    private RadioButton radioButton;
    private RadioGroup radioGroup;
    private Presenter presenter;
    private Button button;
    private View backgroundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new DataPresenter(this);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        // Passing the saved state value to the variable
        int radioCurrentValue = savedInstanceState.getInt(KEY_RADIO_CURRENT_VALUE);
        String color = savedInstanceState.getString(KEY_COLOR_CURRENT_VALUE);
        RadioButton checkedButton = (RadioButton) radioGroup.findViewById(radioCurrentValue);

        if (checkedButton != null) {
            checkedButton.setChecked(true);
        }
        backgroundView.setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        int radioCurrentValue = radioGroup.getCheckedRadioButtonId();

        //Get the current color and parse it to hex
        int colorCurrentValue = ((ColorDrawable) ((findViewById(R.id.background_view)).getBackground())).getColor();
        String hexColor = String.format("#%06X", (0xFFFFFF & colorCurrentValue));

        // Save the current value of the variables.
        savedInstanceState.putInt(KEY_RADIO_CURRENT_VALUE, radioCurrentValue);
        savedInstanceState.putString(KEY_COLOR_CURRENT_VALUE, hexColor);

        // Always call the super class so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    //Get the selected color from the radio buttons
    private String getSelectedColorFromView(RadioGroup group) {
        String color;
        int radioButtonID = group.getCheckedRadioButtonId();
        radioButton = (RadioButton) group.findViewById(radioButtonID);
        int index = group.indexOfChild(radioButton);
        if (index == 0) {
            color = getResources().getString(R.string.red_color);
        } else if (index == 1) {
            color = getResources().getString(R.string.blue_color);
        } else if (index == 2) {
            color = getResources().getString(R.string.yellow_color);
        } else {
            color = getResources().getString(R.string.white_color);
        }
        return color;
    }

    //Initialize main UI elements
    @Override
    public void initView() {
        radioGroup = findViewById(R.id.radio_group);
        backgroundView = findViewById(R.id.background_view);
        button = findViewById(R.id.change_color);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.updateObjectColor(getSelectedColorFromView(radioGroup));
                presenter.onClick(view);
            }
        });
    }

    //Update the view
    @Override
    public void setViewData(String color) {
        backgroundView.setBackgroundColor(Color.parseColor(color));
    }
}
