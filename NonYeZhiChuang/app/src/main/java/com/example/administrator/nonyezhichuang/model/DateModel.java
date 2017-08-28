package com.example.administrator.nonyezhichuang.model;


import com.example.administrator.nonyezhichuang.constant.Constant;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/8/3.
 * 网络请求信息管理类
 */

public class DateModel {

    //返回IService对象
    public IService getCall(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASRURL)
                .build();
        IService iService = retrofit.create(IService.class);
        return iService;
    }

    //登陆接口
    public void getLogin(final ICallBack callBack,String mobile,String password) {
        IService call = getCall();
        Call<ResponseBody> login = call.login(mobile, password);
        login.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                int code = response.code();
                if (code != 200) {
                    callBack.netState("网络异常");
                    return;
                }
                String s = null;
                try {
                    s= response.body().string();
                    if (null == s||("").equals(s)) {
                        callBack.netState("服务器异常");
                        return;
                    } else {
                        callBack.succesed(s);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("请求网络失败");
            }
        });

    }

    //注册
    public void getRegister(String phone, final ICallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASRURL)
                .build();
        IService service = retrofit.create(IService.class);

        Call<ResponseBody> regiest = service.regiest(phone);
        regiest.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("网络请求失败"+t.toString());
            }
        });


    }

    //注册2
    public void getBanner(final ICallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASRURL)
                .build();
        IService service = retrofit.create(IService.class);

        Call<ResponseBody> regiest = service.getBanner();
        regiest.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("网络请求失败"+t.toString());
            }
        });


    }


    //购物车
    public void getCur_bur(final ICallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASRURL)
                .build();
        IService service = retrofit.create(IService.class);

        Call<ResponseBody> regiest = service.getCur();
        regiest.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("网络请求失败"+t.toString());
            }
        });

    }

    //首页促销商品
    public void getPromo(final ICallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASRURL)
                .build();
        IService service = retrofit.create(IService.class);

        Call<ResponseBody> regiest = service.getPromo();
        regiest.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("网络请求失败"+t.toString());
            }
        });

    }

    //---------------------------------------------------------------------------
    //GET请求    咨询+公告 +常见问题
    //---------------------------------------------------------------------------

    //咨询--公告列表
    public void getCounselMinute(String page,String classId,final ICallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASRURL)
                .build();
        IService service = retrofit.create(IService.class);

        Call<ResponseBody> regiest = service.counselList(page,classId);
        regiest.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("网络请求失败"+t.toString());
            }
        });

    }

    //商品--商品详情
    public void product_message(String classId,final ICallBack callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASRURL)
                .build();
        IService service = retrofit.create(IService.class);

        Call<ResponseBody> regiest = service.product_message(classId);
        regiest.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    callBack.succesed(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed("网络请求失败"+t.toString());
            }
        });

    }

    // 商品--商品分类
    public void product_kind(String pid,final ICallBack callBack) {
        IService iService = getCall();
        //IService对应的方法
        Call<ResponseBody> call = iService.product_kind(pid);
        //同步请求网络
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() != 200) {
                    callBack.netState("服务器异常");
                    return;
                }

                String responseBody = null;

                try {
                    responseBody = response.body().string();
                    if (null == responseBody) {
                        callBack.netState("数据为空");
                        return;
                    }
                    callBack.succesed(responseBody);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed(t.toString());
            }
        });

    }

    // 商品--商品列表
    public void product_list(String classOneId,
                             String classId,
                             String state,
                             String orderBy,
                             String lng,
                             String lat,
                             String storeId,final ICallBack callBack) {
        IService iService = getCall();
        //IService对应的方法
        Call<ResponseBody> call = iService.product_list(classOneId,classId,state,orderBy,lng,lat,storeId);
        //同步请求网络
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() != 200) {
                    callBack.netState("服务器异常");
                    return;
                }

                String responseBody = null;

                try {
                    responseBody = response.body().string();
                    if (null == responseBody) {
                        callBack.netState("数据为空");
                        return;
                    }
                    callBack.succesed(responseBody);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callBack.failed(t.toString());
            }
        });

    }

}

