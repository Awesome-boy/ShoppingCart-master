package com.kx.elemeapplication.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kx.elemeapplication.BaseActivity;
import com.kx.elemeapplication.R;
import com.kx.elemeapplication.wiget.EasyGoToolBar;

import java.util.HashMap;

public class CreateOrderActivity extends BaseActivity implements View.OnClickListener {


    private TextView tv_total;
    private Double total;
    private EasyGoToolBar mToolbar;
    private RelativeLayout mLayoutAlipay;
    private RelativeLayout mLayoutWechat;
    private RelativeLayout mLayoutBd;
    private RadioButton mRbAlipay;
    private RadioButton mRbWechat;
    private RadioButton mRbBd;
    /**
     * 银联支付渠道
     */
    private static final String CHANNEL_UPACP = "upacp";
    /**
     * 微信支付渠道
     */
    private static final String CHANNEL_WECHAT = "wx";
    /**
     * 支付支付渠道
     */
    private static final String CHANNEL_ALIPAY = "alipay";
    /**
     * 百度支付渠道
     */
    private static final String CHANNEL_BFB = "bfb";
    /**
     * 京东支付渠道
     */
    private static final String CHANNEL_JDPAY_WAP = "jdpay_wap";
    private HashMap<String,RadioButton> channels = new HashMap<>(3);
    private String payChannel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_order;
    }

    @Override
    protected void initView() {
        tv_total = (TextView) findViewById(R.id.txt_total);
        mToolbar= (EasyGoToolBar) findViewById(R.id.toolbar);
        mLayoutAlipay= (RelativeLayout) findViewById(R.id.rl_alipay);
        mLayoutWechat= (RelativeLayout) findViewById(R.id.rl_wechat);
        mLayoutBd= (RelativeLayout) findViewById(R.id.rl_bd);
        mRbAlipay= (RadioButton) findViewById(R.id.rb_alipay);
        mRbWechat= (RadioButton) findViewById(R.id.rb_webchat);
        mRbBd= (RadioButton) findViewById(R.id.rb_bd);
        initToolbar();
    }


    private void initToolbar() {
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    protected void initListener() {
        channels.put(CHANNEL_ALIPAY,mRbAlipay);
        channels.put(CHANNEL_WECHAT,mRbWechat);
        channels.put(CHANNEL_BFB,mRbBd);
        mLayoutAlipay.setOnClickListener(this);
        mLayoutWechat.setOnClickListener(this);
        mLayoutBd.setOnClickListener(this);
        mRbAlipay.setChecked(true);
        mRbWechat.setChecked(false);
        mRbBd.setChecked(false);
    }

    @SuppressLint("StringFormatMatches")
    @Override
    protected void initData() {
        total = getIntent().getDoubleExtra("total",0.0);
        channels.put(CHANNEL_ALIPAY,mRbAlipay);
        channels.put(CHANNEL_WECHAT,mRbWechat);
        channels.put(CHANNEL_BFB,mRbBd);
        String data = getResources().getString(R.string.pay_money);
        tv_total.setText(String.format(data,total));
    }

    @Override
    public void onClick(View view) {
        selectPayChannel(view.getTag().toString());
    }

    private void selectPayChannel(String payChannel) {
        this.payChannel = payChannel;
        for(String key:channels.keySet()){
            RadioButton radioButton = channels.get(key);
            if(key.equals(payChannel)){
                Boolean isChecked = radioButton.isChecked();
                radioButton.setChecked(! isChecked);
            }else {
                radioButton.setChecked(false);
            }
        }
    }
}
