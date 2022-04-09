package com.kanxue.recyclerviewtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kanxue.adapters.ListViewAdapter;
import com.kanxue.beans.Datas;
import com.kanxue.beans.ItemBean;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;
    private ArrayList<ItemBean> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        mList = this.findViewById(R.id.recycler_view);

        //准备数据:实际开发中，数据从网络获取
        initData();

    }
/**/
    private void initData() {
        //List<DataBean> --->aDapter-->setAdapter-->显示数据
        //创建数据集合
        mData = new ArrayList<>();

        //模拟模拟数据
        for (int i = 0; i < Datas.icons.length;i++) {
        //创建数据对象
        ItemBean data= new ItemBean();
        data.icon=Datas.icons[i];
        data.title="我是第 "+i+" 个条目";
        //添加到集合里
        mData.add(data);
        }

        //Recycler需要设置样式，其实就是设置布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);

        mList.setLayoutManager(linearLayoutManager);
        //创建适配器
        ListViewAdapter adapter=new ListViewAdapter(mData);
        // 设置到RecyclerView中去
        mList.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            //Listview部分
            case R.id.list_view_vertical_stander:
                break;
            case R.id.list_view_vertical_reverse:
                break;
            case R.id.list_view_horizontal_stander:
                break;
            case R.id.list_view_horizontal_reverse:
                break;
            //GridView部分

            case R.id.grid_view_vertical_stander:
                break;
            case R.id.grid_view_vertical_reverse:
                break;
            case R.id.grid_view_horizontal_stander:
                break;
            case R.id.grid_view_horizontal_reverse:
                break;

            //瀑布流部分
            case R.id.stagger_view_vertical_stander:
                break;
            case R.id.stagger_view_vertical_reverse:
                break;
            case R.id.stagger_view_horizontal_stander:
                break;
            case R.id.stagger_view_horizontal_reverse:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}