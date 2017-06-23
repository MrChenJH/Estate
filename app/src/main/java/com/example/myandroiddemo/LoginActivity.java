package com.example.myandroiddemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private EditText userid;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 开始登录初始化
        userid = (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.password);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());

    }

    public void sign_onclick(View v) {
//        String url = "http://192.168.1.177:8056/WebService.asmx/GetGrid";
//        if (userid.getText().toString().equals("pcj")) {
//            AndroidRequest _arequest = new AndroidRequest();
//            String resultdata = _arequest.Get(url);
//            if (resultdata != "") {
//                String pass=password.getText().toString().trim();
//                String pps="123456".trim();
//                if (pass.equals(pps)) {
//                    Intent intent = new Intent();
//                    intent.setClass(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(this, "请输入正确的用户名密码登录！！", Toast.LENGTH_LONG).show();
//                }
//            } else {
//                Toast.makeText(this, "请输入正确的用户名密码登录！！", Toast.LENGTH_LONG).show();
//            }
//        } else {
//            Toast.makeText(this, "请输入正确的用户名密码登录！！", Toast.LENGTH_LONG).show();
//        }
        Intent intent = new Intent();
        intent.setClass(LoginActivity.this, ScrollingActivity.class);
        startActivity(intent);

    }

}

