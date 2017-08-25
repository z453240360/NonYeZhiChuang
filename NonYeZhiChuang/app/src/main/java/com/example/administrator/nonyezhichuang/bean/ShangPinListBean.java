package com.example.administrator.nonyezhichuang.bean;

/**
 * Created by Administrator on 2017/8/23.
 */

public class ShangPinListBean {
    String dianshi;
    String yingshi;
    String dianyin;
    String yule;
    String goudan;
    String goudan2;

    public String getGoudan2() {
        return goudan2;
    }

    public void setGoudan2(String goudan2) {
        this.goudan2 = goudan2;
    }

    public ShangPinListBean(String dianshi, String yingshi, String dianyin, String yule, String goudan,String goudan2) {
        this.dianshi = dianshi;
        this.yingshi = yingshi;
        this.dianyin = dianyin;
        this.yule = yule;
        this.goudan = goudan;
        this.goudan2 = goudan2;
    }

    public String getDianshi() {
        return dianshi;
    }

    public void setDianshi(String dianshi) {
        this.dianshi = dianshi;
    }

    public String getYingshi() {
        return yingshi;
    }

    public void setYingshi(String yingshi) {
        this.yingshi = yingshi;
    }

    public String getDianyin() {
        return dianyin;
    }

    public void setDianyin(String dianyin) {
        this.dianyin = dianyin;
    }

    public String getYule() {
        return yule;
    }

    public void setYule(String yule) {
        this.yule = yule;
    }

    public String getGoudan() {
        return goudan;
    }

    public void setGoudan(String goudan) {
        this.goudan = goudan;
    }
}
