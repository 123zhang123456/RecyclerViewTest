package com.kanxue.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kanxue.beans.ItemBean;
import com.kanxue.recyclerviewtest.R;

import java.util.List;

public class ListViewAdapter  extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    private final List<ItemBean> mData;

    //设置数据
    public ListViewAdapter (List<ItemBean> data){
        this.mData=data;
    }


    //用于创建条目的View
    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //传进去这个view其实就是条目的界面
        //1.拿到view
        //2.创建innerHoler，主要用来复用
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return new InnerHolder(view);
    }

    //这个方法用来绑定holder，一般用来设置数据
    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {

        holder.setData(mData.get(position));
    }


    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mIcon;
        private final TextView mTitle;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
        //找到条目的控件
            mIcon = itemView.findViewById(R.id.list_view_icon);
            mTitle = itemView.findViewById(R.id.list_view_title);

        }

        /*
        * 这个方法用来设置数据
        * */
        public void setData(ItemBean itemBean) {
        mIcon.setImageResource(itemBean.icon);
        mTitle.setText(itemBean.title);

        }
    }
}
