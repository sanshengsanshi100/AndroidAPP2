package com.example.xiaoming.so;

public class MyJni {

    public String name = "名字";
    public boolean yes = true;
    private double d = 0.02;

    static {
        System.loadLibrary("MyJni");
    }

    public MyJni(){}

    public MyJni(String s){ name = s; }

    public MyJni(double d){ this.d = d; }

    public MyJni(boolean b){ this.yes = b; }

    public static native String sayHello();


    public String hello(String message){
       return sayHello() + ":" + message;
    }


    private String helloInt(int i){
        return sayHello() + ":" + i;
    }
}
