package com.example.myandroiddemo;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;

public class DeatilActivity extends TabActivity {
 private TabHost tabhost;

  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deatil);
        TabHost tabHost = getTabHost();


        TabHost.TabSpec page1 = tabHost.newTabSpec("tab1")
                .setIndicator("")
                .setContent(R.id.detialView);
        tabHost.addTab(page1);

        TabHost.TabSpec page2 = tabHost.newTabSpec("tab2")
                .setIndicator("")
                .setContent(R.id.detialEdit);
        tabHost.addTab(page2);

      tabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.worksheet);
      tabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.executor);
      Button     Ib=(Button)findViewById(R.id.title_bar_left);
      Ib.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent in=new Intent();
              in.setClass(DeatilActivity.this,MyOderType.class);
              startActivity(in);
          }
      });

      Button     Rb=(Button)findViewById(R.id.title_bar_right);
      Rb.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent in=new Intent();
              in.setClass(DeatilActivity.this,ScrollingActivity.class);
              startActivity(in);
          }
      });
 }
}
