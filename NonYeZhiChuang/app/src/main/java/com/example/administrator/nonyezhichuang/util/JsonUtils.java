package com.example.administrator.nonyezhichuang.util;

import com.google.gson.Gson;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2017/8/21.
 */

public class JsonUtils {

    public static Object getBean(String s,Class<? extends Object> tClass){
       Gson gson=new Gson();

        Object o = gson.fromJson(s, tClass);

        return o;
    }

}
