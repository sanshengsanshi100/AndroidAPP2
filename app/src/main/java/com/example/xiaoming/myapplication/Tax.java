package com.example.xiaoming.myapplication;

import android.database.sqlite.SQLiteDatabase;
import android.icu.math.BigDecimal;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import com.example.xiaoming.myapplication.Util.mLog;
import com.example.xiaoming.myapplication.data_base.DBOpenHelper;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

public class Tax extends AppCompatActivity {

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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tax);
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
            mLog.e("ming", "dshiye_bl" + dshiye_bl);
            BigDecimal dshiye = new BigDecimal(jishu).multiply(dshiye_bl).setScale(2, BigDecimal.ROUND_HALF_UP);

            //工伤
            BigDecimal dgongshang_bl = new BigDecimal(getProportion2(R.id.bl_gongshang));
            BigDecimal dgongshang = new BigDecimal(jishu).multiply(dgongshang_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //生育
            BigDecimal dshengyu_bl = new BigDecimal(getProportion2(R.id.bl_shengyu));
            BigDecimal dshengyu = new BigDecimal(jishu).multiply(dshengyu_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            mLog.e("ming", "生育险-公司：" + dshengyu.doubleValue());

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
            mLog.e("ming", "生育险-公司：" + dshengyu_gs.doubleValue());
            //企业年金
            BigDecimal dqiyenianjin_gs_bl = new BigDecimal(getProportion2(R.id.bl_nianjin_gs));
            BigDecimal dqiyenianjin_gs = new BigDecimal(jishu).multiply(dqiyenianjin_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //比例和
            BigDecimal dhuizong_gs_bl = dGongjijin_gs_bl.add(dBuchongGongjijin_gs_bl).add(dYanglao_gs_bl)
                    .add(dyiliao_gs_bl).add(dshiye_gs_bl).add(dgongshang_gs_bl).add(dqiyenianjin_gs_bl).add(dshengyu_gs_bl);
            //金额和
            BigDecimal dhuizong_gs = dGongjijin_gs.add(dBuchongGongjijin_gs).add(dYanglao_gs).add(dyiliao_gs)
                    .add(dshiye_gs).add(dgongshang_gs).add(dqiyenianjin_gs).add(dshengyu_gs);

            BigDecimal beforR = new BigDecimal(befor).subtract(dGongjijin).subtract(dBuchongGongjijin)
                    .subtract(dYanglao).subtract(dyiliao).subtract(dshiye);
            //缴税金额
            mLog.e("ming", "befor=" + befor);
            mLog.e("ming", "beforR=" + beforR.toString());
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

    public BigDecimal taxCaclAfterEnd(BigDecimal bd){
        BigDecimal sum = new BigDecimal("0.00");
        bd = bd.divide(YXJS);
        double d = bd.doubleValue();
        if (d > 0){
            if (d <= 1500){
                sum = bd.multiply(new BigDecimal("0.03"));
            }else if (d > 1500 && d <= 4500){
                sum = bd.multiply(new BigDecimal("0.1")).subtract(new BigDecimal("105"));
            }else if(d > 4500 && d <= 9000){
                sum = bd.multiply(new BigDecimal("0.2")).subtract(new BigDecimal("555"));
            }else if(d > 9000 && d <= 35000){
                sum = bd.multiply(new BigDecimal("0.25")).subtract(new BigDecimal("1005"));
            }else if(d > 35000 && d <= 55000){
                sum = bd.multiply(new BigDecimal("0.3")).subtract(new BigDecimal("2755"));
            }else if(d > 55000 && d <= 80000){
                sum = bd.multiply(new BigDecimal("0.35")).subtract(new BigDecimal("5505"));
            }else if(d > 80000){
                sum = bd.multiply(new BigDecimal("0.45")).subtract(new BigDecimal("13505"));
            }
        }else{
            return sum;
        }
        return sum.multiply(YXJS);
    }



}
