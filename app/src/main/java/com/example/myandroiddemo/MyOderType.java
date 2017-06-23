package com.example.myandroiddemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Order;
import tools.MyBaseAdapter;
import tools.UiUtils;

public class MyOderType extends AppCompatActivity {
    private SongAdapter songAdapter;
    private ListView mListView;
    private ListView mListView1;

    private ArrayList songArrayList;
    private HashMap songMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_oder_type);


        songArrayList = new ArrayList();
        songMap = new HashMap();
        songMap.put("image",R.mipmap.ic_launcher);
        songMap.put("singer","林心如");
        songMap.put("songInfo","一万个舍不得");
        songArrayList.add(songMap);





        mListView =(ListView)findViewById(R.id.mListView);
        mListView1 =(ListView)findViewById(R.id.mListView1);
        if(songAdapter==null){
            songAdapter = new SongAdapter(this,songArrayList);
        }else {
            //刷新适配器,不用每次都new SongAdapter(this,songArrayList)
            songAdapter.notifyDataSetChanged();
        }
        mListView.setAdapter(songAdapter);
        mListView1.setAdapter(songAdapter);
    }
    class SongAdapter extends MyBaseAdapter<ArrayList> {
        private Context context;
        SongAdapter(Context c, ArrayList arrayList){
            super(arrayList);
            context=c;
        }
        //重用了convertView，很大程度上的减少了内存的消耗。通过判断convertView是否为null，
        // 是的话就需要产生一个视图出来，然后给这个视图数据，最后将这个视图返回给底层，呈献给用户。
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView==null){
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView =inflater.inflate(R.layout.odertypelist,null);

                viewHolder = new ViewHolder();
                viewHolder.singerImageView =(ImageView)convertView.findViewById(R.id.singerImageView);
                viewHolder.songInfoTextView =(TextView)convertView.findViewById(R.id.songInfoTextView);
                viewHolder.singerTextView =(TextView)convertView.findViewById(R.id.singerTextView);
                viewHolder.deleteSongBtn =(Button)convertView.findViewById(R.id.deleteSongBtn);
                viewHolder.downLoadSongBtn=(Button)convertView.findViewById(R.id.downLoadSongBtn);

                convertView.setTag(viewHolder);
                viewHolder.deleteSongBtn.setTag(position);
                viewHolder.downLoadSongBtn.setTag(position);
            }else {
                viewHolder =(ViewHolder)convertView.getTag();
            }
            viewHolder.singerImageView.setImageResource((Integer)
                    ((HashMap)songArrayList.get(position)).get("image"));
            viewHolder.singerTextView.setText((String)((HashMap)songArrayList.get(position)).get("singer"));
            viewHolder.songInfoTextView.setText((String)((HashMap)songArrayList.get(position)).get("songInfo"));

            viewHolder.deleteSongBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dePosition = (Integer)v.getTag();
                    songArrayList.remove(dePosition);
                    songAdapter.notifyDataSetChanged();
                }
            });
            viewHolder.downLoadSongBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int downLoadPosition =(Integer)v.getTag();
                    String singerStr =(String)((HashMap)songArrayList.get(downLoadPosition)).get("singer");
                    String songStr =(String)((HashMap)songArrayList.get(downLoadPosition)).get("songInfo");
                    String toastStr =singerStr+songStr;
                    Toast.makeText(getApplicationContext(),"你准备下载"+toastStr,Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }
    //避免了就是每次在getVIew的时候，都需要重新的findViewById，
    // 重新找到控件，然后进行控件的赋值以及事件相应设置。这样其实在做重复的事情)
    class ViewHolder{
        ImageView singerImageView;
        TextView songInfoTextView;
        TextView singerTextView;
        Button deleteSongBtn;
        Button downLoadSongBtn;
    }
}
