package com.example.administrator.nonyezhichuang.bean;

/**
 * Created by Administrator on 2017/8/22.
 */

public class TestBean {

    boolean isChecked;
    String name;
    int num;

    public TestBean(boolean isChecked, String name, int num) {
        this.isChecked = isChecked;
        this.name = name;
        this.num = num;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    @Override
    public String toString() {
        return "TestBean{" +
                "isChecked=" + isChecked +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
