package com.umeng.mylianxi.persent;

import com.umeng.mylianxi.base.BasePersenter;
import com.umeng.mylianxi.bean.ExBean;
import com.umeng.mylianxi.interfaces.Callback;
import com.umeng.mylianxi.interfaces.exchange.Excase;
import com.umeng.mylianxi.modle.ExModle;

public class Expersent extends BasePersenter<Excase.View> implements Excase.Persenter {

    Excase.View  view;
    Excase.Modle modle;

    public Expersent(Excase.View view){
        this.view=view;
        this.modle=new ExModle();
    }

    @Override
    public void getexp() {
        this.modle.getexd(new Callback() {
            @Override
            public void fail(String msg) {
                if (view!=null){
                    view.tips(msg);
                }
            }

            @Override
            public void success(Object o) {
                if (view!=null){
                    view.getexbean((ExBean) o);
                }
            }
        });
    }
}
