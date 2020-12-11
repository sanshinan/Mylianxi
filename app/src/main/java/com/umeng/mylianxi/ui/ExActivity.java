package com.umeng.mylianxi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.mylianxi.R;
import com.umeng.mylianxi.adapter.Adapter;
import com.umeng.mylianxi.adapter.BaseAdapter;
import com.umeng.mylianxi.base.BaseActivity;
import com.umeng.mylianxi.bean.EventInt;
import com.umeng.mylianxi.bean.ExBean;
import com.umeng.mylianxi.interfaces.exchange.Excase;
import com.umeng.mylianxi.persent.Expersent;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExActivity extends BaseActivity<Expersent> implements Excase.View {
    @BindView(R.id.edit_sj)
    EditText editSj;
    @BindView(R.id.edit_sja)
    EditText editSja;
    @BindView(R.id.text_ye)
    TextView textYe;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.btn_b)
    Button btnB;

    private List<ExBean.DataBean.ListBean> beans;
    private BaseAdapter baseAdapter;
    private Adapter adapter;
    

    private int stockCount;
    private int price;
    private int i;//剩余金额

    @Override
    protected int getLayout() {
        return R.layout.activity_ex;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if (intent!=null){
            String s = intent.getStringExtra("s");
            i = Integer.parseInt(s);
            textYe.setText(s);
        }
        beans=new ArrayList<>();
//        baseAdapter = new BaseAdapter(this, beans);
        adapter = new Adapter(this, beans);
        recy.setLayoutManager(new LinearLayoutManager(this));
        recy.setAdapter(adapter);

        adapter.addItemViewClick(new com.umeng.mylianxi.base.BaseAdapter.IItemViewClick<ExBean.DataBean.ListBean>() {
            @Override
            public void itemViewClick(int viewid, ExBean.DataBean.ListBean data) {

                price = data.getPrice();//价格
                stockCount = data.getStockCount();//库存

            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editSj.getText().toString();
                String s1 = editSja.getText().toString();
                if (s.equals(s1)&&i>price&&stockCount>0){
                    int yue=i-price;
                    Intent intent1 = new Intent(ExActivity.this, TTActivity.class);
                    intent1.putExtra("i",yue);
                    startActivityForResult(intent1,300);
                    Toast.makeText(ExActivity.this, "成功", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(ExActivity.this, "失败", Toast.LENGTH_SHORT).show();
                }
            }
        });


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
        Log.i("TAG", "getexbean: " + exBean.toString());
        beans.addAll(exBean.getData().getList());
       adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101 &&  data != null){
            int ii = data.getIntExtra("ii",0);
            Toast.makeText(this, "回传："+ii, Toast.LENGTH_SHORT).show();
            textYe.setText(String.valueOf(ii));
        }
    }

}
