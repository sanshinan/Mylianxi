package com.umeng.mylianxi.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.umeng.mylianxi.R;
import com.umeng.mylianxi.base.BaseAdapter;
import com.umeng.mylianxi.bean.ExBean;
import com.umeng.mylianxi.interfaces.exchange.Excase;

import java.util.List;

public class Adapter extends BaseAdapter {

    public Adapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected int getLayout() {
        return R.layout.adater_item;
    }

    @Override
    protected void Data(Object data, VH vh) {
        ExBean.DataBean.ListBean datas= (ExBean.DataBean.ListBean) data;

        TextView text = (TextView) vh.getViewByid(R.id.text_qq);
        text.setText(datas.getPrice()+"");
        RadioGroup re = (RadioGroup) vh.getViewByid(R.id.re);
        re.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(iItemViewClick != null){
                    iItemViewClick.itemViewClick(checkedId,data);
                }
            }
        });
    }
}
