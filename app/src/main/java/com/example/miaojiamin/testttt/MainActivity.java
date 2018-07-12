package com.example.miaojiamin.testttt;

import android.provider.BlockedNumberContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    double result;
    String logTag = "calculator";
    Stack<Double> numStack = new Stack<Double>();
    Stack<String> opStack = new Stack<String>();

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
                textView.setText(textView.getText().equals("0") ? "2" : textView.getText() + "2");
                break;
            case R.id.btn_3:
                textView.setText(textView.getText().equals("0") ? "3" : textView.getText() + "3");
                break;
            case R.id.btn_4:
                textView.setText(textView.getText().equals("0") ? "4" : textView.getText() + "4");
                break;
            case R.id.btn_5:
                textView.setText(textView.getText().equals("0") ? "5" : textView.getText() + "5");
                break;
            case R.id.btn_6:
                textView.setText(textView.getText().equals("0") ? "6" : textView.getText() + "6");
                break;
            case R.id.btn_7:
                textView.setText(textView.getText().equals("0") ? "7" : textView.getText() + "7");
                break;
            case R.id.btn_8:
                textView.setText(textView.getText().equals("0") ? "8" : textView.getText() + "8");
                break;
            case R.id.btn_9:
                textView.setText(textView.getText().equals("0") ? "9" : textView.getText() + "9");
                break;
            case R.id.btn_AC:
                textView.setText("0");
                result = 0;
                break;
            case R.id.btn_DEL:
            case R.id.btn_plus:
                PlusMinus(textView);
                textView.setText(textView.getText() + "\n" + "+");
                opStack.push("+");
                Log.d(logTag,String.valueOf(result));
                break;
            case R.id.btn_minus:
                PlusMinus(textView);
                textView.setText(textView.getText() + "\n" + "-");
                opStack.push("-");
                Log.d(logTag,String.valueOf(result));
                break;
            case R.id.btn_mult:
                MultDiv(textView);
                textView.setText(textView.getText() + "\n" + "*");
                opStack.push("*");
                Log.d(logTag,String .valueOf(result));
                break;
            case R.id.btn_div:
                MultDiv(textView);
                textView.setText(textView.getText() + "\n" + "/");
                opStack.push("/");
                Log.d(logTag,String .valueOf(result));
                break;
            case R.id.btn_equal:
                Equal(textView);
                textView.setText(textView.getText() + "\n" + "=" + String.valueOf(result));
                Log.d(logTag,String.valueOf(result));
            case R.id.btn_percent:
            case R.id.btn_dot:
        }
    }

    public void PlusMinus(TextView textView){
        String temp = textView.getText().toString();
        String[] templist = temp.split("\n");
        int i = templist.length - 1;
        switch (templist[i].charAt(0)){
            case '+':
                opStack.pop();
                result = numStack.pop() + Double.parseDouble(templist[i].substring(1));
                numStack.push(result);
                break;
            case '-':
                opStack.pop();
                result = numStack.pop() - Double.parseDouble(templist[i].substring(1));
                numStack.push(result);
                break;
            case '*':
                opStack.pop();
                result = numStack.pop() * Double.parseDouble(templist[i].substring(1));
                numStack.push(result);
                break;
            case '/':
                opStack.pop();
                result = numStack.pop() / Double.parseDouble(templist[i].substring(1));
                numStack.push(result);
                break;
            default:
                numStack.push(Double.parseDouble(templist[i]));
                break;
        }
    }

    public void MultDiv(TextView textView){
        String temp = textView.getText().toString();
        String[] templist = temp.split("\n");
        int i = templist.length - 1;
        switch (templist[i].charAt(0)){
            case '+':
                numStack.push(Double.parseDouble(templist[i].substring(1)));
                break;
            case '-':
                numStack.push(Double.parseDouble(templist[i].substring(1)));
                break;
            case '*':
                opStack.pop();
                result = numStack.pop() * Double.parseDouble(templist[i].substring(1));
                numStack.push(result);
                break;
            case '/':
                opStack.pop();
                result = numStack.pop() / Double.parseDouble(templist[i].substring(1));
                numStack.push(result);
                break;
            default:
                numStack.push(Double.parseDouble(templist[i]));
                break;
        }
    }

    public void Equal(TextView textView){
        String temp = textView.getText().toString();
        String[] templist = temp.split("\n");
        int i = templist.length - 1;
        numStack.push(Double.parseDouble(templist[i].substring(1)));
        while (!opStack.isEmpty()){
            switch (opStack.pop()){
                case "+":
                    result = numStack.pop() + numStack.pop();
                    numStack.push(result);
                    break;
                case "-":
                    result = numStack.pop() - numStack.pop();
                    numStack.push(result);
                    break;
                case "*":
                    result = numStack.pop() * numStack.pop();
                    numStack.push(result);
                    break;
                case "/":
                    result = numStack.pop() / numStack.pop();
                    numStack.push(result);
                    break;
            }
        }
    }
}
