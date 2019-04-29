package com.kx.elemeapplication.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.kx.elemeapplication.BaseActivity;
import com.kx.elemeapplication.R;
import com.kx.elemeapplication.common.Contants;
import com.kx.elemeapplication.wiget.EasyGoToolBar;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

import androidx.recyclerview.widget.RecyclerView;

public class AddressListActivity extends BaseActivity {
    @ViewInject(R.id.toolbar)
    private EasyGoToolBar mToolbar;

    @ViewInject(R.id.recycler_view)
    private RecyclerView mRecyclerView;

    @ViewInject(R.id.btn_addAddress)
    private Button mAddAddress;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_address_list;
    }

    @Override
    protected void initView() {
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
    @OnClick(R.id.btn_addAddress)
    public void addNewAddress(View view){
        toAddActivity();
    }

    private void toAddActivity() {
        Intent intent = new Intent(AddressListActivity.this, AddressAddActivity.class);
        startActivityForResult(intent, Contants.REQUEST_CODE);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
