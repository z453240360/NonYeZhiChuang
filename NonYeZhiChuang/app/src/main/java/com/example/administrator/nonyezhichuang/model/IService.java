package com.example.administrator.nonyezhichuang.model;


import com.example.administrator.nonyezhichuang.constant.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/8/3.
 * 地址请求接口类
 */

public interface IService {

    //登陆
    @FormUrlEncoded
    @POST(Constant.Login)
    Call<ResponseBody> login(@Field("mobile") String mobile, @Field("password")String password);

    //手机注册
    @FormUrlEncoded
    @POST(Constant.Register)
    Call<ResponseBody> regiest(@Field("mobile") String mobile);


    //首页Banner
    @GET(Constant.fitstBanner)
    Call<ResponseBody> getBanner();



    //首页Banner
    @GET(Constant.car_buy)
    Call<ResponseBody> getCur();

    //首页--促销商品
    @GET(Constant.promo)
    Call<ResponseBody> getPromo();

    //---------------------------------------------------------------------------
    //GET请求    咨询+公告 +常见问题
    //---------------------------------------------------------------------------


    //咨询--公告列表
    @GET(Constant.counselList)
    Call<ResponseBody> counselList(@Query("page")String page,
                                   @Query("classId")String classId);




}
