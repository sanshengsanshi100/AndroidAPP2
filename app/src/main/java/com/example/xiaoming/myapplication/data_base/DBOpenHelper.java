package com.example.xiaoming.myapplication.data_base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.Toast;


public class DBOpenHelper extends SQLiteOpenHelper implements BaseColumns {
    //super(Context context, String name, CursorFactory factory,int version);
    //String name:数据库名称
    private static final String DB_NAME = "contactinfo";
    //表名
    //公积金
    private static final String GJJ = "GJJ";
    //补充公积金
    private static final String BC_GJJ = "BC_GJJ";
    //养老
    private static final String YAL = "YAL";
    //医疗
    private static final String YIL = "YIL";
    //失业
    private static final String SHY = "SHY";
    //工伤
    private static final String GS = "GS";
    //生育
    private static final String SEY = "SEY";
    //年金
    private static final String NJ = "NJ";
    //汇总
    private static final String HZ = "HZ";
    //int version：数据库版本
    private static final int DB_VERSION = 1;
    //列名
    private static final String _gongsi = "gongsi";
    //列名2
    private static final String _geren = "geren";



    //CursorFactory factory:用来创建游标对象的工厂类
    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    //创建数据库文件后会调用onCreate()方法，可以在这个方法里创建数据库表
    public void onCreate(SQLiteDatabase db) {
        creatTable(db,GJJ);
        creatTable(db,BC_GJJ);
        creatTable(db,YAL);
        creatTable(db,YIL);
        creatTable(db,SHY);
        creatTable(db,GS);
        creatTable(db,SEY);
        creatTable(db,NJ);
        creatTable(db,HZ);
        //Log.i("ming", s);
        //db.execSQL(s);

        insertTable(db,GJJ,"1","2");
        insertTable(db,BC_GJJ,"1","2");
        insertTable(db,YAL,"1","2");
        insertTable(db,YIL,"1","2");
        insertTable(db,SHY,"1","2");
        insertTable(db,GS,"1","2");
        insertTable(db,SEY,"1","2");
        insertTable(db,NJ,"1","2");
        insertTable(db,HZ,"1","2");
    }

    //创建表
    public void creatTable(SQLiteDatabase db,String  tableName){
        String s = "create table "+tableName+"("+_ID+" integer primary key autoincrement,"+ _gongsi +" varchar(20),"+ _geren +" varchar(20));";
        Log.i("ming", s);
        db.execSQL(s);
        Log.i("ming", "执行完成 创建表");
    }

    //初始化表内容
    public void insertTable(SQLiteDatabase db,String  tableName,String geren,String gongsi){
        String s = "insert into "+tableName+"("+_gongsi +","+ _geren +")" + "values("+geren+","+gongsi+") ;";
        Log.i("ming", s);
        db.execSQL(s);
        Log.i("ming", "执行完成 初始化表内容");
    }

    //更新表内容
    public void updateTable(SQLiteDatabase db,String  tableName,String geren,String gongsi){
        String s = "update "+tableName+" set "+ _gongsi+"='"+gongsi +"',"+ _geren+"='"+geren +"' where _ID ='1';";
        Log.i("ming", s);
        db.execSQL(s);
        Log.i("ming", "执行完成 修改表内容");
    }

    //查找表内容--未完成
    public void selectData(SQLiteDatabase db,String  tableName,String geren,String gongsi){
        String s = "select "+tableName+" set "+ _gongsi+"='"+gongsi +"',"+ _geren+"='"+geren +"' where _ID ='1';";
        Log.i("ming", s);
        db.execSQL(s);
        Log.i("ming", "执行完成 修改表内容");
    }


    @Override
    //升级数据库，可以在该方法里修改数据库表,当数据库版本增加时，此方法被调用
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("ming", "oldVersion="+oldVersion +"newVersion="+newVersion);//oldVersion=1newVersion=2
    }

}

