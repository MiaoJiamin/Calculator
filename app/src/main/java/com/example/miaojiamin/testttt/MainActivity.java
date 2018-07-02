package com.example.miaojiamin.testttt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.BatchUpdateException;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = (Button) findViewById(R.id.btn_0);
        Button button1 = (Button) findViewById(R.id.btn_1);
        Button button2 = (Button) findViewById(R.id.btn_2);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


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
            case R.id.btn_DEL:
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_mult:
            case R.id.btn_div:
            case R.id.btn_percent:
            case R.id.btn_dot:
        }
    }
}
