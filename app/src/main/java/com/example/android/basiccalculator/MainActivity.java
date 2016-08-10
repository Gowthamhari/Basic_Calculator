package com.example.android.basiccalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String display = "";
    double v1, v2;
    String sign = "";
    public TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = (TextView) findViewById(R.id.edt1);
        answer.setText(display);

    }

    public void updateScreen() {
        answer.setText(display);
    }

    public void onClickNumber(View v) {

        Button b = (Button)v;
        display = display + b.getText();
        answer.setText(display);

    }

    public void onClickOperator (View v){
        /*if(display=="")
            return ;
        Button b = (Button) v;
        display = display + b.getText();
        sign = b.getText().toString();
        updateScreen(); */

        v1 = Double.parseDouble(display);
        display = "";
        Button b = (Button)v;
        String str1 = b.getText().toString();
        sign = str1;
        answer.setText(sign);

    }

    public void onClickEqual(View v){

        answer = (TextView) findViewById(R.id.edt1);
        String str = answer.getText().toString();
        v2 = Double.parseDouble(str);
        double grandTotal = 0;
        if (sign.equals("+")){
            grandTotal = v1 + v2;
        }
        else if (sign.equals("-")){
            grandTotal = v1 - v2;
        }
        else if (sign.equals("*")){
            grandTotal = v1 * v2;

        }
        else if (sign.equals("/")){
            grandTotal = v1 / v2;
        }
        answer.setText(v1 + sign + v2 + "\n" +  " Ans = " + grandTotal );
    }

    public void onClickClear(View v){

        display = "";
        sign = "";
        updateScreen();
    }

}
