package com.umeng.mylianxi.interfaces.exchange;

import com.umeng.mylianxi.bean.ExBean;
import com.umeng.mylianxi.interfaces.Callback;
import com.umeng.mylianxi.interfaces.IBasePersenter;
import com.umeng.mylianxi.interfaces.IBaseView;
import com.umeng.mylianxi.interfaces.IModel;



public interface Excase {

    //业务
    interface View extends IBaseView{
        void getexbean(ExBean exBean);
    }

    interface Persenter extends IBasePersenter<View>{
        void getexp();
    }

    interface Modle extends IModel{
        void getexd(Callback callback);
    }
}
