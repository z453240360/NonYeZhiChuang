package com.example.administrator.nonyezhichuang.bean;

/**
 * Created by Administrator on 2017/8/17.
 * 手机发送验证码注册页面
 *
 */

public class RegistBean {

    /**
     * data : {"token":"c184be7cb57f12cea55bcff1afccad6c"}
     * msg : 短信发送成功
     * code : 200
     */

    private DataBean data;
    private String msg;
    private int code;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataBean {
        /**
         * token : c184be7cb57f12cea55bcff1afccad6c
         */

        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
