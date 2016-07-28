package com.mengshitech.colorrun.utils;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/**
 * Created by kanghuicong on 2016/7/22  11:20.
 * 515849594@qq.com
 */
public class HttpUtils {

    public static void getNewsJSON(final String url, final Handler handler) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection conn;
                InputStream is;
                try {
                    conn = (HttpURLConnection) new URL(url).openConnection();
                    conn.setRequestMethod("GET");
                    is = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(is));
                    String line = "";
                    StringBuilder result = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    Message msg = new Message();
                    msg.obj = result.toString();
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void setPicBitmap(final ImageView ivPic, final String pic_url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection conn = (HttpURLConnection) new URL(
                            pic_url).openConnection();
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    ivPic.setImageBitmap(bitmap);
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 客户端发送验证请求，服务器端返回状态
    public static String sendHttpClientPost(String path,
                                            Map<String, String> map, String encode) {
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry
                        .getValue()));
            }
        }
        try {
            //
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, encode);
            // 设置请求体
            HttpPost httpPost = new HttpPost(path);
            httpPost.setEntity(entity);
            // 创建http客户端
            DefaultHttpClient client = new DefaultHttpClient();
            // 请求超时
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 3000);
            // 读取超时
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 8000);

            HttpResponse httpResponse = client.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                return changeInputStream(httpResponse.getEntity().getContent(),
                        encode);
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "timeout";
    }

    /**
     * @param inputStream
     * @param encode
     * @return
     */
    // 将服务器端返回的字节流转换成字符
    public static String changeInputStream(InputStream inputStream,
                                           String encode) {
        // TODO Auto-generated method stub
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        String result = "";
        if (inputStream != null) {
            try {
                while ((len = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, len);
                }
                result = new String(outputStream.toByteArray(), encode);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return result;
    }

    public static Bitmap GetImage(String imagePath) {

        try {

            URL url = new URL(imagePath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);
            conn.connect();
            if (conn.getResponseCode() == 200) {
                InputStream is = conn.getInputStream();
                Bitmap bm = BitmapFactory.decodeStream(is);

                return bm;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
