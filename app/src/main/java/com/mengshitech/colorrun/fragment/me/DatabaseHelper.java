package com.mengshitech.colorrun.fragment.me;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kanghuicong on 2016/7/20  14:18.
 * 515849594@qq.com
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    static String name = "user.db";
    static int dbVersion = 1;

    public DatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    // ֻ�ڴ�����ʱ����һ��
    public void onCreate(SQLiteDatabase db) {
        // �û�,ģʽѡ����ʷ��ݣ���!
        db.execSQL("create table user(userid varchar(20) primary key,nickname varchar(20),userpwd varchar(20),sex varchar(2),phone varchar(20),image blob,email varchar(50),address varchar(50),autograph varchar(100))");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
