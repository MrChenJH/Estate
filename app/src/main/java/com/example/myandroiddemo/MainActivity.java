package com.example.myandroiddemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView txt_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_content=(TextView)findViewById(R.id.txt_content);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
    }

    //点击提示框
    public void btn_start_onclick(View v)
    {
        Toast.makeText(this,"I'm Start Android Studio!!",Toast.LENGTH_LONG).show();
    }

    //点击后TextView 显示字体红色
    public void btn_content1_onclick(View v)
    {
        txt_content.setText("I'm FontColor of Red");
        txt_content.setTextColor(Color.rgb(225,0,0));
        txt_content.setTextSize(32);
    }

    //点击后TextView 显示字体蓝色
    public void btn_content2_onclick(View v)
    {
        txt_content.setText("I'm FontColor of Red");
        txt_content.setTextColor(Color.rgb(0,0,225));
        txt_content.setTextSize(48);
    }

    //打开新的页面
    public void btn_open_click(View v){
        Intent intent=new Intent();
        intent.setClass(MainActivity.this,ScrollingActivity.class);
        startActivity(intent);
    }

    //照相机功能
    public void btn_camera_onclick(View v){
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }

    public void btn_sendurl_onclick(View v)
    {
        AndroidRequest _arequest=new AndroidRequest();
        String aa=_arequest.Get("http://192.168.1.177:8056/WebService.asmx/GetGrid");
        Toast.makeText(this,aa,Toast.LENGTH_LONG).show();

        //String bb=_arequest.Post("http://192.168.1.177:8056/WebService.asmx/GetGrid");
    }
}
