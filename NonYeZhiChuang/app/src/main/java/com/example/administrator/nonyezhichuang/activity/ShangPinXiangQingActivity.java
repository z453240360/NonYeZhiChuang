package com.example.administrator.nonyezhichuang.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.administrator.nonyezhichuang.R;
import com.example.administrator.nonyezhichuang.bean.ShangpinXiangQingBean;
import com.example.administrator.nonyezhichuang.model.Present;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/8/25.
 */

public class ShangPinXiangQingActivity extends BaseActivity {
    @BindView(R.id.mRb_xiangqing_shangpin)
    RadioButton mRbXiangqingShangpin;
    @BindView(R.id.mRb_xiangqing)
    RadioButton mRbXiangqing;
    @BindView(R.id.mRb_pingjia)
    RadioButton mRbPingjia;
    @BindView(R.id.mRg_shangpinxiangqing)
    RadioGroup mRgShangpinxiangqing;
    @BindView(R.id.toolbars_shangpinxiangqing_activity)
    Toolbar toolbarsShangpinxiangqingActivity;
    @BindView(R.id.mBtn_kefu)
    Button mBtnKefu;
    @BindView(R.id.mBtn_dianbu)
    Button mBtnDianbu;
    @BindView(R.id.mBtn_shoucang)
    Button mBtnShoucang;
    @BindView(R.id.mBtn_heji)
    Button mBtnHeji;
    @BindView(R.id.mImg_xiangqing)
    ImageView mImgXiangqing;
    @BindView(R.id.mTxt_title_xiangqing)
    TextView mTxtTitleXiangqing;
    @BindView(R.id.mTxt_miaoshu_xiangqing)
    TextView mTxtMiaoshuXiangqing;
    @BindView(R.id.mTxt_xinxi_xiangqing)
    TextView mTxtXinxiXiangqing;
    @BindView(R.id.mTxt_xinxi_guige)
    TextView mTxtXinxiGuige;
    @BindView(R.id.mTxt_jiaqian_xiangqing)
    TextView mTxtJiaqianXiangqing;
    @BindView(R.id.mTxt_danwei_xiangqing)
    TextView mTxtDanweiXiangqing;
    @BindView(R.id.mBtn_jian_xiangqing)
    Button mBtnJianXiangqing;
    @BindView(R.id.mTxt_shuliang_xiangqing)
    TextView mTxtShuliangXiangqing;
    @BindView(R.id.mBtn_jia_xiangqing)
    Button mBtnJiaXiangqing;
    @BindView(R.id.mTxt_pingjia_xiangqing)
    TextView mTxtPingjiaXiangqing;
    @BindView(R.id.mTxt_number_xiangqing)
    TextView mTxtNumberXiangqing;
    @BindView(R.id.rc_pingjia_xiangqing)
    XRecyclerView rcPingjiaXiangqing;
    @BindView(R.id.sc_xiangqing)
    ScrollView scXiangqing;

    private String TAG="dd";
    private Present present;
    private ShangpinXiangQingBean shangpinXiangQingBean;
    private String store_phone;
    private String goods_name;
    private String goods_subtitle;
    private String goods_cover;
    private int store_id;
    private String price;
    private String ratio;

    @Override
    protected void initTitle() {

    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initView() {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shangpinxiangqing);
        ButterKnife.bind(this);
        present = new Present(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("goods_id");
        present.product_message(stringExtra);
    }

    @Override
    public void getCode(String s) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void cancelLoading() {

    }

    @Override
    public void showFaliure(String s) {

    }

    @Override
    public void getLogin(String s) {

    }

    /**
     * 商品详情页面
     * @param s
     */
    @Override
    public void getUpDate(String s) {
        Log.i(TAG, "getUpDate: "+s);
        Gson g = new Gson();
        shangpinXiangQingBean = g.fromJson(s, ShangpinXiangQingBean.class);

        int code = shangpinXiangQingBean.getCode();
        String msg = shangpinXiangQingBean.getMsg();
        ShangpinXiangQingBean.DataBean data = shangpinXiangQingBean.getData();

        goods_cover = data.getGoods_cover();//商品图片封面
        goods_subtitle = data.getGoods_subtitle();//商品详情
        goods_name = data.getGoods_name();//商品名称
        store_phone = data.getStore().getStore_phone();//客服电话
        store_id = data.getStore_id();//店铺ID

        List<ShangpinXiangQingBean.DataBean.SpecBean> spec1 = data.getSpec();

        for (int i = 0; i < spec1.size(); i++) {
            ShangpinXiangQingBean.DataBean.SpecBean specBean = spec1.get(i);
            price = specBean.getPrice();
            ratio = specBean.getRatio();
        }

        //设置封面
        Picasso.with(this)
                .load(goods_cover)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(mImgXiangqing);

        mTxtXinxiXiangqing.setText(goods_subtitle);
        mTxtJiaqianXiangqing.setText("￥"+price);
        mTxtDanweiXiangqing.setText(ratio);
        mTxtNumberXiangqing.setText("("+data.getEvaluation_count()+")");




        List<ShangpinXiangQingBean.DataBean.SpecBean> spec = data.getSpec();

        /**
         * 评论
         */
        String avatar = data.getComment().getAvatar();//用户头像

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * 按钮的点击事件
     * @param view
     */
    @OnClick({R.id.mBtn_kefu, R.id.mBtn_dianbu, R.id.mBtn_shoucang, R.id.mBtn_heji, R.id.mBtn_jian_xiangqing, R.id.mBtn_jia_xiangqing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //客服电话
            case R.id.mBtn_kefu:
                if (store_phone!= null) {
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + store_phone));
                    startActivity(intent);
                }
                break;
            //店铺详情
            case R.id.mBtn_dianbu:
                break;
            //收藏
            case R.id.mBtn_shoucang:
                break;
            //合计
            case R.id.mBtn_heji:
                break;
            //数量减少
            case R.id.mBtn_jian_xiangqing:
                break;
            //数量加一
            case R.id.mBtn_jia_xiangqing:
                break;
        }
    }
}
