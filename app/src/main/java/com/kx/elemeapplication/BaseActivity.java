package com.kx.elemeapplication;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kx.elemeapplication.utils.ToastMgr;


/**
 *
 */
public abstract class BaseActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ToastMgr.init(this);
        initView();
        initData();
        initListener();

    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();


}
