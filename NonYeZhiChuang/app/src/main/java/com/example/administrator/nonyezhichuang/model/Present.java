package com.example.administrator.nonyezhichuang.model;


/**
 * Created by Administrator on 2017/8/3.
 * 网络请求逻辑层
 */

public class Present {

    private DateModel dateModel;
    private IMainView iMainView;

    public Present(IMainView mIMainView) {
        dateModel = new DateModel();
        this.iMainView = mIMainView;
    }


    public void getLogin(String mobile,String password){
        iMainView.showLoading();
        dateModel.getLogin(new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getCode(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }

            @Override
            public void netState(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        }, mobile, password);
    }



    //手机注册
    public void getRegist(String mobile){
        iMainView.showLoading();
        dateModel.getRegister( mobile,new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getCode(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }

            @Override
            public void netState(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });
    }


    //获取首页轮播
    public void getBanner(){
        iMainView.showLoading();
        dateModel.getBanner(new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getCode(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }

            @Override
            public void netState(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });
    }

    //获取购物车列表
    public void getCar(){
        iMainView.showLoading();
        dateModel.getCur_bur(new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getCode(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }

            @Override
            public void netState(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });
    }

    //首页促销商品
    public void getPromo(){
        iMainView.showLoading();
        dateModel.getPromo(new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getUpDate(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }

            @Override
            public void netState(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });
    }


    //获取公告
    public void counselMinute(String page,String classId){
        iMainView.showLoading();
        dateModel.getCounselMinute(page,classId,new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getLogin(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }

            @Override
            public void netState(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });
    }

    //商品--商品详情
    public void product_message(String id){
        iMainView.showLoading();
        dateModel.product_message(id,new ICallBack() {
            @Override
            public void succesed(String s) {
                iMainView.getUpDate(s);
                iMainView.cancelLoading();
            }

            @Override
            public void failed(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }

            @Override
            public void netState(String s) {
                iMainView.showFaliure(s);
                iMainView.cancelLoading();
            }
        });
    }

}
