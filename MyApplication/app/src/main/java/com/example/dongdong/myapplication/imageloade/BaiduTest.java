package com.example.dongdong.myapplication.imageloade;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by dongdong on 2017/9/3.
 */

public interface BaiduTest {

    Call<ResponseBody> getToken();
}
