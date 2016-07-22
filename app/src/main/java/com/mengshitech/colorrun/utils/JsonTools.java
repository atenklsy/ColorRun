package com.mengshitech.colorrun.utils;

import com.mengshitech.colorrun.bean.UserEntiy;

import org.json.JSONException;
import org.json.JSONObject;

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
}
