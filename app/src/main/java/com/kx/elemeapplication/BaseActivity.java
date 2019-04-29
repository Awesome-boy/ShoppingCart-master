package com.kx.elemeapplication;

import android.os.Bundle;

import com.kx.elemeapplication.utils.ToastMgr;
import com.lidroid.xutils.ViewUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 *
 */
public abstract class BaseActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ToastMgr.init(this);
        ViewUtils.inject(this);
        initView();
        initData();
        initListener();

    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();


}
