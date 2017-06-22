package com.example.myandroiddemo;

import android.nfc.Tag;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by pan on 2017/5/24.
 */

public class AndroidRequest {


    /** *
     * _url 超链接
     */
    public String Get(String urlStr){
        HttpURLConnection conn=null;//声明连接对象
        InputStream is = null;
        String resultData = "";
        try {
            URL url = new URL(urlStr); //URL对象
            conn = (HttpURLConnection)url.openConnection(); //使用URL打开一个链接,下面设置这个连接
            conn.setRequestMethod("GET"); //使用get请求

            if(conn.getResponseCode()==200){//返回200表示连接成功
                is = conn.getInputStream(); //获取输入流
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bufferReader = new BufferedReader(isr);
                String inputLine  = "";
                while((inputLine = bufferReader.readLine()) != null){
                    resultData += inputLine + "\n";
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    public String Post(String urlStr)
    {
        HttpURLConnection conn=null;
        InputStream is = null;
        String resultData = "";
        try {
            URL url = new URL(urlStr); //URL对象
            conn = (HttpURLConnection)url.openConnection(); //使用URL打开一个链接,下面设置这个连接
            conn.setRequestMethod("POST"); //使用POST请求

            //参数字符串
            String param="";
            HashMap<String,String> _hasmp=getUrlParams(urlStr);
            if(_hasmp!=null&&_hasmp.size()>0) {
                Iterator _iteor = _hasmp.entrySet().iterator();

                while (_iteor.hasNext()) {
                    HashMap.Entry entity = (HashMap.Entry) _iteor.next();
                    param += entity.getKey().toString() + "="
                            + URLEncoder.encode(entity.getValue().toString(), "UTF-8");
                    param += "&";

                }
                param = param.substring(0, param.length() - 1);
            }
//            //参数字符串
//            String param="name="+URLEncoder.encode(name,"UTF-8")//服务器不识别汉字
//                    +"&password="+URLEncoder.encode(password,"UTF-8");

            //用输出流向服务器发出参数，要求字符，所以不能直接用getOutputStream
            DataOutputStream dos=new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(param);
            dos.flush();
            dos.close();

            if(conn.getResponseCode()==200) {//返回200表示相应成功
                is = conn.getInputStream();   //获取输入流
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader bufferReader = new BufferedReader(isr);
                String inputLine = "";
                while ((inputLine = bufferReader.readLine()) != null) {
                    resultData += inputLine + "\n";
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultData;
    }

    private HashMap<String,String> getUrlParams(String url)
    {
        HashMap<String,String> argMap=new HashMap<String,String>();
        int index=url.indexOf("?");//获取首次出现的位置
        if(index>0) {
            String argStr = url.substring(index + 1);//获取从这个位置到最后一位
            String[] argAry = argStr.split("&");//获取传入的参数值

            for (String arg : argAry) {
                String[] argAryT = arg.split("=");
                argMap.put(argAryT[0], argAryT[1]);
            }
        }
        return argMap;

    }

}
