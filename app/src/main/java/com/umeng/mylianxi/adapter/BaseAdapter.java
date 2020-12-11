package com.umeng.mylianxi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.umeng.mylianxi.R;
import com.umeng.mylianxi.bean.ExBean;

import java.util.List;

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    Context context;
    private List<ExBean.DataBean.ListBean> beans;

    public BaseAdapter(Context context, List<ExBean.DataBean.ListBean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.adater_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder holder1=holder;
        ExBean.DataBean.ListBean listBean = beans.get(position);
        holder1.textView.setText(listBean.getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.text_qq);
        }
    }
}
