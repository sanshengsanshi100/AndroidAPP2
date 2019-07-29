package com.example.xiaoming.myapplication;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private  Button uJisuan;
    private double sum;
    private double del = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn1);
        Log.e("msg_ming", String.valueOf(btn.getText()));
        textView = (TextView) findViewById(R.id.textView);
    }

    public String getString(String s){
        return s;
    }

    public void onClickNum(View v) {
        btn = (Button)v;
        String message;
        String now = String.valueOf(btn.getText());
        now = getString(now);
        Log.i("点击", now + "");
        Toast.makeText(MainActivity.this, now, Toast.LENGTH_SHORT).show();
        TextView TextView = (TextView) findViewById(R.id.textView);
        String m1 = String.valueOf(TextView.getText());
        Log.i("当前数值", m1);
        if (m1.equals("0")) {
            if(String.valueOf(btn.getText()).equals(".")){
                message = m1 + now;
                TextView.setText(message);
            }else{
                message = now + "";
                TextView.setText(message);
            }
        } else {
            message = m1 + now;
            TextView.setText(message);
        }
    }
    public void calculate(View v){
        uJisuan = (Button)v;
        String fuhao = String.valueOf(uJisuan.getText());
        String m1 = String.valueOf(textView.getText());
        String[] list;
        if (fuhao.equals("=")){
            sum = Calculator.conversion(m1.replace("×","*").replace("÷","/"));
            textView.setText(sum + "");
        }else{
            onClickNum(v);
        }
    }

    public void delString(View v){
        String m1 = String.valueOf(textView.getText());
        Log.i("ming","删除前"+m1);
        if (m1.length() > 0){
            m1 = m1.substring(0,m1.length()-1);
            Log.i("ming","删除后"+m1);
        }
        textView.setText(m1);
    }

    public void cClick (View v){
        textView.setText("0");
    }

    public void webBaidu (View v){
        //Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,WebViewActivity.class);
        Log.i("ming","成功");
        startActivity(intent);
    }

    public void grshui(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Tax.class);
        startActivity(intent);
        Log.i("ming","切换到个税计算页面");
    }

    public void grshui2(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Tax2.class);
        startActivity(intent);
        Log.i("ming","切换到个税计算-年页面");
    }



}
