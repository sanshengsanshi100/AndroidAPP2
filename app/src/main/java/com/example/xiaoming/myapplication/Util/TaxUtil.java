package com.example.xiaoming.myapplication.Util;

import android.widget.EditText;

import com.example.xiaoming.myapplication.data_base.DBOpenHelper;

public class TaxUtil{
    //BigDecimal计算 获取输入框内容
    public static String getProportion2(EditText et){
        String bl = String.valueOf(et.getText());
        if (bl.equals("")){
            return "0";
        }else{
            return bl;
        }
    }

}
