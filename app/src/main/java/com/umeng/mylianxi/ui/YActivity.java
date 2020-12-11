package com.umeng.mylianxi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.umeng.mylianxi.R;
import com.umeng.mylianxi.base.BaseActivity;
import com.umeng.mylianxi.bean.ExBean;
import com.umeng.mylianxi.interfaces.exchange.Excase;
import com.umeng.mylianxi.persent.Expersent;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YActivity extends BaseActivity<Expersent> implements Excase.View {

    @BindView(R.id.title)
    TextView title;

    @Override
    protected int getLayout() {
        return R.layout.activity_yy;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        int i = intent.getIntExtra("i", 0);
        Log.i("TTT", "initView: " + i);
        title.setText(i);
    }

    @Override
    protected Expersent createPersenter() {
        return new Expersent(this);
    }

    @Override
    protected void initData() {
        persenter.getexp();
    }

    @Override
    public void getexbean(ExBean exBean) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
