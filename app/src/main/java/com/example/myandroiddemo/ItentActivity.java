package com.example.myandroiddemo;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Locale;

public class ItentActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private ImageButton imagebtnspeak;
    private EditText edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itent);

        imagebtnspeak=(ImageButton)findViewById(R.id.img_btn_speak);
        edittext=(EditText)findViewById(R.id.editText);
        imagebtnspeak.setOnClickListener(new MyOnClickListener());

        tts=new TextToSpeech(this,new MyOnInitialListener());
    }

    class MyOnInitialListener implements TextToSpeech.OnInitListener {

        @Override
        public void onInit(int status) {
            tts.setEngineByPackageName("com.iflytek.vflynote");
            tts.setLanguage(Locale.CHINESE);

        }

    }

    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.img_btn_speak:
                    tts.speak(edittext.getEditableText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                    break;

                default:
                    break;
            }

        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (tts != null) { // 关闭TTS引擎
            tts.shutdown();
        }
    }
}
