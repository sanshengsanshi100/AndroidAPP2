package com.example.xiaoming.myapplication.Bean;

import android.app.Activity;
import android.widget.EditText;

import com.example.xiaoming.myapplication.R;
import com.example.xiaoming.myapplication.Util.TaxUtil;

public class ViewAll extends Activity {
    //公司比例
    private String dGongjijin_gs_bl;
    private String dBuchongGongjijin_gs_bl;
    private String dYanglao_gs_bl;
    private String dyiliao_gs_bl;
    private String dshiye_gs_bl;
    private String dgongshang_gs_bl;
    private String dshengyu_gs_bl;
    private String dqiyenianjin_gs_bl;
    private String dhuizong_gs_bl;

    //个人比例
    private String dGongjijin_bl;
    private String dBuchongGongjijin_bl;
    private String dYanglao_bl;
    private String dyiliao_bl;
    private String dshiye_bl;
    private String dgongshang_bl;
    private String dshengyu_bl;
    private String dqiyenianjin_bl;
    private String dhuizong_bl;



    public void caclBl(){
        dGongjijin_gs_bl = getProportion2(R.id.bl_gongjijin_gs);
        dBuchongGongjijin_gs_bl = getProportion2(R.id.bl_buchong_gs);
        dYanglao_gs_bl = getProportion2(R.id.bl_yanglao_gs);
        dyiliao_gs_bl = getProportion2(R.id.bl_yiliao_gs);
        dshiye_gs_bl = getProportion2(R.id.bl_shiye_gs);
        dgongshang_gs_bl = getProportion2(R.id.bl_gongshang_gs);
        dshengyu_gs_bl = getProportion2(R.id.bl_shengyu_gs);
        dqiyenianjin_gs_bl = getProportion2(R.id.bl_nianjin_gs);
        dhuizong_gs_bl = getProportion2(R.id.bl_huizong_gs);

        dGongjijin_bl = getProportion2(R.id.bl_gongjijin);
        dBuchongGongjijin_bl = getProportion2(R.id.bl_buchong);
        dYanglao_bl = getProportion2(R.id.bl_yanglao);
        dyiliao_bl = getProportion2(R.id.bl_yiliao);
        dshiye_bl = getProportion2(R.id.bl_shiye);
        dgongshang_bl = getProportion2(R.id.bl_gongshang);
        dshengyu_bl = getProportion2(R.id.bl_shengyu);
        dqiyenianjin_bl = getProportion2(R.id.bl_nianjin);
        dhuizong_bl = getProportion2(R.id.bl_huizong);

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


    public String getdGongjijin_gs_bl() {
        return dGongjijin_gs_bl;
    }

    public String getdBuchongGongjijin_gs_bl() {
        return dBuchongGongjijin_gs_bl;
    }

    public String getdYanglao_gs_bl() {
        return dYanglao_gs_bl;
    }

    public String getDyiliao_gs_bl() {
        return dyiliao_gs_bl;
    }

    public String getDshiye_gs_bl() {
        return dshiye_gs_bl;
    }

    public String getDgongshang_gs_bl() {
        return dgongshang_gs_bl;
    }

    public String getDshengyu_gs_bl() {
        return dshengyu_gs_bl;
    }

    public String getDqiyenianjin_gs_bl() {
        return dqiyenianjin_gs_bl;
    }

    public String getDhuizong_gs_bl() {
        return dhuizong_gs_bl;
    }

    public String getdGongjijin_bl() {
        return dGongjijin_bl;
    }

    public String getdBuchongGongjijin_bl() {
        return dBuchongGongjijin_bl;
    }

    public String getdYanglao_bl() {
        return dYanglao_bl;
    }

    public String getDyiliao_bl() {
        return dyiliao_bl;
    }

    public String getDshiye_bl() {
        return dshiye_bl;
    }

    public String getDgongshang_bl() {
        return dgongshang_bl;
    }

    public String getDshengyu_bl() {
        return dshengyu_bl;
    }

    public String getDqiyenianjin_bl() {
        return dqiyenianjin_bl;
    }

    public String getDhuizong_bl() {
        return dhuizong_bl;
    }
}
