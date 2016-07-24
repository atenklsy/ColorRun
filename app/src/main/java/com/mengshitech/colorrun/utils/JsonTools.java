package com.mengshitech.colorrun.utils;

import android.util.Log;

import com.mengshitech.colorrun.bean.OrderEntity;
import com.mengshitech.colorrun.bean.UserEntiy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanghuicong on 2016/7/22  13:55.
 * 515849594@qq.com
 */
public class JsonTools {

    public static UserEntiy getUserInfo(String key, String jsonString)
            throws JSONException {
        UserEntiy info = new UserEntiy();
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONObject userObject = jsonObject.getJSONObject(key);

        info.setUser_address(userObject.getString("user_id"));
        info.setUser_email(userObject.getString("user_email"));
        info.setUser_header(userObject.getString("user_header"));
        info.setUser_height(userObject.getString("user_height"));
        info.setUser_id(userObject.getString("user_id"));
        info.setUser_name(userObject.getString("user_name"));
        info.setUser_pwd(userObject.getString("user_pwd"));
        info.setUser_sex(userObject.getString("user_sex"));
        info.setUser_state(userObject.getString("user_state"));
        info.setUser_weight(userObject.getString("user_weight"));
        info.setUser_sign(userObject.getString("user_sign"));
        info.setUser_phone(userObject.getString("user_phone"));

        return info;
    }

    public static List<OrderEntity> getOrderInfo(String key, String jsonString)
            throws JSONException {
        Log.i("jsonString",jsonString);
        List<OrderEntity> list = new ArrayList<OrderEntity>();
        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray jsonArray=jsonObject.getJSONArray(key);
        for(int i=0;i<jsonArray.length();i++){
            OrderEntity info = new OrderEntity();
            JSONObject orderObject = jsonArray.getJSONObject(i);
            info.setLerun_title(orderObject.getString("lerun_title"));
            info.setLerun_time(orderObject.getString("lerun_time"));
            info.setLerun_type(orderObject.getString("lerun_type"));
            info.setLerun_poster(orderObject.getString("lerun_poster"));
            info.setLerun_state(orderObject.getString("lerun_state"));
            info.setLerun_id(orderObject.getString("lerun_id"));
            info.setLerun_address(orderObject.getString("lerun_address"));
            list.add(info);
        }

        Log.i("list的大小",list.size()+"");
        return list;
    }
}
