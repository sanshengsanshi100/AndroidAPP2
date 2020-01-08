package com.example.xiaoming.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.icu.math.BigDecimal;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xiaoming.myapplication.data_base.DBOpenHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import java.util.HashMap;

//import android.support.v7.app.AppCompatActivity;

public class Tax2_bak2 extends AppCompatActivity {

    private EditText tvBefore;
    private TextView tvAfter;
    private TextView tvGongjijin;
    private TextView tvBuchongGongjijin;
    private TextView tvYanglao;
    private TextView tvyiliao;
    private TextView tvshiye;
    private TextView tvshengyu;
    private TextView tvhuizong;
    private TextView tvhuizong_bl;
    private EditText etjishu;
    private TextView tshui;
    private EditText etyueshu;
    private TextView tvqiyenianjin;
    //公司部分
    private TextView tvGongjijin_gs;
    private TextView tvBuchongGongjijin_gs;
    private TextView tvYanglao_gs;
    private TextView tvyiliao_gs;
    private TextView tvshiye_gs;
    private TextView tvshengyu_gs;
    private TextView tvgongshang_gs;
    private TextView tvhuizong_gs;
    private TextView tvhuizong_gs_bl;
    private TextView tvqiyenianjin_gs;
    private TextView tvzongzhichu_gs;
    //设置月薪基数=12
    private final BigDecimal YXJS = new BigDecimal("12");
    //年终奖部分
    private TextView tvNianzhongjiang;
    private TextView tvNianzhongjiang_shui;
    //年薪
    private TextView tvNianxin;
    //专项扣除
    private EditText etZhuanxiangkouchu;
    //设置全局专项扣除变量
    private BigDecimal bdZhuanxiangkouchu = new BigDecimal("0");
    //年薪+公积金
    private TextView tvNIanxinjiajin;
    private DBOpenHelper helper;
    private SQLiteDatabase db;


    //回填各种比例用
    private EditText etGongjijin_gs_bl;
    private EditText etBuchongGongjijin_gs_bl;
    private EditText etYanglao_gs_bl;
    private EditText etyiliao_gs_bl;
    private EditText etshiye_gs_bl;
    private EditText etgongshang_gs_bl;
    private EditText etshengyu_gs_bl;
    private EditText etqiyenianjin_gs_bl;
    private EditText ethuizong_gs_bl;
    private EditText etGongjijin_bl;
    private EditText etBuchongGongjijin_bl;
    private EditText etYanglao_bl;
    private EditText etyiliao_bl;
    private EditText etshiye_bl;
    private EditText etgongshang_bl;
    private EditText etshengyu_bl;
    private EditText etqiyenianjin_bl;
    private EditText ethuizong_bl;

    //回填各月的收入和个税

    private TextView tv_1yue_shui;
    private TextView tv_2yue_shui;
    private TextView tv_3yue_shui;
    private TextView tv_4yue_shui;
    private TextView tv_5yue_shui;
    private TextView tv_6yue_shui;
    private TextView tv_7yue_shui;
    private TextView tv_8yue_shui;
    private TextView tv_9yue_shui;
    private TextView tv_10yue_shui;
    private TextView tv_11yue_shui;
    private TextView tv_12yue_shui;
    private TextView tv_nianzhong_shui;
    private TextView tv_huizong_nian_shui;

