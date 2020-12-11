package com.umeng.mylianxi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.umeng.mylianxi.R;
import com.umeng.mylianxi.bean.EventInt;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TTActivity extends AppCompatActivity {

    @BindView(R.id.title_a)
    TextView titleA;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_t);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        i = intent.getIntExtra("i", 0);
        Log.i("TTT", "initView: " + i);
        titleA.setText(i +"");
        intent.putExtra("ii",i);
        setResult(101,intent);

    }


}