package com.umeng.mylianxi.modle;

import com.umeng.mylianxi.base.BaseModel;
import com.umeng.mylianxi.bean.ExBean;
import com.umeng.mylianxi.interfaces.Callback;
import com.umeng.mylianxi.interfaces.exchange.Excase;
import com.umeng.mylianxi.net.CommonSubscriber;
import com.umeng.mylianxi.net.HttpManager;
import com.umeng.mylianxi.utils.RxUtils;

public class ExModle extends BaseModel implements Excase.Modle {
    @Override
    public void getexd(final Callback callback) {
        addDisposable(
                HttpManager.getInstance().getService().getEx()
                .compose(RxUtils.<ExBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<ExBean>(callback) {
                    @Override
                    public void onNext(ExBean exBean) {
                        callback.success(exBean);
                    }
                })
        );
    }
}
