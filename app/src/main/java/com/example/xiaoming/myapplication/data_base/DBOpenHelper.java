package com.example.xiaoming.myapplication.data_base;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.Toast;

import com.example.xiaoming.myapplication.Util.mLog;


public class DBOpenHelper extends SQLiteOpenHelper implements BaseColumns {
    //super(Context context, String name, CursorFactory factory,int version);
    //String name:数据库名称
    private static final String DB_NAME = "contactinfo.db";
    //表名
    // 按年计算公积金
    private static final String SHUI = "SHUI";
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

        try {
            creatTable(db,GJJ);
            creatTable(db,BC_GJJ);
            creatTable(db,YAL);
            creatTable(db,YIL);
            creatTable(db,SHY);
            creatTable(db,GS);
            creatTable(db,SEY);
            creatTable(db,NJ);
            creatTable(db,HZ);
            creatTable(db,SHUI);
            mLog.v("ming","建表完成");
            //mmLog.i("ming", s);
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
//            insertTable(db,SHUI,"17000","5000","0.175");
//            insertTable(db,SHUI,"17000","5000","0.175");
//            insertTable(db,SHUI,"17000","5000","0.175");
//            insertTable(db,SHUI,"17000","5000","0.175");
//            insertTable(db,SHUI,"17000","5000","0.175");
//            insertTable(db,SHUI,"17000","5000","0.175");
//            insertTable(db,SHUI,"15000","12400","0.225");
//            insertTable(db,SHUI,"15000","12400","0.225");
//            insertTable(db,SHUI,"15000","12400","0.225");
//            insertTable(db,SHUI,"15000","12400","0.225");
//            insertTable(db,SHUI,"15000","12400","0.225");
//            insertTable(db,SHUI,"15000","12400","0.245");
            insertTable(db,SHUI,"5000","5000","0.175");
            insertTable(db,SHUI,"5000","5000","0.175");
            insertTable(db,SHUI,"5000","5000","0.175");
            insertTable(db,SHUI,"5000","5000","0.175");
            insertTable(db,SHUI,"5000","5000","0.175");
            insertTable(db,SHUI,"5000","5000","0.175");
            insertTable(db,SHUI,"5000","12400","0.175");
            insertTable(db,SHUI,"5000","12400","0.175");
            insertTable(db,SHUI,"5000","12400","0.175");
            insertTable(db,SHUI,"5000","12400","0.175");
            insertTable(db,SHUI,"5000","12400","0.175");
            insertTable(db,SHUI,"5000","12400","0.175");
        } catch (Exception e) {
            mLog.e("ming","初始化数据库失败");
        }
    }

    //创建表
    public void creatTable(SQLiteDatabase db,String  tableName){
        String s;
        if("SHUI".equals(tableName)){
            s = "create table "+tableName+"("+_ID+" integer primary key autoincrement,"+ "yuexin" +" varchar(20),"+ "jishu" +" varchar(20),bili varchar(20));";
        }else{
            s = "create table "+tableName+"("+_ID+" integer primary key autoincrement,"+ _gongsi +" varchar(20),"+ _geren +" varchar(20));";
        }
        db.execSQL(s);
        mLog.i("ming", "执行完成 创建表:" + tableName + "建表语句：" + s);
    }

    //初始化表内容
    public void insertTable(SQLiteDatabase db,String tableName,String yuexin,String jishu,String bili){
        String s = "insert into "+tableName+"(yuexin,jishu,bili)" + "values("+yuexin+","+jishu+","+bili+") ;";
        mLog.i("ming", s);
        db.execSQL(s);
        mLog.i("ming", "执行完成 初始化表内容");
    }


    public void insertTable(SQLiteDatabase db,String  tableName,String geren,String gongsi){
        String s = "insert into "+tableName+"("+_gongsi +","+ _geren +")" + "values("+geren+","+gongsi+") ;";
        mLog.i("ming", s);
        db.execSQL(s);
        mLog.i("ming", "执行完成 初始化表内容");
    }

    //更新表内容
    public void updateTable(SQLiteDatabase db,String tableName,String yuexin,String jishu,String bili,String id){
        String s = "update " + tableName+ " set yuexin='"+ yuexin +"',jishu='"+ jishu +"',bili='"+ bili +"' where _id ='"+ id +"';";
        mLog.i("ming", s);
        db.execSQL(s);
        mLog.i("ming", "执行完成 修改表内容,更新语句：" + s);
    }

    public void updateTable(SQLiteDatabase db,String tableName,String geren,String gongsi){
        String s = "update "+tableName+" set "+ _gongsi+"='"+gongsi +"',"+ _geren+"='"+geren +"' where _ID ='1';";
        mLog.i("ming", s);
        db.execSQL(s);
        mLog.i("ming", "执行完成 修改表内容");
    }

    //查找表内容--未完成
    public Cursor selectData(SQLiteDatabase db,String  tableName){
        String s = "select * from "+tableName+";";
        mLog.i("ming", s);
//        db.execSQL(s);
        mLog.i("ming", "执行完成 查询表内容");
        return db.rawQuery(s,null);
    }


    @Override
    //升级数据库，可以在该方法里修改数据库表,当数据库版本增加时，此方法被调用
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mLog.i("ming", "oldVersion="+oldVersion +"newVersion="+newVersion);//oldVersion=1newVersion=2
    }

}

