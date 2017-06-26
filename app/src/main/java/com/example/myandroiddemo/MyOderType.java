package com.example.myandroiddemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import static android.R.id.message;

public class MyOderType extends Activity {
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
        songMap.put("singer","陈回禀的上报考勤工单");
        songMap.put("songInfo","06-22 06:50 - 06-22 07:10");
        songMap.put("color","#DD017F");
        songArrayList.add(songMap);

        songMap = new HashMap();
        songMap.put("image",R.mipmap.ic_launcher);
        songMap.put("singer","倒灶反对犯得上房贷首付");
        songMap.put("songInfo","06-22 06:50 - 06-22 07:10");
        songMap.put("color","#ff669900");
        songArrayList.add(songMap);

        songMap = new HashMap();
        songMap.put("image",R.mipmap.ic_launcher);
        songMap.put("singer","倒灶反对犯得上房贷首付");
        songMap.put("songInfo","06-22 06:50 - 06-22 07:10");
        songMap.put("color","#ff669900");
        songArrayList.add(songMap);

        songMap = new HashMap();
        songMap.put("image",R.mipmap.ic_launcher);
        songMap.put("singer","多福多寿犯得上犯得上犯得上");
        songMap.put("songInfo","06-22 06:50 - 06-22 07:10");
        songMap.put("color","#ff33b5e5");
        songArrayList.add(songMap);

        songMap = new HashMap();
        songMap.put("image",R.mipmap.ic_launcher);
        songMap.put("singer","多福多寿犯得上犯得上犯得上");
        songMap.put("songInfo","06-22 06:50 - 06-22 07:10");
        songMap.put("color","#ff33b5e5");
        songArrayList.add(songMap);

        mListView =(ListView)findViewById(R.id.mListView);
       if(songAdapter==null){
            songAdapter = new SongAdapter(this,songArrayList);
        }else {
            //刷新适配器,不用每次都new SongAdapter(this,songArrayList)
            songAdapter.notifyDataSetChanged();
        }
        mListView.setAdapter(songAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int index,
                                    long arg3) {
                onListItemClick(index,v);
            }
        });
        Button     Ib=(Button)findViewById(R.id.title_bar_left);
        Ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                in.setClass(MyOderType.this,ScrollingActivity.class);
                startActivity(in);
            }
        });

        Button     Rb=(Button)findViewById(R.id.title_bar_right);
        Rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                in.setClass(MyOderType.this,ScrollingActivity.class);
                startActivity(in);
            }
        });

    }
    void onListItemClick(int index,View v) {
        Intent intent = null;
        intent = new Intent(MyOderType.this, DeatilActivity.class);
        this.startActivity(intent);
        TextView  so=  (TextView)v.findViewById(R.id.songInfoTextView);
        String te= so.getText().toString();
        Bundle bundle = new Bundle();
		/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/
        bundle.putString("Name", te);
        /*把bundle对象assign给Intent*/
        intent.putExtras(bundle);
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

                viewHolder.songInfoTextView =(TextView)convertView.findViewById(R.id.songInfoTextView);
                viewHolder.singerTextView =(TextView)convertView.findViewById(R.id.singerTextView);


                convertView.setTag(viewHolder);
                viewHolder.songInfoTextView.setTag(position);

            }else {
                viewHolder =(ViewHolder)convertView.getTag();
            }

            viewHolder.singerTextView.setText((String)((HashMap)songArrayList.get(position)).get("singer"));
            viewHolder.songInfoTextView.setText((String)((HashMap)songArrayList.get(position)).get("songInfo"));
            viewHolder.songInfoTextView.setTextColor(Color.parseColor((String)((HashMap)songArrayList.get(position)).get("color")));
            viewHolder.singerTextView.setTextColor(Color.parseColor((String)((HashMap)songArrayList.get(position)).get("color")));


            return convertView;
        }
    }

    //避免了就是每次在getVIew的时候，都需要重新的findViewById，
    // 重新找到控件，然后进行控件的赋值以及事件相应设置。这样其实在做重复的事情)
    class ViewHolder{

        TextView songInfoTextView;
        TextView singerTextView;

    }
}
