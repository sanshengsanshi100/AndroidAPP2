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

import com.example.xiaoming.myapplication.Util.mLog;
import com.example.xiaoming.so.MyJni;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import dalvik.system.DexClassLoader;

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
        mLog.e("msg_ming", String.valueOf(btn.getText()));
        textView = (TextView) findViewById(R.id.textView);
        mLog.v("ming","调用so输出：" + MyJni.sayHello());
        QMUIStatusBarHelper.translucent(this);
        MyJni mj = new MyJni();
        mLog.v("ming", "实例化MyJni" + mj.name);
    }

    public String getString(String s){
        return s;
    }

    public void onClickNum(View v) {

        btn = (Button)v;
        String message;
        String now = String.valueOf(btn.getText());
        now = getString(now);
        mLog.i("点击", now + "");
        mLog.v("ming","调用so输出：" + MyJni.sayHello());
        Toast.makeText(MainActivity.this, now, Toast.LENGTH_SHORT).show();
        TextView TextView = (TextView) findViewById(R.id.textView);
        String m1 = String.valueOf(TextView.getText());
        mLog.i("当前数值", m1);
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
        mLog.i("ming","删除前"+m1);
        if (m1.length() > 0){
            m1 = m1.substring(0,m1.length()-1);
            mLog.i("ming","删除后"+m1);
        }
        textView.setText(m1);
    }

    public void cClick (View v){
        textView.setText("0");
    }
    //显式intent启动
    public void webBaidu (View v){
        //Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,WebViewActivity.class);
        mLog.i("ming","成功");
        startActivity(intent);
    }
    //显式intent启动
    public void grshui_bak(View v){
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,Tax.class);
        startActivity(intent);
        mLog.i("ming","切换到个税计算页面");
    }
    //隐式intent启动
    public void grshui(View v){
        Intent intent = new Intent();
        intent.setAction("MyAction");
        intent.addCategory("android.intent.category.DEFAULT");
        startActivity(intent);
        mLog.i("ming","切换到个税计算页面");
    }
    //显式intent启动
    public void grshui2(View v){
        Intent intent = new Intent(this,Tax2.class);
        //intent.setClass(MainActivity.this,Tax2.class);
        startActivity(intent);
        mLog.i("ming","切换到个税计算-年页面");
    }

    //隐式intent启动
    public void grshui3(View v){
        Intent intent = new Intent();
        intent.setAction("MyTax3");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("Tax3Category");
        startActivity(intent);
        mLog.i("ming","切换到个税计算-3页面");
    }

    //隐式intent启动
    public void yinyue(View v){
        Intent intent = new Intent();
        intent.setAction("MyMusic");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("Tax3Category");
        startActivity(intent);
        mLog.i("ming","切换到音乐页面");
    }


}
