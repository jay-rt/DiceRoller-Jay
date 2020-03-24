package com.example.diceroller_jay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView displayResult;
    private RadioGroup diceFaces;
    private RadioButton face_4,face_6,face_8,face_10,face_12,face_20;
    private Button roll;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayResult = findViewById(R.id.displayResult);
        roll = findViewById(R.id.roll);
        diceFaces = findViewById(R.id.diceFaces);
        face_4 = findViewById(R.id.face_4);
        face_6 = findViewById(R.id.face_6);
        face_8 = findViewById(R.id.face_8);
        face_10 = findViewById(R.id.face_10);
        face_12 = findViewById(R.id.face_12);
        face_20 = findViewById(R.id.face_20);
        checkBox = findViewById(R.id.doubleRoll);

        roll.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int maxValue = 6;
        int randomValue = 0;

        switch (diceFaces.getCheckedRadioButtonId()){
            case R.id.face_4:
                maxValue = Integer.parseInt(face_4.getText().toString().replaceAll("\\D",""));
                break;

            case R.id.face_6:
                maxValue = Integer.parseInt(face_6.getText().toString().replaceAll("\\D",""));
                break;

            case R.id.face_8:
                maxValue = Integer.parseInt(face_8.getText().toString().replaceAll("\\D",""));
                break;

            case R.id.face_10:
                maxValue = Integer.parseInt(face_10.getText().toString().replaceAll("\\D",""));
                break;

            case R.id.face_12:
                maxValue = Integer.parseInt(face_12.getText().toString().replaceAll("\\D",""));
                break;

            case R.id.face_20:
                maxValue = Integer.parseInt(face_20.getText().toString().replaceAll("\\D",""));
                break;
        }

        randomValue = value(maxValue);
        displayResult.setText(Integer.toString(randomValue));

        if (checkBox.isChecked()){
            randomValue = value(maxValue);
            displayResult.setText(String.format("%s %s", displayResult.getText(), Integer.toString(randomValue)));
        }
    }

    public int value(int a){
        if(a == 10){
            a = (int)(Math.random() * a);
        }else{
            a = (int)(Math.random() * a) + 1;
        }
        return a;
    }
}
