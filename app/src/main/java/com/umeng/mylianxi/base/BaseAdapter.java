package com.umeng.mylianxi.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseAdapter<D> extends RecyclerView.Adapter {
    List<D> mdatas;
    Context context;
    protected IlistClick ilistClick;
    protected IItemViewClick iItemViewClick;
    public void addItemViewClick(IItemViewClick click){
        this.iItemViewClick = click;
    }
    public BaseAdapter(Context context, List<D> datas){
        this.context=context;
        mdatas=datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getLayout(), parent, false);
         VH vh=new VH(view);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ilistClick!=null){
                    ilistClick.item(vh.getLayoutPosition());
                }
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Data(mdatas.get(position), (VH) holder);
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    protected  List<D> getData(){
        return mdatas;
    }

    protected abstract int getLayout();

    protected abstract void Data(D data,VH vh);

    public void setIlistClick(IlistClick ilistClick) {
        this.ilistClick = ilistClick;
    }

    public interface IlistClick{
        void item(int pos);
    }
    public interface IItemViewClick<D>{
        //条目中的元素点击
        void itemViewClick(int viewid, D data);
    }

    public class VH extends RecyclerView.ViewHolder{
           SparseArray views= new SparseArray();
        public VH(@NonNull View itemView) {
            super(itemView);
        }
        //查找item的view
        public View getViewByid(int id){
            View view= (View) views.get(id);
            if (view==null){
                view=itemView.findViewById(id);
                views.append(id,view);
            }
            return view;
        }
    }
}
