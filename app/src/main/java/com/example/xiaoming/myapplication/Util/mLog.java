package com.example.xiaoming.myapplication.Util;

import android.util.Log;

public class mLog{
    private static final Boolean DEBUG = false;
    public static void v(String tag,String message){
        if(DEBUG){
            Log.v(tag,message);
        }
    }

    public static void i(String tag,String message){
        if(DEBUG){
            Log.i(tag,message);
        }
    }


    public static void e(String tag,String message){
        if(DEBUG){
            Log.e(tag,message);
        }
    }


    public static void d(String tag,String message){
        if(DEBUG){
            Log.d(tag,message);
        }
    }

    public static void w(String tag,String message){
        if(DEBUG){
            Log.w(tag,message);
        }
    }
}
