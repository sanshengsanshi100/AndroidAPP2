package com.example.xiaoming.myapplication.Util;

import android.icu.math.BigDecimal;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.xiaoming.myapplication.R;
import com.example.xiaoming.myapplication.Tax2;


public class TaxUtil extends Tax2 {
    private AppCompatActivity activity;

    public TaxUtil(AppCompatActivity activity) {
        this.activity = activity;
    }

    //BigDecimal计算 获取输入框内容
    public static String getProportion2(EditText et) {
        String bl = String.valueOf(et.getText());
        if (bl.equals("")) {
            return "0";
        } else {
            return bl;
        }
    }



}
