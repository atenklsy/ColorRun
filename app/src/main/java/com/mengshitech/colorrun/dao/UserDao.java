package com.mengshitech.colorrun.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mengshitech.colorrun.bean.UserEntiy;
import com.mengshitech.colorrun.fragment.me.DatabaseHelper;

/**
 * Created by kanghuicong on 2016/7/20  14:21.
 * 515849594@qq.com
 */
public class UserDao {
    /**
     *
     */
    private DatabaseHelper dbHelper;

    public UserDao(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    // 插入
    public void add(String user_id,String user_pwd) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("insert into user (user_id,user_pwd) values(?,?)",
                new Object[] { user_id, user_pwd,});
        db.close();
    }

    //更新数据
    public void update_data(String type,String values,String user_id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update user set ?=? where user_id=?",
                new Object[] { type, values,user_id });
        db.close();
    }

    //查找数据
    public UserEntiy find(String id ) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db
                .rawQuery("select user_id,user_name,user_pwd,user_birthday,user_sex,user_header,user_identity,user_address,user_bankid,user_fullname,user_level,user_health,user_height,user_weight,user_email,user_state,user_otherid,user_phone,user_sign from user where user_id = ?",
                        new String[] { String.valueOf(id) });// 根据编号查找便签信息，并存储到Cursor类中
        if (cursor.moveToNext())// 遍历查找到的便签信息
        {
            return new UserEntiy(
                    cursor.getString(cursor.getColumnIndex("user_id")),
                    cursor.getString(cursor.getColumnIndex("user_name")),
                    cursor.getString(cursor.getColumnIndex("user_pwd")),
                    cursor.getString(cursor.getColumnIndex("user_birthday")),
                    cursor.getString(cursor.getColumnIndex("user_sex")),
                    cursor.getString(cursor.getColumnIndex("user_header")),
                    cursor.getString(cursor.getColumnIndex("user_identity")),
                    cursor.getString(cursor.getColumnIndex("user_address")),
                    cursor.getString(cursor.getColumnIndex("user_bankid")),
                    cursor.getString(cursor.getColumnIndex("user_fullname")),
                    cursor.getString(cursor.getColumnIndex("user_level")),
                    cursor.getString(cursor.getColumnIndex("user_health")),
                    cursor.getString(cursor.getColumnIndex("user_height")),
                    cursor.getString(cursor.getColumnIndex("user_weight")),
                    cursor.getString(cursor.getColumnIndex("user_email")),
                    cursor.getString(cursor.getColumnIndex("user_state")),
                    cursor.getString(cursor.getColumnIndex("user_otherid")),
                    cursor.getString(cursor.getColumnIndex("user_phone")),
                    cursor.getString(cursor.getColumnIndex("user_sign")));
        }
        return null;// 如果没有信息，则返回null
    }
}
