package com.example.xiaoming.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.math.BigDecimal;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xiaoming.myapplication.Util.mLog;
import com.example.xiaoming.myapplication.data_base.DBOpenHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Tax3 extends AppCompatActivity{


    public DBOpenHelper helper;
    public SQLiteDatabase db;

    public EditText yx1;
    public EditText yx2;
    public EditText yx3;
    public EditText yx4;
    public EditText yx5;
    public EditText yx6;
    public EditText yx7;
    public EditText yx8;
    public EditText yx9;
    public EditText yx10;
    public EditText yx11;
    public EditText yx12;
    public EditText yx13;
    public EditText yx14;

    public EditText js1;
    public EditText js2;
    public EditText js3;
    public EditText js4;
    public EditText js5;
    public EditText js6;
    public EditText js7;
    public EditText js8;
    public EditText js9;
    public EditText js10;
    public EditText js11;
    public EditText js12;
    public EditText js13;
    public EditText js14;

    public EditText bl1;
    public EditText bl2;
    public EditText bl3;
    public EditText bl4;
    public EditText bl5;
    public EditText bl6;
    public EditText bl7;
    public EditText bl8;
    public EditText bl9;
    public EditText bl10;
    public EditText bl11;
    public EditText bl12;
    public EditText bl13;
    public EditText bl14;


    public TextView sb1;
    public TextView sb2;
    public TextView sb3;
    public TextView sb4;
    public TextView sb5;
    public TextView sb6;
    public TextView sb7;
    public TextView sb8;
    public TextView sb9;
    public TextView sb10;
    public TextView sb11;
    public TextView sb12;
    public TextView sb13;
    public TextView sb14;

    public TextView sq1;
    public TextView sq2;
    public TextView sq3;
    public TextView sq4;
    public TextView sq5;
    public TextView sq6;
    public TextView sq7;
    public TextView sq8;
    public TextView sq9;
    public TextView sq10;
    public TextView sq11;
    public TextView sq12;
    public TextView sq13;
    public TextView sq14;

    // 专项扣除
    public EditText zx;
    // 年薪汇总（扣除社保之前）
    public TextView nianxin;
    // 缴税金额
    public TextView jiaoshui;
    //税后年薪
    public TextView shuihou;
    //税后年薪+金
    public TextView nianxinjiajin;

    public HashMap<String,EditText> mYx = new HashMap<String,EditText>();
    public HashMap<String,EditText> mJs = new HashMap<String,EditText>();
    public HashMap<String,EditText> mBl = new HashMap<String,EditText>();
    public HashMap<String,TextView> mSb = new HashMap<String,TextView>();
    public HashMap<String,TextView> mSq = new HashMap<String,TextView>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tax_year);
        //实现状态栏沉浸效果
        QMUIStatusBarHelper.translucent(this);
        new Thread(new Runnable(){
            @Override
            public void run(){
                //处理具体的逻辑
                yx1=findViewById(R.id.ed_yx_1);
                yx2=findViewById(R.id.ed_yx_2);
                yx3=findViewById(R.id.ed_yx_3);
                yx4=findViewById(R.id.ed_yx_4);
                yx5=findViewById(R.id.ed_yx_5);
                yx6=findViewById(R.id.ed_yx_6);
                yx7=findViewById(R.id.ed_yx_7);
                yx8=findViewById(R.id.ed_yx_8);
                yx9=findViewById(R.id.ed_yx_9);
                yx10=findViewById(R.id.ed_yx_10);
                yx11=findViewById(R.id.ed_yx_11);
                yx12=findViewById(R.id.ed_yx_12);
                yx13=findViewById(R.id.ed_yx_13);
                yx14=findViewById(R.id.ed_yx_14);

                mLog.v("ming","开始了");
                mYx.put("yx1",yx1);
                mYx.put("yx2",yx2);
                mYx.put("yx3",yx3);
                mYx.put("yx4",yx4);
                mYx.put("yx5",yx5);
                mYx.put("yx6",yx6);
                mYx.put("yx7",yx7);
                mYx.put("yx8",yx8);
                mYx.put("yx9",yx9);
                mYx.put("yx10",yx10);
                mYx.put("yx11",yx11);
                mYx.put("yx12",yx12);
                mYx.put("yx13",yx13);
                mYx.put("yx14",yx14);


                js1=findViewById(R.id.ed_js_1);
                js2=findViewById(R.id.ed_js_2);
                js3=findViewById(R.id.ed_js_3);
                js4=findViewById(R.id.ed_js_4);
                js5=findViewById(R.id.ed_js_5);
                js6=findViewById(R.id.ed_js_6);
                js7=findViewById(R.id.ed_js_7);
                js8=findViewById(R.id.ed_js_8);
                js9=findViewById(R.id.ed_js_9);
                js10=findViewById(R.id.ed_js_10);
                js11=findViewById(R.id.ed_js_11);
                js12=findViewById(R.id.ed_js_12);
                js13=findViewById(R.id.ed_js_13);
                js14=findViewById(R.id.ed_js_14);

                mJs.put("js1",js1);
                mJs.put("js2",js2);
                mJs.put("js3",js3);
                mJs.put("js4",js4);
                mJs.put("js5",js5);
                mJs.put("js6",js6);
                mJs.put("js7",js7);
                mJs.put("js8",js8);
                mJs.put("js9",js9);
                mJs.put("js10",js10);
                mJs.put("js11",js11);
                mJs.put("js12",js12);
                mJs.put("js13",js13);
                mJs.put("js14",js14);

                bl1=findViewById(R.id.ed_bl_1);
                bl2=findViewById(R.id.ed_bl_2);
                bl3=findViewById(R.id.ed_bl_3);
                bl4=findViewById(R.id.ed_bl_4);
                bl5=findViewById(R.id.ed_bl_5);
                bl6=findViewById(R.id.ed_bl_6);
                bl7=findViewById(R.id.ed_bl_7);
                bl8=findViewById(R.id.ed_bl_8);
                bl9=findViewById(R.id.ed_bl_9);
                bl10=findViewById(R.id.ed_bl_10);
                bl11=findViewById(R.id.ed_bl_11);
                bl12=findViewById(R.id.ed_bl_12);
                bl13=findViewById(R.id.ed_bl_13);
                bl14=findViewById(R.id.ed_bl_14);

                mBl.put("bl1",bl1);
                mBl.put("bl2",bl2);
                mBl.put("bl3",bl3);
                mBl.put("bl4",bl4);
                mBl.put("bl5",bl5);
                mBl.put("bl6",bl6);
                mBl.put("bl7",bl7);
                mBl.put("bl8",bl8);
                mBl.put("bl9",bl9);
                mBl.put("bl10",bl10);
                mBl.put("bl11",bl11);
                mBl.put("bl12",bl12);
                mBl.put("bl13",bl13);
                mBl.put("bl14",bl14);


                sb1=findViewById(R.id.ed_sb_1);
                sb2=findViewById(R.id.ed_sb_2);
                sb3=findViewById(R.id.ed_sb_3);
                sb4=findViewById(R.id.ed_sb_4);
                sb5=findViewById(R.id.ed_sb_5);
                sb6=findViewById(R.id.ed_sb_6);
                sb7=findViewById(R.id.ed_sb_7);
                sb8=findViewById(R.id.ed_sb_8);
                sb9=findViewById(R.id.ed_sb_9);
                sb10=findViewById(R.id.ed_sb_10);
                sb11=findViewById(R.id.ed_sb_11);
                sb12=findViewById(R.id.ed_sb_12);
                sb13=findViewById(R.id.ed_sb_13);
                sb14=findViewById(R.id.ed_sb_14);

                mSb.put("sb1",sb1);
                mSb.put("sb2",sb2);
                mSb.put("sb3",sb3);
                mSb.put("sb4",sb4);
                mSb.put("sb5",sb5);
                mSb.put("sb6",sb6);
                mSb.put("sb7",sb7);
                mSb.put("sb8",sb8);
                mSb.put("sb9",sb9);
                mSb.put("sb10",sb10);
                mSb.put("sb11",sb11);
                mSb.put("sb12",sb12);
                mSb.put("sb13",sb13);
                mSb.put("sb14",sb14);

                sq1=findViewById(R.id.tv_sq_1);
                sq2=findViewById(R.id.tv_sq_2);
                sq3=findViewById(R.id.tv_sq_3);
                sq4=findViewById(R.id.tv_sq_4);
                sq5=findViewById(R.id.tv_sq_5);
                sq6=findViewById(R.id.tv_sq_6);
                sq7=findViewById(R.id.tv_sq_7);
                sq8=findViewById(R.id.tv_sq_8);
                sq9=findViewById(R.id.tv_sq_9);
                sq10=findViewById(R.id.tv_sq_10);
                sq11=findViewById(R.id.tv_sq_11);
                sq12=findViewById(R.id.tv_sq_12);
                sq13=findViewById(R.id.tv_sq_13);
                sq14=findViewById(R.id.tv_sq_14);

                mSq.put("sq1",sq1);
                mSq.put("sq2",sq2);
                mSq.put("sq3",sq3);
                mSq.put("sq4",sq4);
                mSq.put("sq5",sq5);
                mSq.put("sq6",sq6);
                mSq.put("sq7",sq7);
                mSq.put("sq8",sq8);
                mSq.put("sq9",sq9);
                mSq.put("sq10",sq10);
                mSq.put("sq11",sq11);
                mSq.put("sq12",sq12);
                mSq.put("sq13",sq13);
                mSq.put("sq14",sq14);

                zx = findViewById(R.id.et_zhuanxiangkouchu);
                nianxin = findViewById(R.id.tv_shuiqiannianxin);
                jiaoshui = findViewById(R.id.tv_zongjiaoshui);
                shuihou = findViewById(R.id.tv_nianxin_shuihou);
                nianxinjiajin = findViewById(R.id.tv_nianxinjiajin);



            }
        }).start();

        try {
            //创建一个数据库文件
            helper = new DBOpenHelper(this);
            //以下两种方式都可创建数据库文件
            //helper.getReadableDatabase();
            db = helper.getWritableDatabase();
            Cursor cursor = helper.selectData(db,"SHUI");
            int i = 0;
            while(cursor.moveToNext()) {
                i += 1;
                try {
                    String yx = cursor.getString(cursor.getColumnIndex("yuexin"));
                    String js = cursor.getString(cursor.getColumnIndex("jishu"));
                    String bl = cursor.getString(cursor.getColumnIndex("bili"));
                    mLog.v("ming"," 月薪 : " + yx + "基数: " + js + "比例：" + bl);
                    setMessage(mYx.get("yx" + i),new BigDecimal(yx));
                    setMessage(mJs.get("js" + i),new BigDecimal(js));
                    setMessage(mBl.get("bl" + i),new BigDecimal(bl));
                } catch (Exception e) {
                    mLog.e("ming","回填信息失败,i=" + i + "错误信息" + e.getMessage());
                }
            }
        } catch (Exception e) {
            mLog.e("ming","初始化数据库失败");
        } finally {
            if(db.isOpen()){
                db.close();
                mLog.v("ming","关闭DB");
            }else{
                mLog.e("ming","DB是关闭的");
            }

        }
    }

    public void taxCacl(View v){
        BigDecimal hzYx = BigDecimal.valueOf(0);
        BigDecimal hzJs = BigDecimal.valueOf(0);
        BigDecimal hzSb = BigDecimal.valueOf(0);
        BigDecimal hzSq = BigDecimal.valueOf(0);
        BigDecimal hzGjj = BigDecimal.valueOf(0);

        for(int i=1;i<14;i++){
            BigDecimal js = getProportion2(mJs.get("js" + i));
            BigDecimal bl = getProportion2(mBl.get("bl" + i));
            BigDecimal yx = getProportion2(mYx.get("yx"+i));
            // 计算社保
            BigDecimal shebao = js.multiply(bl);
            // 计算扣除社保后的税前工资
            BigDecimal sq = yx.subtract(shebao);
            // 显示
            setMessage(mSb.get("sb" + i),shebao);
            setMessage(mSq.get("sq" + i),sq);

            // 计算汇总
            hzYx = hzYx.add(yx);
            hzJs = hzJs.add(js);
            hzSb = hzSb.add(shebao);
            hzSq = hzSq.add(sq);
            hzGjj = hzGjj.add(js.multiply(new BigDecimal("0.24")));
        }

        setMessage(mYx.get("yx14"),hzYx);
        setMessage(mJs.get("js14"),hzJs);
        setMessage(mSb.get("sb14"),hzSb);
        setMessage(mSq.get("sq14"),hzSq);

        // 计算纳税金额
        // 年薪-税前
        setMessage(nianxin,hzSq);
        // 缴税金额
        BigDecimal shuie = taxCaclAfterYear(hzJs,getProportion2(zx));
        setMessage(jiaoshui,shuie);
        // 年薪-税后
        setMessage(shuihou,hzSq.subtract(shuie));
        // 年薪（税后）+金
        setMessage(nianxinjiajin,hzSq.subtract(shuie).add(hzGjj));
    }


    //保存事件
    public void saveDataClick(View v){
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
        if (!db.isOpen()) {
            //创建一个数据库文件
            helper = new DBOpenHelper(this);
            //以下两种方式都可创建数据库文件
            //helper.getReadableDatabase();
            db = helper.getWritableDatabase();
        } else {
            mLog.v("ming","db已打开");
        }
        for(int i=1;i<13;i++){
            helper.updateTable(db,"SHUI",getProportion2(mYx.get("yx" + i)).toString(),
                    getProportion2(mJs.get("js" + i)).toString(),getProportion2(mBl.get("bl" + i)).toString(),i+"");
        }
    }


    //BigDecimal计算 获取输入框内容
    public BigDecimal getProportion2(EditText et){
//        EditText et = (EditText)findViewById(id);
        String b = String.valueOf(et.getText());
        if (b.equals("")){
            return  new BigDecimal("0");
        }else{
            return new BigDecimal(b);
        }
    }


    public void setMessage(TextView et,BigDecimal b){
        mLog.v("ming","setMessage-TextView值为：" + b.toString());
        et.setText(String.format(b.toString() ,"%f"));

    }

    public void setMessage(EditText et,BigDecimal b){
        mLog.v("ming","setMessage-EditText值为：" + b.toString());
        et.setText(String.format(b.toString() ,"%f"));
    }

    public EditText getView(int id){
        EditText et = (EditText)findViewById(id);
        return et;
    }


    //BigDecimal计算月薪纳税金额-按年
    public BigDecimal taxCaclAfterYear(BigDecimal hzYx ,BigDecimal zxkc){
        BigDecimal sum = new BigDecimal("0.00");
        //免征额
        BigDecimal mianzhenge = BigDecimal.valueOf(60000);
        //应纳税所得额=收入-免征额-专项扣除
        mLog.v("taxCaclAfterYear","专项扣除=" + zxkc.toString() + "   计算前的年薪=" + hzYx.toString());
        double d = hzYx.subtract(mianzhenge).subtract(zxkc).doubleValue();
        if (d > 0){
            if (d <= 36000){
                sum = hzYx.multiply(new BigDecimal("0.03"));
                //mmLog.v("<36000的税额","月份"+i+"收入"+ d +"税额："+ sum);
            }else if (d > 36000 && d <= 144000){
                sum = hzYx.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("2520"));
            }else if(d > 144000 && d <= 300000){
                sum = hzYx.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("16920"));
            }else if(d > 300000 && d <= 420000){
                sum = hzYx.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("31920"));
            }else if(d > 420000 && d <= 660000){
                sum = hzYx.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("52920"));
            }else if(d > 660000 && d <= 960000){
                sum = hzYx.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("85920"));
            }else if(d > 960000){
                sum = hzYx.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("181920"));
            }
        }else{
            return sum;
        }
        return sum;
    }
}
