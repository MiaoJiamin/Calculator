package com.example.miaojiamin.testttt;

import android.provider.BlockedNumberContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    double result;
    ArrayList<Double> numStack = new ArrayList<Double>();
    ArrayList<String> opStack = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button0 = (Button) findViewById(R.id.btn_0);
        Button button1 = (Button) findViewById(R.id.btn_1);
        Button button2 = (Button) findViewById(R.id.btn_2);
        Button button3 = (Button) findViewById(R.id.btn_3);
        Button button4 = (Button) findViewById(R.id.btn_4);
        Button button5 = (Button) findViewById(R.id.btn_5);
        Button button6 = (Button) findViewById(R.id.btn_6);
        Button button7 = (Button) findViewById(R.id.btn_7);
        Button button8 = (Button) findViewById(R.id.btn_8);
        Button button9 = (Button) findViewById(R.id.btn_9);
        Button btn_plus = (Button) findViewById(R.id.btn_plus);
        Button btn_minus = (Button) findViewById(R.id.btn_minus);
        Button btn_mult = (Button) findViewById(R.id.btn_mult);
        Button btn_div = (Button) findViewById(R.id.btn_div);
        Button btn_equal = (Button) findViewById(R.id.btn_equal);
        Button btn_ac = (Button) findViewById(R.id.btn_AC);
        Button btn_del = (Button) findViewById(R.id.btn_DEL);
        Button btn_percent = (Button) findViewById(R.id.btn_percent);
        Button btn_dot = (Button) findViewById(R.id.btn_dot);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_mult.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_ac.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_percent.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        TextView textView = (TextView) findViewById(R.id.textview);
        switch (view.getId()){
            case R.id.btn_0:
                textView.setText(textView.getText().equals("0") ? "0" : textView.getText() + "0");
                break;
            case R.id.btn_1:
                textView.setText(textView.getText().equals("0") ? "1" : textView.getText() + "1");
                break;
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_AC:
                textView.setText("0");
                break;
            case R.id.btn_DEL:
            case R.id.btn_plus:
                String temp = textView.getText().toString();
                String[] templist = temp.split("\\n");
                int index = templist.length - 2;
                numStack.add(Double.parseDouble(templist[index]));
                textView.setText(textView.getText() + "\n" + "+");
                opStack.add("+");
                break;
            case R.id.btn_minus:
            case R.id.btn_mult:
            case R.id.btn_div:
            case R.id.btn_equal:
                textView.setText(textView.getText() + "\n" + "=" + String.valueOf(result));
            case R.id.btn_percent:
            case R.id.btn_dot:
        }
    }

    public double ALU(){
        return result;
    }
}
