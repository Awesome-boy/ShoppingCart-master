package com.kx.elemeapplication.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kx.elemeapplication.BaseActivity;
import com.kx.elemeapplication.R;
import com.kx.elemeapplication.wiget.EasyGoToolBar;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.HashMap;

public class CreateOrderActivity extends BaseActivity implements View.OnClickListener {


    private TextView tv_total;
    private Double total;
    private EasyGoToolBar mToolbar;
    private RelativeLayout mLayoutAddr;
    private RelativeLayout mLayoutAlipay;
    private RelativeLayout mLayoutWechat;
    private RelativeLayout mLayoutBd;
    private RadioButton mRbAlipay;
    private RadioButton mRbWechat;
    private RadioButton mRbBd;
    @ViewInject(R.id.rl_visa)
    RelativeLayout  mLayoutVisa;
    @ViewInject(R.id.rl_union)
    RelativeLayout  mLayoutUnion;
    @ViewInject(R.id.rl_paypal)
    RelativeLayout mLayoutPayPal;
    @ViewInject(R.id.rb_visa)
    RadioButton mRbVisa;
    @ViewInject(R.id.rb_union)
    RadioButton mRbUnion;
    @ViewInject(R.id.rb_paypal)
    RadioButton mRbPayPal;
    /**
     * 银联支付渠道
     */
    private static final String CHANNEL_UNION = "union";

    /**
     * paypal支付渠道
     */
    private static final String CHANNEL_PAYPAL_WAP = "paypal";

    /**
     * visa支付渠道
     */
    private static final String CHANNEL_VISA_WAP = "visa";
    /**
     *
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

    private HashMap<String,RadioButton> channels = new HashMap<>(6);
    private String payChannel;
    @ViewInject(R.id.txt_name)
    TextView tv_name;
    @ViewInject(R.id.txt_address)
    TextView tv_address;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_create_order;
    }

    @Override
    protected void initView() {
        tv_total = (TextView) findViewById(R.id.txt_total);
        mToolbar= (EasyGoToolBar) findViewById(R.id.toolbar);
        mLayoutAddr= (RelativeLayout) findViewById(R.id.rl_addr);

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
        channels.put(CHANNEL_UNION,mRbUnion);
        channels.put(CHANNEL_PAYPAL_WAP,mRbPayPal);
        channels.put(CHANNEL_VISA_WAP,mRbVisa);
        mLayoutAlipay.setOnClickListener(this);
        mLayoutWechat.setOnClickListener(this);
        mLayoutBd.setOnClickListener(this);
        mLayoutUnion.setOnClickListener(this);
        mLayoutPayPal.setOnClickListener(this);
        mLayoutVisa.setOnClickListener(this);
        mRbAlipay.setChecked(true);
        mRbWechat.setChecked(false);
        mRbBd.setChecked(false);
        mRbVisa.setChecked(false);
        mRbUnion.setChecked(false);
        mRbPayPal.setChecked(false);
        mLayoutAddr.setOnClickListener(this);
    }

    @SuppressLint("StringFormatMatches")
    @Override
    protected void initData() {
        total = getIntent().getDoubleExtra("total",0.0);
        tv_name.setText("json");
        tv_address.setText("WuHan.China");
        channels.put(CHANNEL_ALIPAY,mRbAlipay);
        channels.put(CHANNEL_WECHAT,mRbWechat);
        channels.put(CHANNEL_BFB,mRbBd);
        channels.put(CHANNEL_UNION,mRbUnion);
        channels.put(CHANNEL_PAYPAL_WAP,mRbPayPal);
        channels.put(CHANNEL_VISA_WAP,mRbVisa);
        String data = getResources().getString(R.string.pay_money);
        tv_total.setText(String.format(data,total));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_alipay:
            case R.id.rl_bd:
            case R.id.rl_wechat:
            case R.id.rl_paypal:
            case R.id.rl_union:
            case R.id.rl_visa:
                selectPayChannel(view.getTag().toString());
                break;
            case R.id.rl_addr:
//                Intent intent = new Intent(this,AddressListActivity.class);
//                startActivity(intent);
                break;
        }

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
