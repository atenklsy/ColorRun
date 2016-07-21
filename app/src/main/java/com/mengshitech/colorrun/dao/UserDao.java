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
    public void add(UserEntiy user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(
                "insert into user(userid,nickname,userpwd,sex,phone,email,address,autograph) values(?,?,?,?,?,?,?,?)",
                new Object[] { user.getUserid(), user.getNickname(),
                        user.getUserpwd(), user.getSex(),
                        user.getPhone(), user.getEmail(),
                        user.getAddress(), user.getAutograph() });
        db.close();
    }

    //更新昵称
    public void update_nickname(UserEntiy user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update  user set nickname=? where userid=?",
                new Object[] { user.getNickname(), user.getUserid() });
        db.close();
    }

    //更新性别
    public void update_sex(UserEntiy user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update  user set sex=? where userid=?",
                new Object[] { user.getSex(), user.getUserid() });
        db.close();
    }

    //更新电话号码
    public void update_phone(UserEntiy user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update  user set phone=? where userid=?",
                new Object[] { user.getPhone(), user.getUserid() });
        db.close();
    }

    //更新邮箱
    public void update_email(UserEntiy user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update  user set emai=? where userid=?",
                new Object[] { user.getEmail(), user.getUserid() });
        db.close();
    }

    //更新地区
    public void update_adddress(UserEntiy user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update  user set address=? where userid=?",
                new Object[] { user.getAddress(), user.getUserid() });
        db.close();
    }

    //更新签名
    public void update_autograph(UserEntiy user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL("update  user set autograph=? where userid=?",
                new Object[] { user.getAutograph(), user.getUserid() });
        db.close();
    }

    public UserEntiy find(int id ) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db
                .rawQuery("select userid,nickname,userpwd,sex,phone,image,address,email,autograph from user where userid = ?",
                        new String[] { String.valueOf(id) });// 根据编号查找便签信息，并存储到Cursor类中
        if (cursor.moveToNext())// 遍历查找到的便签信息
        {

            return new UserEntiy(cursor.getString(cursor.getColumnIndex("userid")),
                    cursor.getString(cursor.getColumnIndex("nickname")),
                    cursor.getString(cursor.getColumnIndex("userpwd")),
                    cursor.getString(cursor.getColumnIndex("sex")),
                    cursor.getString(cursor.getColumnIndex("address")),
                    cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("autograph")),
                    cursor.getString(cursor.getColumnIndex("phone")),
                    cursor.getBlob(cursor.getColumnIndex("image")));
        }
        return null;// 如果没有信息，则返回null
    }
}
