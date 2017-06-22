package com.example.myandroiddemo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import model.Order;
import tools.UiUtils;

public class MyOrderList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView newWiew=(ListView)findViewById(R.id.oderTypelist);
        newWiew.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
        setContentView(R.layout.activity_my_order_list);
        datas=new ArrayList<Order>();
        Order o=new Order();
        o.SetContent("dfdfdfdfdfdfdfdfdfdfdfdfdf");
        Order o1=new Order();
        o1.SetContent("犯得上反对法dfdf");
        datas.add(1,o);
        datas.add(1,o1);
    }
    private List<String> getData(){

        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");

        return data;
    }

    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return super.registerReceiver(receiver, filter);
    }

    private  List<Order> datas;


    private class HomeAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return datas.size();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder holder;
            if(convertView==null){
                view=View.inflate(UiUtils.getContext(), R.layout.odertypelist, null);
                holder=new ViewHolder();
                holder.item_icon=(ImageView) view.findViewById(R.id.imageView2);
                holder.list_view=(ListView) view.findViewById(R.id.oderTypelist);
                view.setTag(holder);
            }else{
                view=convertView;
                holder=(ViewHolder) view.getTag();
            }
             return view;
        }
        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }
    static class ViewHolder{
        ImageView item_icon;
        ListView  list_view;

    }
}
