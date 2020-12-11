package com.umeng.mylianxi;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.umeng.mylianxi.ui.ExActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_je;
    private Button btn_a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        edit_je = (EditText) findViewById(R.id.edit_je);
        btn_a = (Button) findViewById(R.id.btn_a);

        btn_a.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_a:
                exvase();
                break;
        }
    }

    private void exvase() {
        String s = edit_je.getText().toString();
        Intent intent = new Intent(this, ExActivity.class);
        intent.putExtra("s",s);
        startActivityForResult(intent,200);

    }


}