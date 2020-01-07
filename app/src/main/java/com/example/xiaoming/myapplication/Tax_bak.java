package com.example.xiaoming.myapplication;

import android.icu.math.BigDecimal;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Tax_bak extends AppCompatActivity {
    private EditText tvBefore;
    private TextView tvAfter;
    private TextView tvGongjijin;
    private TextView tvBuchongGongjijin;
    private TextView tvYanglao;
    private TextView tvyiliao;
    private TextView tvshiye;
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
    private TextView tvgongshang_gs;
    private TextView tvhuizong_gs;
    private TextView tvhuizong_gs_bl;
    private TextView tvqiyenianjin_gs;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.tax);

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
        tvgongshang_gs = (TextView)findViewById(R.id.tv_gongshang_gs);
        tvhuizong_gs = (TextView)findViewById(R.id.tv__huizong_gs);
        tvhuizong_gs_bl = (TextView)findViewById(R.id.bl_huizong_gs);
        tvqiyenianjin_gs = (TextView)findViewById(R.id.tv_nianjin_gs);
        //年终奖
        tvNianzhongjiang = (TextView)findViewById(R.id.tv_nianzhongjiang);
        tvNianzhongjiang_shui = (TextView)findViewById(R.id.tv_nianzhongjiang_shui);
        //年薪
        tvNianxin = (TextView)findViewById(R.id.tv_nianxin);
        //专项扣除
        etZhuanxiangkouchu = (EditText) findViewById(R.id.et_zhuanxiangkouchu);
    }

    public void taxCacl(View v){
        //获取月薪
        String befor = String.valueOf(tvBefore.getText());
        if(befor.equals("")){
            befor = "0";
            Toast.makeText(this,"请输入正确的月薪",Toast.LENGTH_SHORT).show();
        }else{
            BigDecimal bdBefor = new BigDecimal(befor);
            //获取月缴费基数
            String jishu = String.valueOf(etjishu.getText());
            if(jishu.equals("")){
                jishu = befor;
                etjishu.setText(jishu);
            }
            //获取每年的薪酬月数
            String yueshu = String.valueOf(etyueshu.getText());
            if(yueshu.equals("")){
                yueshu = "12";
                etyueshu.setText(yueshu);
            }
            BigDecimal bdYueshu = new BigDecimal(yueshu);

            //获取专项扣除数
            String zhuanxiangkouchu = String.valueOf(etZhuanxiangkouchu.getText());
            if(zhuanxiangkouchu.equals("")){
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
            Log.e("ming","dshiye_bl" + dshiye_bl);
            BigDecimal dshiye = new BigDecimal(jishu).multiply(dshiye_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
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
            //企业年金
            BigDecimal dqiyenianjin_gs_bl = new BigDecimal(getProportion2(R.id.bl_nianjin_gs));
            BigDecimal dqiyenianjin_gs = new BigDecimal(jishu).multiply(dqiyenianjin_gs_bl).setScale(2, BigDecimal.ROUND_HALF_UP);
            //比例和
            BigDecimal dhuizong_gs_bl = dGongjijin_gs_bl.add(dBuchongGongjijin_gs_bl).add(dYanglao_gs_bl)
                    .add(dyiliao_gs_bl).add(dshiye_gs_bl).add(dgongshang_gs_bl).add(dqiyenianjin_gs_bl);
            //金额和
            BigDecimal dhuizong_gs = dGongjijin_gs.add(dBuchongGongjijin_gs).add(dYanglao_gs).add(dyiliao_gs)
                    .add(dshiye_gs).add(dgongshang_gs).add(dqiyenianjin_gs);

        /*//double类型计算，可能会出现精度失真
        double dGongjijin = Double.valueOf(jishu)*getProportion(R.id.bl_gongjijin);
        double dBuchongGongjijin = Double.valueOf(jishu)*getProportion(R.id.bl_buchong);
        double dYanglao = Double.valueOf(jishu)*getProportion(R.id.bl_yanglao);
        double dyiliao = Double.valueOf(jishu)*getProportion(R.id.bl_yiliao);
        double dshiye = Double.valueOf(jishu)*getProportion(R.id.bl_shiye);
        double beforR = Double.valueOf(befor) - dGongjijin -dBuchongGongjijin - dYanglao - dyiliao - dshiye;
        //double beforR = Double.valueOf(befor) - 2262;
        Toast.makeText(this,beforR+"",Toast.LENGTH_SHORT).show();
        String shui = taxCaclAfter(beforR);
        double dAfter = beforR - Double.valueOf(shui);*/

            BigDecimal beforR = new BigDecimal(befor).subtract(dGongjijin).subtract(dBuchongGongjijin)
                    .subtract(dYanglao).subtract(dyiliao).subtract(dshiye);
            //缴税金额
            Log.e("ming","befor=" + befor);
            Log.e("ming","beforR=" + beforR.toString());
            BigDecimal shui = taxCaclAfter(beforR).setScale(2, BigDecimal.ROUND_HALF_UP);
            //税后
            BigDecimal dAfter = beforR.subtract(shui).setScale(2, BigDecimal.ROUND_HALF_UP);

            //年终奖
            BigDecimal dEndShui = new BigDecimal("0");
            BigDecimal dEnd = new BigDecimal("0");
            if (bdYueshu.doubleValue() > 12){
                //年终奖-税
                dEndShui = taxCaclAfterEnd(bdYueshu.subtract(YXJS).multiply(bdBefor));
                //年终奖
                dEnd = bdYueshu.subtract(YXJS).multiply(bdBefor).subtract(dEndShui);
            }
            tvNianzhongjiang.setText(String.format(dEnd.toString(),"%f"));
            tvNianzhongjiang_shui.setText(String.format(dEndShui.toString(),"%f"));
            //年薪-个人
            BigDecimal dAll;
            //当年薪月数小于12时使用实际月数计算，大于12时使用标准月数+年终奖数计算
            if(bdYueshu.doubleValue() < 12){
                dAll = dAfter.multiply(bdYueshu).add(dEnd);
            }else{
                dAll = dAfter.multiply(YXJS).add(dEnd);
            }
            tvNianxin.setText(String.format(dAll.toString(),"%f"));

            //显示在界面

            tvAfter.setText(String.format(dAfter.toString(),"%f"));
            tvGongjijin.setText(String.format(dGongjijin.toString(),"%f"));
            tvBuchongGongjijin.setText(String.format(dBuchongGongjijin.toString(),"%f"));
            tvYanglao.setText(String.format(dYanglao.toString(),"%f"));
            tvyiliao.setText(String.format(dyiliao.toString(),"%f"));
            tvshiye.setText(String.format(dshiye.toString(),"%f"));
            tshui.setText(String.format(shui.toString(),"%f"));
            tvhuizong.setText(String.format(dhuizong.toString(),"%f"));
            tvhuizong_bl.setText(String.format(dhuizong_bl.toString(),"%f"));
            tvqiyenianjin.setText(String.format(dqiyenianjin.toString(),"%f"));

            //公司部分
            tvGongjijin_gs.setText(String.format(dGongjijin_gs.toString(),"%f"));
            tvBuchongGongjijin_gs.setText(String.format(dBuchongGongjijin_gs.toString(),"%f"));
            tvYanglao_gs.setText(String.format(dYanglao_gs.toString(),"%f"));
            tvyiliao_gs.setText(String.format(dyiliao_gs.toString(),"%f"));
            tvshiye_gs.setText(String.format(dshiye_gs.toString(),"%f"));
            tvgongshang_gs.setText(String.format(dgongshang_gs.toString(),"%f"));
            tvhuizong_gs.setText(String.format(dhuizong_gs.toString(),"%f"));
            tvhuizong_gs_bl.setText(String.format(dhuizong_gs_bl.toString(),"%f"));
            tvqiyenianjin_gs.setText(String.format(dqiyenianjin_gs.toString(),"%f"));
        }

    }


/*    //double计算
    public Double getProportion(int id){
        EditText et = (EditText)findViewById(id);
        String bl = String.valueOf(et.getText());
        if (bl.equals("")){
            return 0.00;
        }else{
            return Double.valueOf(bl);
        }
    }*/

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

/*    //double计算纳税金额
    public String taxCaclAfter(double d){
       double sum = 0.00;
       d = d - 5000;
       if (d > 0){
           if (d <= 3000){
               sum = d * 0.03;
           }else if (d > 3000 && d <= 12000){
               sum = d * 0.1 - 210;
           }else if(d > 12000 && d <= 25000){
               sum = d * 0.2 - 1410;
           }else if(d > 25000 && d <= 35000){
               sum = d * 0.25 - 2660;
           }else if(d > 35000 && d <= 55000){
               sum = d * 0.3 - 4410;
           }else if(d > 55000 && d <= 80000){
               sum = d * 0.35 - 7160;
           }else if(d > 80000){
               sum = d * 0.45 - 15160;
           }
       }else{
           return "0";
       }
       return sum + "";
    }*/

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
