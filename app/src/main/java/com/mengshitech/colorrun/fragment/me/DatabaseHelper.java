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

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(user_id varchar(20) primary key, user_name varchar(50), user_pwd varchar(20), " +
                "user_birthday varchar(10), user_sex varchar(10), user_header varchar(50), user_identity varchar(20), " +
                "user_address varchar(50), user_bankid varchar (50), user_fullname varchar(20), user_level varchar(10), " +
                "user_health varchar(10), user_height varchar(10), user_weight varchar(10), user_email varchar(20), " +
                "user_state varchar(10), user_otherid varchar(10),user_sign varchar(100),user_phone varchar(15))");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