    private TextView tv_1yue;
    private TextView tv_2yue;
    private TextView tv_3yue;
    private TextView tv_4yue;
    private TextView tv_5yue;
    private TextView tv_6yue;
    private TextView tv_7yue;
    private TextView tv_8yue;
    private TextView tv_9yue;
    private TextView tv_10yue;
    private TextView tv_11yue;
    private TextView tv_12yue;
    private TextView tv_nianzhong;
    private TextView tv_huizong_nian;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tax2);
        //实现状态栏沉浸效果
        QMUIStatusBarHelper.translucent(this);
        tvBefore = (EditText)findViewById(R.id.et_before);
        tvAfter = (TextView)findViewById(R.id.et_after);
        tvGongjijin = (TextView)findViewById(R.id.tv_gongjijin);
        tvBuchongGongjijin = (TextView)findViewById(R.id.tv_buchong);
        tvYanglao = (TextView)findViewById(R.id.tv_yanglao);
        tvyiliao = (TextView)findViewById(R.id.tv_yiliao);
        tvshiye = (TextView)findViewById(R.id.tv_shiye);

        etjishu = (EditText) findViewById(R.id.et_jishu);
        tshui = (TextView)findViewById(R.id.tv_shui);
        tvhuizong = (TextView)findViewById(R.id.tv_huizong);
        etyueshu = (EditText)findViewById(R.id.et_yueshu);
        tvhuizong_bl = (TextView)findViewById(R.id.bl_huizong);
        tvqiyenianjin = (TextView)findViewById(R.id.tv_nianjin);
        //公司部分
        tvGongjijin_gs = (TextView)findViewById(R.id.tv_gongjijin_gs);
        tvBuchongGongjijin_gs = (TextView)findViewById(R.id.tv_buchong_gs);
        tvYanglao_gs = (TextView)findViewById(R.id.tv_yanglao_gs);
        tvyiliao_gs = (TextView)findViewById(R.id.tv_yiliao_gs);
        tvshiye_gs = (TextView)findViewById(R.id.tv_shiye_gs);
        tvshengyu_gs = (TextView)findViewById(R.id.tv_shengyu_gs);
        tvgongshang_gs = (TextView)findViewById(R.id.tv_gongshang_gs);
        tvhuizong_gs = (TextView)findViewById(R.id.tv__huizong_gs);
        tvhuizong_gs_bl = (TextView)findViewById(R.id.bl_huizong_gs);
        tvqiyenianjin_gs = (TextView)findViewById(R.id.tv_nianjin_gs);
        tvzongzhichu_gs = (TextView)findViewById(R.id.tv_zongzhichu);
        //年终奖
        tvNianzhongjiang = (TextView)findViewById(R.id.tv_nianzhongjiang);
        tvNianzhongjiang_shui = (TextView)findViewById(R.id.tv_nianzhongjiang_shui);
        //年薪
        tvNianxin = (TextView)findViewById(R.id.tv_nianxin);
        //专项扣除
        etZhuanxiangkouchu = (EditText) findViewById(R.id.et_zhuanxiangkouchu);
        //年薪加公积金
        tvNIanxinjiajin = (TextView)findViewById(R.id.tv_nianxinjiajin);

        //获取比例输入框
        etGongjijin_gs_bl = getView(R.id.bl_gongjijin_gs);
        etBuchongGongjijin_gs_bl = getView(R.id.bl_buchong_gs);
        etYanglao_gs_bl = getView(R.id.bl_yanglao_gs);
        etyiliao_gs_bl = getView(R.id.bl_yiliao_gs);
        etshiye_gs_bl = getView(R.id.bl_shiye_gs);
        etgongshang_gs_bl = getView(R.id.bl_gongshang_gs);
        etshengyu_gs_bl = getView(R.id.bl_shengyu_gs);
        etqiyenianjin_gs_bl = getView(R.id.bl_nianjin_gs);
        //ethuizong_gs_bl = getView(R.id.bl_huizong_gs);
        etGongjijin_bl = getView(R.id.bl_gongjijin);
        etBuchongGongjijin_bl = getView(R.id.bl_buchong);
        etYanglao_bl = getView(R.id.bl_yanglao);
        etyiliao_bl = getView(R.id.bl_yiliao);
        etshiye_bl = getView(R.id.bl_shiye);
        etgongshang_bl = getView(R.id.bl_gongshang);
        etshengyu_bl = getView(R.id.bl_shengyu);
        etqiyenianjin_bl = getView(R.id.bl_nianjin);
        //ethuizong_bl = getView(R.id.bl_huizong);

        //按月显示个税和收入
        tv_1yue = findViewById(R.id.tv_1yue);
        tv_2yue = findViewById(R.id.tv_2yue);
        tv_3yue = findViewById(R.id.tv_3yue);
        tv_4yue = findViewById(R.id.tv_4yue);
        tv_5yue = findViewById(R.id.tv_5yue);
        tv_6yue = findViewById(R.id.tv_6yue);
        tv_7yue = findViewById(R.id.tv_7yue);
        tv_8yue = findViewById(R.id.tv_8yue);
        tv_9yue = findViewById(R.id.tv_9yue);
        tv_10yue = findViewById(R.id.tv_10yue);
        tv_11yue = findViewById(R.id.tv_11yue);
        tv_12yue = findViewById(R.id.tv_12yue);
        tv_nianzhong = findViewById(R.id.tv_nianzhong);
        tv_huizong_nian = findViewById(R.id.tv_huizong_nian);

        tv_1yue_shui = findViewById(R.id.tv_1yue_shui);
        tv_2yue_shui = findViewById(R.id.tv_2yue_shui);
        tv_3yue_shui = findViewById(R.id.tv_3yue_shui);
        tv_4yue_shui = findViewById(R.id.tv_4yue_shui);
        tv_5yue_shui = findViewById(R.id.tv_5yue_shui);
        tv_6yue_shui = findViewById(R.id.tv_6yue_shui);
        tv_7yue_shui = findViewById(R.id.tv_7yue_shui);
        tv_8yue_shui = findViewById(R.id.tv_8yue_shui);
        tv_9yue_shui = findViewById(R.id.tv_9yue_shui);
        tv_10yue_shui = findViewById(R.id.tv_10yue_shui);
        tv_11yue_shui = findViewById(R.id.tv_11yue_shui);
        tv_12yue_shui = findViewById(R.id.tv_12yue_shui);
        tv_nianzhong_shui = findViewById(R.id.tv_nianzhong_shui);
        tv_huizong_nian_shui = findViewById(R.id.tv_huizong_nian_shui);

        //创建一个数据库文件
        helper = new DBOpenHelper(this);
        //以下两种方式都可创建数据库文件
        //helper.getReadableDatabase();
        db = helper.getWritableDatabase();
    }

    public void taxCacl(View v){
        //获取月薪
        String befor = String.valueOf(tvBefore.getText());
        if(befor.equals("")){
            befor = "0";
            Toast.makeText(this,"请输入正确的月薪",Toast.LENGTH_SHORT).show();
        }else {
            BigDecimal bdBefor = new BigDecimal(befor);
            //获取月缴费基数,
            String jishu = String.valueOf(etjishu.getText());
            if (jishu.equals("")) {
                jishu = befor;
                etjishu.setText(jishu);
            }
            //判断缴费基数若大于上限则设置为上限，小于下限则设置为下限
            if (new BigDecimal(jishu).doubleValue() <= 4927) {
                jishu = "4927";
                etjishu.setText(jishu);
            } else if (new BigDecimal(jishu).doubleValue() >= 24633) {
                jishu = "24633";
                etjishu.setText(jishu);
            }
            //获取每年的薪酬月数
            String yueshu = String.valueOf(etyueshu.getText());
            if (yueshu.equals("")) {
                yueshu = "12";
                etyueshu.setText(yueshu);
            }
            BigDecimal bdYueshu = new BigDecimal(yueshu);

            //获取专项扣除数
            String zhuanxiangkouchu = String.valueOf(etZhuanxiangkouchu.getText());
            if (zhuanxiangkouchu.equals("")) {
                zhuanxiangkouchu = "0";
                etZhuanxiangkouchu.setText(zhuanxiangkouchu);
            }
            bdZhuanxiangkouchu = new BigDecimal(zhuanxiangkouchu);

            //BigDecimal类型计算
            //根据缴费基数进行计算个人五险一金的缴费额，并保留两位小数
            //
            BigDecimal dGongjijin_bl = new BigDecimal(getProportion2(R.id.bl_gongjijin));
            BigDecimal dGongjijin = new BigDecimal(jishu).multiply(dGongjijin_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //
            BigDecimal dBuchongGongjijin_bl = new BigDecimal(getProportion2(R.id.bl_buchong));
            BigDecimal dBuchongGongjijin = new BigDecimal(jishu).multiply(dBuchongGongjijin_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //
            BigDecimal dYanglao_bl = new BigDecimal(getProportion2(R.id.bl_yanglao));
            BigDecimal dYanglao = new BigDecimal(jishu).multiply(dYanglao_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //
            BigDecimal dyiliao_bl = new BigDecimal(getProportion2(R.id.bl_yiliao));
            BigDecimal dyiliao = new BigDecimal(jishu).multiply(dyiliao_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //
            BigDecimal dshiye_bl = new BigDecimal(getProportion2(R.id.bl_shiye));
            Log.e("ming", "dshiye_bl" + dshiye_bl);
            BigDecimal dshiye = new BigDecimal(jishu).multiply(dshiye_bl).setScale(2, BigDecimal.ROUND_HALF_UP);

            //工伤
            BigDecimal dgongshang_bl = new BigDecimal(getProportion2(R.id.bl_gongshang));
            BigDecimal dgongshang = new BigDecimal(jishu).multiply(dgongshang_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //生育
            BigDecimal dshengyu_bl = new BigDecimal(getProportion2(R.id.bl_shengyu));
            BigDecimal dshengyu = new BigDecimal(jishu).multiply(dshengyu_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            Log.e("ming", "生育险-公司：" + dshengyu.doubleValue());

            //企业年金
            BigDecimal dqiyenianjin_bl = new BigDecimal(getProportion2(R.id.bl_nianjin));
            BigDecimal dqiyenianjin = new BigDecimal(jishu).multiply(dqiyenianjin_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //
            BigDecimal dhuizong_bl = dGongjijin_bl.add(dBuchongGongjijin_bl).add(dYanglao_bl).
                    add(dyiliao_bl).add(dshiye_bl).add(dqiyenianjin_bl);
            BigDecimal dhuizong = dGongjijin.add(dBuchongGongjijin).add(dYanglao).add(dyiliao).
                    add(dshiye).add(dqiyenianjin);


            //根据缴费基数进行计算公司五险一金的缴费额，并保留两位小数
            //公积金
            BigDecimal dGongjijin_gs_bl = new BigDecimal(getProportion2(R.id.bl_gongjijin_gs));
            BigDecimal dGongjijin_gs = new BigDecimal(jishu).multiply(dGongjijin_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //补充公积金
            BigDecimal dBuchongGongjijin_gs_bl = new BigDecimal(getProportion2(R.id.bl_buchong_gs));
            BigDecimal dBuchongGongjijin_gs = new BigDecimal(jishu).multiply(dBuchongGongjijin_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //养老
            BigDecimal dYanglao_gs_bl = new BigDecimal(getProportion2(R.id.bl_yanglao_gs));
            BigDecimal dYanglao_gs = new BigDecimal(jishu).multiply(dYanglao_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //医疗
            BigDecimal dyiliao_gs_bl = new BigDecimal(getProportion2(R.id.bl_yiliao_gs));
            BigDecimal dyiliao_gs = new BigDecimal(jishu).multiply(dyiliao_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //失业
            BigDecimal dshiye_gs_bl = new BigDecimal(getProportion2(R.id.bl_shiye_gs));
            BigDecimal dshiye_gs = new BigDecimal(jishu).multiply(dshiye_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //工伤
            BigDecimal dgongshang_gs_bl = new BigDecimal(getProportion2(R.id.bl_gongshang_gs));
            BigDecimal dgongshang_gs = new BigDecimal(jishu).multiply(dgongshang_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //生育
            BigDecimal dshengyu_gs_bl = new BigDecimal(getProportion2(R.id.bl_shengyu_gs));
            BigDecimal dshengyu_gs = new BigDecimal(jishu).multiply(dshengyu_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            Log.e("ming", "生育险-公司：" + dshengyu_gs.doubleValue());
            //企业年金
            BigDecimal dqiyenianjin_gs_bl = new BigDecimal(getProportion2(R.id.bl_nianjin_gs));
            BigDecimal dqiyenianjin_gs = new BigDecimal(jishu).multiply(dqiyenianjin_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //比例和
            BigDecimal dhuizong_gs_bl = dGongjijin_gs_bl.add(dBuchongGongjijin_gs_bl).add(dYanglao_gs_bl)
                    .add(dyiliao_gs_bl).add(dshiye_gs_bl).add(dgongshang_gs_bl).add(dqiyenianjin_gs_bl).add(dshengyu_gs_bl);
            //金额和
            BigDecimal dhuizong_gs = dGongjijin_gs.add(dBuchongGongjijin_gs).add(dYanglao_gs).add(dyiliao_gs)
                    .add(dshiye_gs).add(dgongshang_gs).add(dqiyenianjin_gs).add(dshengyu_gs);
            //扣除五险一金后的收入金额
            BigDecimal beforR = new BigDecimal(befor).subtract(dGongjijin).subtract(dBuchongGongjijin)
                    .subtract(dYanglao).subtract(dyiliao).subtract(dshiye).subtract(dqiyenianjin);
            //缴税金额
            Log.e("ming", "befor=" + befor);
            Log.e("ming", "beforR=" + beforR.toString());
            BigDecimal shui = taxCaclAfter(beforR).setScale(2, BigDecimal.ROUND_HALF_UP);
            //税后
            BigDecimal dAfter = beforR.subtract(shui).setScale(2, BigDecimal.ROUND_HALF_UP);
            if (dAfter.doubleValue() < 0) {
                Toast.makeText(this, "穷人不配计算个税O(∩_∩)O哈哈~", Toast.LENGTH_SHORT).show();

            } else {
                //年终奖
                BigDecimal dEndShui = new BigDecimal("0");
                BigDecimal dEnd = new BigDecimal("0");
                if (bdYueshu.doubleValue() > 12) {
                    //年终奖-税
                    dEndShui = taxCaclAfterEnd(bdYueshu.subtract(YXJS).multiply(bdBefor));
                    //年终奖
                    dEnd = bdYueshu.subtract(YXJS).multiply(bdBefor).subtract(dEndShui);
                }
                tvNianzhongjiang.setText(String.format(dEnd.toString(), "%f"));
                tvNianzhongjiang_shui.setText(String.format(dEndShui.toString(), "%f"));
                //年薪-个人
                BigDecimal dAll;
                //当年薪月数小于12时使用实际月数计算，大于12时使用标准月数+年终奖数计算
                if (bdYueshu.doubleValue() < 12) {
                    dAll = dAfter.multiply(bdYueshu).add(dEnd);
                } else {
                    dAll = dAfter.multiply(YXJS).add(dEnd);
                }
                tvNianxin.setText(String.format(dAll.toString(), "%f"));

                //年薪+公积金
                BigDecimal dNianxinjiajin;
                //当年薪月数小于12时使用实际月数计算，大于12时使用标准月数+年终奖数计算
                if (bdYueshu.doubleValue() < 12) {
                    dNianxinjiajin = dAfter.multiply(bdYueshu).add(dEnd).add(bdYueshu.multiply(dGongjijin.add(dBuchongGongjijin)
                            .add(dGongjijin_gs).add(dBuchongGongjijin_gs)));
                } else {
                    dNianxinjiajin = dAfter.multiply(YXJS).add(dEnd).add(YXJS.multiply(dGongjijin.add(dBuchongGongjijin)
                            .add(dGongjijin_gs).add(dBuchongGongjijin_gs)));
                }
                tvNIanxinjiajin.setText(String.format(dNianxinjiajin.toString(), "%f"));

                //公司总支出等于月薪*月数+缴费*12
                BigDecimal dZongzhichu;
                //当年薪月数小于12时使用实际月数计算，大于12时使用标准月数交金+实际月数*月薪计算
                if (bdYueshu.doubleValue() < 12) {
                    dZongzhichu = bdBefor.multiply(bdYueshu).add(bdYueshu.multiply(dhuizong_gs));
                } else {
                    dZongzhichu = bdBefor.multiply(bdYueshu).add(YXJS.multiply(dhuizong_gs));
                }
                tvzongzhichu_gs.setText(String.format(dZongzhichu.toString(), "%f"));
                //显示在界面

                tvAfter.setText(String.format(dAfter.toString(), "%f"));
                tvGongjijin.setText(String.format(dGongjijin.toString(), "%f"));
                tvBuchongGongjijin.setText(String.format(dBuchongGongjijin.toString(), "%f"));
                tvYanglao.setText(String.format(dYanglao.toString(), "%f"));
                tvyiliao.setText(String.format(dyiliao.toString(), "%f"));
                tvshiye.setText(String.format(dshiye.toString(), "%f"));
                tshui.setText(String.format(shui.toString(), "%f"));
                tvhuizong.setText(String.format(dhuizong.toString(), "%f"));
                tvhuizong_bl.setText(String.format(dhuizong_bl.toString(), "%f"));
                tvqiyenianjin.setText(String.format(dqiyenianjin.toString(), "%f"));

                //公司部分
                tvGongjijin_gs.setText(String.format(dGongjijin_gs.toString(), "%f"));
                tvBuchongGongjijin_gs.setText(String.format(dBuchongGongjijin_gs.toString(), "%f"));
                tvYanglao_gs.setText(String.format(dYanglao_gs.toString(), "%f"));
                tvyiliao_gs.setText(String.format(dyiliao_gs.toString(), "%f"));
                tvshiye_gs.setText(String.format(dshiye_gs.toString(), "%f"));
                tvshengyu_gs.setText(String.format(dshengyu_gs.toString(), "%f"));
                tvgongshang_gs.setText(String.format(dgongshang_gs.toString(), "%f"));
                tvhuizong_gs.setText(String.format(dhuizong_gs.toString(), "%f"));
                tvhuizong_gs_bl.setText(String.format(dhuizong_gs_bl.toString(), "%f"));
                tvqiyenianjin_gs.setText(String.format(dqiyenianjin_gs.toString(), "%f"));

                //保存页面内容至数据库
                saveData(db,"GJJ",dGongjijin_gs_bl,dGongjijin_bl);
                saveData(db,"BC_GJJ",dBuchongGongjijin_gs_bl,dBuchongGongjijin_bl);
                saveData(db,"YAL",dYanglao_gs_bl,dYanglao_bl);
                saveData(db,"YIL",dyiliao_gs_bl,dyiliao_bl);
                saveData(db,"SHY",dshiye_gs_bl,dshiye_bl);
                saveData(db,"GS",dgongshang_gs_bl,dgongshang_bl);
                saveData(db,"SEY",dshiye_gs_bl,dshiye_bl);
                saveData(db,"NJ",dqiyenianjin_gs_bl,dqiyenianjin_bl);
                saveData(db,"HZ",dhuizong_gs_bl,dhuizong_bl);
                Toast.makeText(this,"数据库已更新",Toast.LENGTH_SHORT).show();
                //
                paste(beforR,bdBefor,dhuizong,bdYueshu.intValue());

            }
        }
    }


    //保存事件
    public void saveDataClick(View v){
        Toast.makeText(this,"点击计算即可将缴费比例信息保存至数据库了",Toast.LENGTH_SHORT).show();


    }


    //保存自定义比例
    public void saveData(SQLiteDatabase db,String tableName,BigDecimal bl_gs,BigDecimal bl_gr){
        String gs = bl_gs.toString();
        String gr = bl_gr.toString();
        helper.updateTable(db,tableName,gr,gs);
    }



    //BigDecimal计算 获取输入框内容
    public String getProportion2(int id){
        EditText et = (EditText)findViewById(id);
        String bl = String.valueOf(et.getText());
        if (bl.equals("")){
            return "0";
        }else{
            return bl;
        }
    }

    public EditText getView(int id){
        EditText et = (EditText)findViewById(id);
        return et;
    }


    //BigDecimal计算月薪纳税金额-月薪
    public BigDecimal taxCaclAfter(BigDecimal bd){
        BigDecimal sum = new BigDecimal("0.00");
        BigDecimal mianzhenge = new BigDecimal("5000");
        bd = bd.subtract(mianzhenge).subtract(bdZhuanxiangkouchu);
        double d = bd.doubleValue();
        if (d > 0){
            if (d <= 3000){
                sum = bd.multiply(new BigDecimal("0.03"));
            }else if (d > 3000 && d <= 12000){
                sum = bd.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("210"));
            }else if(d > 12000 && d <= 25000){
                sum = bd.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("1410"));
            }else if(d > 25000 && d <= 35000){
                sum = bd.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("2660"));
            }else if(d > 35000 && d <= 55000){
                sum = bd.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("4410"));
            }else if(d > 55000 && d <= 80000){
                sum = bd.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("7160"));
            }else if(d > 80000){
                sum = bd.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("15160"));
            }
        }else{
            return sum;
        }
        return sum;
    }
    //年终奖所得税
    public BigDecimal taxCaclAfterEnd(BigDecimal bd){
        BigDecimal sum = new BigDecimal("0.00");
        bd = bd.divide(YXJS);
        double d = bd.doubleValue();
        if (d > 0){
            if (d <= 3000){
                sum = bd.multiply(new BigDecimal("0.03"));
            }else if (d > 3000 && d <= 12000){
                sum = bd.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("210"));
            }else if(d > 12000 && d <= 25000){
                sum = bd.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("1410"));
            }else if(d > 25000 && d <= 35000){
                sum = bd.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("2660"));
            }else if(d > 35000 && d <= 55000){
                sum = bd.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("4410"));
            }else if(d > 55000 && d <= 80000){
                sum = bd.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("7160"));
            }else if(d > 80000){
                sum = bd.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("15160"));
            }
        }else{
            return sum;
        }
        return sum.multiply(YXJS);
    }



    //BigDecimal计算月薪纳税金额-按年
    public BigDecimal taxCaclAfterYear(BigDecimal bd ,BigDecimal dhuizong, int i){
        BigDecimal sum = new BigDecimal("0.00");
        //免征额
        BigDecimal mianzhenge = BigDecimal.valueOf(5000);
        //应纳税所得额=扣除五险一金后的收入*月数-免征额*当月月数-专项扣除*当月月数
        BigDecimal yue = BigDecimal.valueOf(i);
        BigDecimal full = BigDecimal.valueOf(12);
        Log.v("taxCaclAfterYear","i=" + i + "   计算前的bd金额=" + bd.toString());
        //方便计算年终奖，税前收入在传入时计算累计数值
        if (i <= 12){
            bd = bd.multiply(yue).subtract(dhuizong.multiply(yue)).subtract(mianzhenge.multiply(yue)).subtract(bdZhuanxiangkouchu.multiply(yue));
        }else{
            //超过12个月之后不再增加计算各类扣除数：社保公积金+专项扣除
            //目前年终奖貌似不计入全年收入计税，所以先注释掉
            bd = bd.multiply(yue).subtract(dhuizong.multiply(full)).subtract(mianzhenge.multiply(full)).subtract(bdZhuanxiangkouchu.multiply(full));
        }
        //bd = bd.subtract(mianzhenge.multiply(yue)).subtract(bdZhuanxiangkouchu.multiply(yue));
        Log.v("taxCaclAfterYear","i=" + i + "   计算后的bd金额=" + bd.toString());
        double d = bd.doubleValue();
        if (d > 0){
            if (d <= 36000){
                sum = bd.multiply(new BigDecimal("0.03"));
                //mLog.v("<36000的税额","月份"+i+"收入"+ d +"税额："+ sum);
            }else if (d > 36000 && d <= 144000){
                sum = bd.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("2520"));
            }else if(d > 144000 && d <= 300000){
                sum = bd.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("16920"));
            }else if(d > 300000 && d <= 420000){
                sum = bd.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("31920"));
            }else if(d > 420000 && d <= 660000){
                sum = bd.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("52920"));
            }else if(d > 660000 && d <= 960000){
                sum = bd.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("85920"));
            }else if(d > 960000){
                sum = bd.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("181920"));
            }
        }else{
            return sum;
        }
        return sum;
    }


    public HashMap taxCaclA(BigDecimal bd ,BigDecimal dhuizong, int i){
        HashMap<String,BigDecimal> m = new HashMap();
        BigDecimal sum = BigDecimal.valueOf(0);
        if (i < 0){
            Toast.makeText(this,"月份最少1个月",Toast.LENGTH_SHORT).show();
        }else {
            for (int j = 1; j <= i; j++) {
                //if (j <= 12 || j == i){
                String s = String.valueOf(j);
                BigDecimal b = BigDecimal.valueOf(0);
                if (j <= 12){
                    b = taxCaclAfterYear(bd, dhuizong,j);
                    Log.v("taxCaclA-循环1=","月份j:" + j + "   b=" + b.toString());
                    if (j > 1) {
                        b = taxCaclAfterYear(bd,dhuizong, j);
                        for (int k = j - 1; k > 0; k--) {
                            //b = b.subtract(taxCaclAfterYear(bd, k-1));
                            try{
                                b = b.subtract(m.get(String.valueOf(k)));
                            }catch (Exception e){
                                Log.v("Exception","月份超过12后计算个税时会初夏14月计算个税需要减掉13月个税的情况，此时跳过计算");
                            }
                        }
                        Log.v("taxCaclA-循环=","月份k:" + j + "   b=" + b.toString());
                    }
                    m.put(s,b);
                    sum = sum.add(b);
                    Log.v("map的内容-循环内",m.toString());
                }else if (j == i){
                     b = taxCaclAfterEnd(bd.multiply(BigDecimal.valueOf(i - 12)));
                     m.put(s,b);
                     sum = sum.add(b);
                }else{
                    Log.v("跳过计算","月数大于12也不等于" + i + "跳过计算");
                }
            }
        }
        m.put(String.valueOf(i+1),sum);
        Log.v("map的内容",m.toString());
        Log.v("taxCaclA","taxCaclA执行完成，i=" + i);
        return m;
    }


    public void paste (BigDecimal beforR,BigDecimal befor,BigDecimal dhuizong,int i){
        BigDecimal beforR1 = BigDecimal.valueOf(0);
        if (i > 12) {
            beforR1 = beforR.multiply(BigDecimal.valueOf(12)).add(befor.multiply(BigDecimal.valueOf(i - 12)));
        }else{
            beforR1 = beforR.multiply(BigDecimal.valueOf(i));
        }
        HashMap m  = taxCaclA(befor,dhuizong,i);
        tv_1yue_shui.setText(m.get("1").toString());
        tv_2yue_shui.setText(m.get("2").toString());
        tv_3yue_shui.setText(m.get("3").toString());
        tv_4yue_shui.setText(m.get("4").toString());
        tv_5yue_shui.setText(m.get("5").toString());
        tv_6yue_shui.setText(m.get("6").toString());
        tv_7yue_shui.setText(m.get("7").toString());
        tv_8yue_shui.setText(m.get("8").toString());
        tv_9yue_shui.setText(m.get("9").toString());
        tv_10yue_shui.setText(m.get("10").toString());
        tv_11yue_shui.setText(m.get("11").toString());
        tv_12yue_shui.setText(m.get("12").toString());
        if (i > 12){
            tv_nianzhong_shui.setText(m.get(String.valueOf(i)).toString());
        }else{
            tv_nianzhong_shui.setText("木有年终奖");
        }
        tv_huizong_nian_shui.setText(m.get(String.valueOf(i+1)).toString());

        tv_1yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("1").toString())).toString() ,"%f"));
        tv_2yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("2").toString())).toString() ,"%f"));
        tv_3yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("3").toString())).toString() ,"%f"));
        tv_4yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("4").toString())).toString() ,"%f"));
        tv_5yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("5").toString())).toString() ,"%f"));
        tv_6yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("6").toString())).toString() ,"%f"));
        tv_7yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("7").toString())).toString() ,"%f"));
        tv_8yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("8").toString())).toString() ,"%f"));
        tv_9yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("9").toString())).toString() ,"%f"));
        tv_10yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("10").toString())).toString() ,"%f"));
        tv_11yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("11").toString())).toString() ,"%f"));
        tv_12yue.setText(String.format(beforR.subtract(new BigDecimal(m.get("12").toString())).toString() ,"%f"));
        if (i > 12){
            Log.v("ming",m.get(String.valueOf(i)).toString());
            tv_nianzhong.setText(String.format(befor.multiply(BigDecimal.valueOf(i -12)).subtract(new BigDecimal(m.get(String.valueOf(i)).toString())).toString() ,"%f"));
        }else{
            tv_nianzhong.setText("木有年终奖");
        }
        tv_huizong_nian.setText(String.format(beforR1.subtract(new BigDecimal(m.get(String.valueOf(i+1)).toString())).toString() ,"%f"));
    }


}
